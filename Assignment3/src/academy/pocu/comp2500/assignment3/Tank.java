package academy.pocu.comp2500.assignment3;

import java.util.LinkedList;

public class Tank extends Unit implements IMovable, IThinkable {
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

    public Tank(final IntVector2D position) {
        super(UNIT_TYPE, HP, position);
        this.tankMode = ETankMode.TANK;
        this.isMoveRight = true;
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


    private Unit searchMinHpAttackTargetOrNull(final boolean isNeedOnlyExist) {
        final LinkedList<Unit>[][] map = SimulationManager.getInstance().getMap();
        Unit minHp = null;

        for (final ImmutableIntVector2D offset : CAN_ATTACK_AREA_OFFSET) {
            final int x = getPosition().getX() + offset.x();
            final int y = getPosition().getY() + offset.y();

            if (!SimulationManager.isValidPosition(map, x, y)) {
                continue;
            }

            if (map[y][x].size() == 0) {
                continue;
            }

            for (final Unit unit : map[y][x]) {
                if (unit == this) {
                    continue;
                }

                for (final EUnitType unitType : CAN_VISION_UNIT_TYPES) {
                    if (unit.getUnitType() == unitType) {
                        if (minHp == null || minHp.getHp() > unit.getHp()) {
                            minHp = unit;

                            if (isNeedOnlyExist) {
                                return minHp;
                            }
                        }
                    }
                }
            }
        }

        return minHp;
    }

    private boolean isExistVisionTarget() {
        final LinkedList<Unit>[][] map = SimulationManager.getInstance().getMap();
        Unit minHp = null;

        for (int y = getPosition().getY() - VISION; y <= getPosition().getY() + VISION; ++y) {
            for (int x = getPosition().getX() - VISION; x <= getPosition().getX() + VISION; ++x) {
                if (!SimulationManager.isValidPosition(map, x, y)) {
                    continue;
                }

                if (map[y][x].size() == 0) {
                    continue;
                }

                for (final Unit unit : map[y][x]) {
                    if (unit == this) {
                        continue;
                    }

                    for (final EUnitType unitType : CAN_VISION_UNIT_TYPES) {
                        if (unit.getUnitType() == unitType) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public EAction think() {
        // attack
        if (searchMinHpAttackTargetOrNull(true) != null) {
            if (isCanAttackMode()) {
                return EAction.ATTACK;
            } else {
                changeMode();
                return EAction.DO_NOTHING;
            }
        }

        // vision
        if (isExistVisionTarget()) {
            if (isCanAttackMode() == false) {
                changeMode();
            }

            return EAction.DO_NOTHING;
        }

        if (isCanMoveMode()) {
            return EAction.MOVE;
        } else {
            changeMode();
            return EAction.DO_NOTHING;
        }
    }

    // 시그내처 불변
    public AttackIntent attack() {
        // 1 현재 공성 모드가 아닌 경우 공성 모드로 변경
        // 2 가장 약한 유닛이 있는 타일을 공격
        // 3 북쪽에 유닛이 있다면 그 타일을 공격. 그렇지 않을 경우 시계 방향으로 검색하다가 찾은 유닛의 타일을 공격
        // 전차가 시야 안에서 적을 찾으면 공성 모드로 변환하여 공격할 준비를 합니다.

        final Unit minHp = searchMinHpAttackTargetOrNull(false);

        assert (minHp != null);

        return new AttackIntent(this, new ImmutableIntVector2D(minHp.getPosition().getX(), minHp.getPosition().getY()));
    }

    @Override
    public void move() {
        // 전차가 시야 안에서 적을 찾지 못하면 다음의 이동 규칙을 따릅니다. (역시 우선순위 순)
        //
        // 1 월드의 동쪽(오른쪽) 끝까지 이동
        // 2 월드의 서쪽(왼쪽) 끝까지 이동
        // 3 시야 안에서 적을 발견할 때까지 1 - 2를 반복

        final LinkedList<Unit>[][] map = SimulationManager.getInstance().getMap();
        final int x;
        final int y = getPosition().getY();

        if (isMoveRight) {
            x = getPosition().getX() + 1;

            if (SimulationManager.isValidPosition(map, x, y) == false) {
                isMoveRight = false;
                getPosition().setX(getPosition().getX() - 1);
                return;
            }

            getPosition().setX(x);
            return;
        } else {
            assert (isMoveRight == false);

            x = getPosition().getX() - 1;

            if (SimulationManager.isValidPosition(map, x, y) == false) {
                isMoveRight = true;
                getPosition().setX(getPosition().getX() + 1);
                return;
            }

            getPosition().setX(x);
            return;
        }
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
}
