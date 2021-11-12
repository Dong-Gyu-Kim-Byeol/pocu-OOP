package academy.pocu.comp2500.assignment3;

import java.util.LinkedList;

public final class Wraith extends Unit implements IMovable, IThinkable {
    // 망령은 공격을 받으면 즉시 가동되는 특수 방어막을 가지고 있습니다.
    // 한 번 가동된 방어막은 현재 프레임이 끝날 때까지 지속되어 망령은 피해를 입지 않습니다.
    // 다음 프레임부터는 공격을 받으면 피해를 입습니다.

    public static final char SYMBOL = 'W';
    private static final EUnitType UNIT_TYPE = EUnitType.AIR;
    private static final int VISION = 4;
    private static final int ATTACK_AREA_OF_EFFECT = 0;
    private static final int ATTACK_POINT = 6;
    private static final int HP = 80;
    private static final EUnitType[] CAN_ATTACK_UNIT_TYPES = {EUnitType.GROUND, EUnitType.AIR, EUnitType.MINE};
    private static final ImmutableIntVector2D[] CAN_ATTACK_AREA_OFFSET = {
            new ImmutableIntVector2D(0, 0),
            new ImmutableIntVector2D(0, -1), // up
            new ImmutableIntVector2D(1, 0), // right
            new ImmutableIntVector2D(0, 1), // down
            new ImmutableIntVector2D(-1, 0), // left
    };
    private static final EUnitType[] CAN_VISION_UNIT_TYPES = {EUnitType.AIR, EUnitType.GROUND};


    private boolean isHasShield;
    private boolean isUseShield;
    private final ImmutableIntVector2D startPosition;
    private ImmutableIntVector2D targetOrNull;


    public Wraith(final IntVector2D position) {
        super(UNIT_TYPE, HP, position);

        this.isHasShield = true;
        this.startPosition = new ImmutableIntVector2D(position.getX(), position.getY());
    }


    public EAction think() {
        if (isUseShield) {
            isHasShield = false;
        }

        // attack
        targetOrNull = searchMinHpAttackTargetOrNull();
        if (targetOrNull != null) {
            setAction(EAction.ATTACK);
            return EAction.ATTACK;
        }

        // vision
        targetOrNull = searchNinDistanceVisionTargetOrNull();
        if (targetOrNull != null) {
            setAction(EAction.MOVE);
            return EAction.MOVE;
        }

        if (getPosition().getX() == startPosition.x() && getPosition().getY() == startPosition.y()) {
            setAction(EAction.DO_NOTHING);
            return EAction.DO_NOTHING;
        }

        setAction(EAction.MOVE);
        return EAction.MOVE;
    }

    @Override
    public void move() {
        // 1 공중 유닛들을 따라갈 후보로 선택. 선택할 공중 유닛이 없다면 지상 유닛들을 선택
        // 2 가장 가까이 있는 유닛 쪽으로 이동
        // 3 가장 약한 유닛 쪽으로 이동
        // 4 북쪽에 있는 유닛 쪽으로 이동. 북쪽에 유닛이 없다면 시계 방향으로 검색하다 찾은 유닛 쪽으로 이동
        // 이동할 때는 언제나 y축을 따라 이동하는 게 우선입니다.
        //
        // 망령이 시야 안에서 적을 찾지 못한 경우, 자기의 처음 위치 쪽으로 이동해야 합니다. 이때 역시 y축을 따라 먼저 이동합니다.

        if (getAction() != EAction.MOVE) {
            return;
        }

        if (targetOrNull == null) {
            if (getPosition().getY() != startPosition.y()) {
                if (getPosition().getY() < startPosition.y()) {
                    getPosition().setY(getPosition().getY() + 1);
                } else {
                    getPosition().setY(getPosition().getY() - 1);
                }
            } else {
                if (getPosition().getX() < startPosition.x()) {
                    getPosition().setX(getPosition().getX() + 1);
                } else {
                    getPosition().setX(getPosition().getX() - 1);
                }
            }

            return;
        }


        if (getPosition().getY() != targetOrNull.y()) {
            if (getPosition().getY() < targetOrNull.y()) {
                getPosition().setY(getPosition().getY() + 1);
            } else {
                getPosition().setY(getPosition().getY() - 1);
            }
        } else {
            if (getPosition().getX() < targetOrNull.x()) {
                getPosition().setX(getPosition().getX() + 1);
            } else {
                getPosition().setX(getPosition().getX() - 1);
            }
        }
    }

    // 시그내처 불변
    public AttackIntent attack() {
        // 1 공중 유닛들을 공격할 후보로 선택. 선택할 공중 유닛이 없다면 지상 유닛들을 선택
        // 2 가장 약한 유닛이 있는 타일을 공격
        // 3 자신의 위치에 유닛이 있다면 그 타일을 공격.
        //   그렇지 않을 경우 북쪽(위쪽)에 유닛이 있다면 그 타일을 공격.
        //   그렇지 않을 경우 시계 방향으로 검색하다 찾은 유닛의 타일을 공격

        if (getAction() != EAction.ATTACK) {
            return new AttackIntent(this, ImmutableIntVector2D.MINUS_ONE);
        }

        assert (targetOrNull != null);

        return new AttackIntent(this, targetOrNull);
    }

    // 시그내처 불변
    public void onAttacked(int damage) {
        if (isHasShield) {
            isUseShield = true;
            return;
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


    private ImmutableIntVector2D searchMinHpAttackTargetOrNull() {
        final LinkedList<Unit>[][] map = SimulationManager.getInstance().getMap();
        Unit minHp = null;

        for (final EUnitType unitType : CAN_VISION_UNIT_TYPES) {
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

                    if (unit.getUnitType() == unitType) {
                        if (minHp == null || minHp.getHp() > unit.getHp()) {
                            minHp = unit;
                        }
                    }
                }
            }

            if (minHp != null) {
                return new ImmutableIntVector2D(minHp.getPosition());
            }
        }

        return new ImmutableIntVector2D(minHp.getPosition());
    }

    private ImmutableIntVector2D searchNinDistanceVisionTargetOrNull() {
        final LinkedList<Unit>[][] map = SimulationManager.getInstance().getMap();
        Unit minDistanceUnit = null;
        final int minDistance = Integer.MAX_VALUE;

        final int minY = getPosition().getY() - VISION;
        final int minX = getPosition().getX() - VISION;

        final int maxY = getPosition().getY() + VISION;
        final int maxX = getPosition().getX() + VISION;

        for (final EUnitType unitType : CAN_VISION_UNIT_TYPES) {
            for (int y = minY; y <= maxY; ++y) {
                for (int x = minX; x <= maxX; ++x) {
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

                        final int distance = Math.abs(unit.getPosition().getX() - getPosition().getX())
                                + Math.abs(unit.getPosition().getY() - getPosition().getY());

                        if (unit.getUnitType() == unitType) {
                            if (minDistanceUnit == null || minDistance > +distance) {
                                if (minDistanceUnit == null || minDistanceUnit.getHp() > unit.getHp()) {
                                    minDistanceUnit = unit;
                                }
                            }
                        }
                    }
                }
            }

            if (minDistanceUnit != null) {
                return new ImmutableIntVector2D(minDistanceUnit.getPosition());
            }
        }

        return new ImmutableIntVector2D(minDistanceUnit.getPosition());
    }
}
