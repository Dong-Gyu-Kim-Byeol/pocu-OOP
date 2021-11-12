package academy.pocu.comp2500.assignment3;

import java.util.LinkedList;

public class Marine extends Unit implements IMovable, IThinkable {
    public static final char SYMBOL = 'M';
    private static final EUnitType UNIT_TYPE = EUnitType.GROUND;
    private static final int VISION = 2;
    private static final int ATTACK_AREA_OF_EFFECT = 0;
    private static final int ATTACK_POINT = 6;
    private static final int HP = 35;
    private static final EUnitType[] CAN_ATTACK_UNIT_TYPES = {EUnitType.GROUND, EUnitType.AIR, EUnitType.MINE};
    private static final ImmutableIntVector2D[] CAN_ATTACK_AREA_OFFSET = {
            new ImmutableIntVector2D(0, 0),
            new ImmutableIntVector2D(0, -1), // up
            new ImmutableIntVector2D(1, 0), // right
            new ImmutableIntVector2D(0, 1), // down
            new ImmutableIntVector2D(-1, 0), // left
    };
    private static final EUnitType[] CAN_VISION_UNIT_TYPES = {EUnitType.GROUND, EUnitType.AIR};


    public Marine(final IntVector2D position) {
        super(UNIT_TYPE, HP, position);
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

    private Unit searchMinHpVisionTargetOrNull(final boolean isNeedOnlyExist) {
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
        }

        return minHp;
    }

    public EAction think() {
        // attack
        if (searchMinHpAttackTargetOrNull(true) != null) {
            return EAction.ATTACK;
        }

        // vision
        if (searchMinHpVisionTargetOrNull(true) != null) {
            return EAction.MOVE;
        }

        return EAction.DO_NOTHING;
    }

    // 시그내처 불변
    public AttackIntent attack() {
        // 1 가장 약한 유닛(HP가 가장 낮은 유닛)이 있는 타일을 공격
        // 2 자신의 위치에 유닛이 있다면 그 타일을 공격. 그렇지 않을 경우 북쪽(위쪽)에 유닛이 있다면 그 타일을 공격.
        //   그렇지 않을 경우 시계 방향으로 검색하다 찾은 유닛의 타일을 공격

        final Unit minHp = searchMinHpAttackTargetOrNull(false);

        assert (minHp != null);

        return new AttackIntent(this, new ImmutableIntVector2D(minHp.getPosition().getX(), minHp.getPosition().getY()));
    }

    @Override
    public void move() {
        // 1 가장 가까이 있는 유닛 쪽으로 이동. 가장 가까운 유닛은 맨해튼 거리를 사용하여 판단합니다.
        // 2 가장 약한 유닛 쪽으로 이동
        // 3 북쪽에 있는 유닛 쪽으로 이동, 북쪽에 유닛이 없다면 시계 방향으로 검색하다 찾은 유닛 쪽으로 이동
        // 이동할 때는 언제나 y축을 따라 다 이동한 뒤 x축을 따라 이동합니다.
        //
        // 해병이 시야 안에서 적을 찾지 못한 경우, 현재 타일에서 움직이지 않습니다.

        final Unit minHp = searchMinHpVisionTargetOrNull(false);

        assert (minHp != null);

        if (getPosition().getY() != minHp.getPosition().getY()) {
            if (getPosition().getY() < minHp.getPosition().getY()) {
                getPosition().setY(getPosition().getY() + 1);
            } else {
                getPosition().setY(getPosition().getY() - 1);
            }
        } else {
            if (getPosition().getX() < minHp.getPosition().getX()) {
                getPosition().setX(getPosition().getX() + 1);
            } else {
                getPosition().setX(getPosition().getX() - 1);
            }
        }
    }

    // 시그내처 불변
    public void onAttacked(int damage) {
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
