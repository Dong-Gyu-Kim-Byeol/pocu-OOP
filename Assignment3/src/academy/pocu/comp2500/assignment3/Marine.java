package academy.pocu.comp2500.assignment3;

import java.util.LinkedList;

public final class Marine extends Unit implements IMovable, IThinkable {
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


    private ImmutableIntVector2D targetOrNull;


    public Marine(final IntVector2D position) {
        super(UNIT_TYPE, HP, position);
    }


    public EAction think() {
        // attack
        targetOrNull = searchMinHpAttackTargetOrNull();
        if (targetOrNull != null) {
            setAction(EAction.ATTACK);
            return EAction.ATTACK;
        }

        // vision
        targetOrNull = searchMinHpVisionTargetOrNull();
        if (targetOrNull != null) {
            setAction(EAction.MOVE);
            return EAction.MOVE;
        }

        setAction(EAction.DO_NOTHING);
        return EAction.DO_NOTHING;
    }

    @Override
    public void move() {
        // 1 가장 가까이 있는 유닛 쪽으로 이동. 가장 가까운 유닛은 맨해튼 거리를 사용하여 판단합니다.
        // 2 가장 약한 유닛 쪽으로 이동
        // 3 북쪽에 있는 유닛 쪽으로 이동, 북쪽에 유닛이 없다면 시계 방향으로 검색하다 찾은 유닛 쪽으로 이동
        // 이동할 때는 언제나 y축을 따라 다 이동한 뒤 x축을 따라 이동합니다.
        //
        // 해병이 시야 안에서 적을 찾지 못한 경우, 현재 타일에서 움직이지 않습니다.

        if (getAction() != EAction.MOVE) {
            return;
        }

        assert (targetOrNull != null);

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
        // 1 가장 약한 유닛(HP가 가장 낮은 유닛)이 있는 타일을 공격
        // 2 자신의 위치에 유닛이 있다면 그 타일을 공격. 그렇지 않을 경우 북쪽(위쪽)에 유닛이 있다면 그 타일을 공격.
        //   그렇지 않을 경우 시계 방향으로 검색하다 찾은 유닛의 타일을 공격

        if (getAction() != EAction.ATTACK) {
            return new AttackIntent(this, ImmutableIntVector2D.MINUS_ONE);
        }

        assert (targetOrNull != null);

        return new AttackIntent(this, targetOrNull);
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


    private ImmutableIntVector2D searchMinHpAttackTargetOrNull() {
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
                        }
                    }
                }
            }
        }

        return new ImmutableIntVector2D(minHp.getPosition());
    }

    private ImmutableIntVector2D searchMinHpVisionTargetOrNull() {
        final LinkedList<Unit>[][] map = SimulationManager.getInstance().getMap();
        Unit minHp = null;

        final int minY = getPosition().getY() - VISION;
        final int minX = getPosition().getX() - VISION;

        final int maxY = getPosition().getY() + VISION;
        final int maxX = getPosition().getX() + VISION;

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

                    for (final EUnitType unitType : CAN_VISION_UNIT_TYPES) {
                        if (unit.getUnitType() == unitType) {
                            if (minHp == null || minHp.getHp() > unit.getHp()) {
                                minHp = unit;
                            }
                        }
                    }
                }
            }
        }

        return new ImmutableIntVector2D(minHp.getPosition());
    }
}
