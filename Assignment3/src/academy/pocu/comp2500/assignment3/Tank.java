package academy.pocu.comp2500.assignment3;

import java.util.LinkedList;

public final class Tank extends Unit implements IMovable, IThinkable {
    // 전차에는 두 가지 모드(mode)가 있습니다.
    //
    // 전차(tank) 모드 (기본 모드): 전차 모드인 경우, 이동할 수 있으나 공격할 수는 없습니다.
    // 공성(siege) 모드: 공성 모드인 경우, 이동할 수 없으나 공격할 수는 있습니다.
    // 전차는 모드를 바꿀 때 1 프레임을 소모합니다.

    // 공성 모드인 전차는 탱크 모드일 때보다 2배의 피해를 받습니다.

    public static final char SYMBOL = 'T';
    private static final EUnitType UNIT_TYPE = EUnitType.GROUND;
    private static final int VISION = 3;
    private static final int ATTACK_AREA_OF_EFFECT = 1;
    private static final int ATTACK_POINT = 8;
    private static final int HP = 85;
    private static final EUnitType[] CAN_ATTACK_UNIT_TYPES = {EUnitType.GROUND, EUnitType.MINE};
    private static final ImmutableIntVector2D[] CAN_ATTACK_AREA_OFFSET = {
            new ImmutableIntVector2D(0, -2), // up
            new ImmutableIntVector2D(1, -2),

            new ImmutableIntVector2D(2, -1),
            new ImmutableIntVector2D(2, 0), // right
            new ImmutableIntVector2D(2, 1),

            new ImmutableIntVector2D(1, 2),
            new ImmutableIntVector2D(0, 2), // down
            new ImmutableIntVector2D(-1, 2),

            new ImmutableIntVector2D(-2, 1),
            new ImmutableIntVector2D(-2, 0), // left
            new ImmutableIntVector2D(-2, -1),

            new ImmutableIntVector2D(-1, -2),
    };
    private static final EUnitType[] CAN_VISION_UNIT_TYPES = {EUnitType.GROUND};


    private ETankMode tankMode;
    private boolean isMoveRight;
    private ImmutableIntVector2D targetOrNull;


    public Tank(final IntVector2D position) {
        super(UNIT_TYPE, HP, position);
        this.tankMode = ETankMode.TANK;
        this.isMoveRight = true;
    }

    public void think() {
        // attack
        targetOrNull = searchMinHpAttackTargetOrNull();
        if (targetOrNull != null) {
            if (isCanAttackMode()) {
                setAction(EAction.ATTACK);
                return;
            }

            changeMode();
            setAction(EAction.DO_NOTHING);
            return;
        }

        // vision
        if (isExistVisionTarget()) {
            if (isCanAttackMode() == false) {
                changeMode();
            }

            setAction(EAction.DO_NOTHING);
            return;
        }

        if (isCanMoveMode()) {
            setAction(EAction.MOVE);
            return;
        }

        changeMode();
        setAction(EAction.DO_NOTHING);
        return;
    }

    @Override
    public void move() {
        // 전차가 시야 안에서 적을 찾지 못하면 다음의 이동 규칙을 따릅니다. (역시 우선순위 순)
        //
        // 1 월드의 동쪽(오른쪽) 끝까지 이동
        // 2 월드의 서쪽(왼쪽) 끝까지 이동
        // 3 시야 안에서 적을 발견할 때까지 1 - 2를 반복

        if (getAction() != EAction.MOVE) {
            return;
        }

        final int preX = getPosition().getX();
        final int preY = getPosition().getY();

        if (isMoveRight) {
            final int postX = preX + 1;

            if (SimulationManager.getInstance().isValidPosition(postX, preY) == false) {
                isMoveRight = false;
                getPosition().setX(preX - 1);

                SimulationManager.getInstance().replacePosition(this, preX, preY);
                return;
            }

            getPosition().setX(postX);

            SimulationManager.getInstance().replacePosition(this, preX, preY);
            return;
        }

        assert (isMoveRight == false);
        {
            final int postX = preX - 1;

            if (SimulationManager.getInstance().isValidPosition(postX, preY) == false) {
                isMoveRight = true;
                getPosition().setX(preX + 1);

                SimulationManager.getInstance().replacePosition(this, preX, preY);
                return;
            }

            getPosition().setX(postX);

            SimulationManager.getInstance().replacePosition(this, preX, preY);
            return;
        }
    }

    // 시그내처 불변
    public AttackIntent attack() {
        // 1 현재 공성 모드가 아닌 경우 공성 모드로 변경
        // 2 가장 약한 유닛이 있는 타일을 공격
        // 3 북쪽에 유닛이 있다면 그 타일을 공격. 그렇지 않을 경우 시계 방향으로 검색하다가 찾은 유닛의 타일을 공격
        // 전차가 시야 안에서 적을 찾으면 공성 모드로 변환하여 공격할 준비를 합니다.

        if (getAction() != EAction.ATTACK) {
            return new AttackIntent(this, false, ImmutableIntVector2D.MINUS_ONE);
        }

        assert (targetOrNull != null);

        return new AttackIntent(this, false, targetOrNull);
    }

    // 시그내처 불변
    public void onAttacked(int damage) {
        if (tankMode == ETankMode.SIEGE) {
            damage *= 2;
        }

        subHp(damage);
    }

    // 시그내처 불변
    public void onSpawn() {
        SimulationManager.getInstance().registerThinkable(this);
        SimulationManager.getInstance().registerMovable(this);
    }

    // 시그내처 불변
    public char getSymbol() {
        return SYMBOL;
    }

    public int getAttackPoint() {
        return ATTACK_POINT;
    }

    public int getAttackAreaOfEffect() {
        return ATTACK_AREA_OF_EFFECT;
    }

    public EUnitType[] getCanAttackUnitTypes() {
        return CAN_ATTACK_UNIT_TYPES;
    }

    public boolean isIThinkable() {
        return true;
    }

    public boolean isIMovable() {
        return true;
    }

    public boolean isICollision() {
        return false;
    }


    private boolean isCanAttackMode() {
        return tankMode == ETankMode.SIEGE;
    }

    private boolean isCanMoveMode() {
        return tankMode == ETankMode.TANK;
    }

    private void changeMode() {
        tankMode = tankMode == ETankMode.TANK ? ETankMode.SIEGE : ETankMode.TANK;
    }

    private ImmutableIntVector2D searchMinHpAttackTargetOrNull() {
        final Map2DCanSamePosition<Unit> map = SimulationManager.getInstance().getMap();
        Unit minHp = null;

        for (final ImmutableIntVector2D offset : CAN_ATTACK_AREA_OFFSET) {
            final int x = getPosition().getX() + offset.x();
            final int y = getPosition().getY() + offset.y();

            if (!SimulationManager.getInstance().isValidPosition(x, y)) {
                continue;
            }

            if (map.getHashSet(y, x).size() == 0) {
                continue;
            }

            for (final Unit unit : map.getHashSet(y, x)) {
                if (unit == this) {
                    continue;
                }

                for (final EUnitType canVisionUnitType : CAN_VISION_UNIT_TYPES) {
                    if (unit.getUnitType() == canVisionUnitType) {
                        if (minHp == null || minHp.getHp() > unit.getHp()) {
                            minHp = unit;
                        }

                        break;
                    }
                }
            }
        }

        if (minHp == null) {
            return null;
        }

        return new ImmutableIntVector2D(minHp.getPosition());
    }

    private boolean isExistVisionTarget() {
        final Map2DCanSamePosition<Unit> map = SimulationManager.getInstance().getMap();

        final int minY = getPosition().getY() - VISION;
        final int minX = getPosition().getX() - VISION;

        final int maxY = getPosition().getY() + VISION;
        final int maxX = getPosition().getX() + VISION;

        for (int y = minY; y <= maxY; ++y) {
            for (int x = minX; x <= maxX; ++x) {
                if (!SimulationManager.getInstance().isValidPosition(x, y)) {
                    continue;
                }

                if (map.getHashSet(y, x).size() == 0) {
                    continue;
                }

                for (final Unit unit : map.getHashSet(y, x)) {
                    if (unit == this) {
                        continue;
                    }

                    for (final EUnitType canVisionUnitType : CAN_VISION_UNIT_TYPES) {
                        if (unit.getUnitType() == canVisionUnitType) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
}
