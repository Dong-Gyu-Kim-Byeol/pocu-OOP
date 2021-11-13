package academy.pocu.comp2500.assignment3;

public final class Turret extends Unit implements IThinkable {
    public static final char SYMBOL = 'U';
    private static final EUnitType UNIT_TYPE = EUnitType.GROUND;
    private static final int ATTACK_AREA_OF_EFFECT = 0;
    private static final int ATTACK_POINT = 7;
    private static final int HP = 99;
    private static final EUnitType[] CAN_ATTACK_UNIT_TYPES = {EUnitType.AIR};
    private static final ImmutableIntVector2D[] CAN_ATTACK_AREA_OFFSET = {
            new ImmutableIntVector2D(0, 0),

            new ImmutableIntVector2D(0, -1), // up
            new ImmutableIntVector2D(1, -1),

            new ImmutableIntVector2D(1, 0), // right
            new ImmutableIntVector2D(1, 1),

            new ImmutableIntVector2D(0, 1), // down
            new ImmutableIntVector2D(-1, 1),

            new ImmutableIntVector2D(-1, 0), // left
            new ImmutableIntVector2D(-1, -1),
    };
    private static final EUnitType[] CAN_VISION_UNIT_TYPES = {EUnitType.AIR};


    private ImmutableIntVector2D targetOrNull;


    public Turret(final IntVector2D position) {
        super(UNIT_TYPE, HP, position);
    }


    @Override
    public void think() {
        targetOrNull = searchMinHpAttackTargetOrNull();
        if (targetOrNull != null) {
            setAction(EAction.ATTACK);
            return;
        }

        setAction(EAction.DO_NOTHING);
        return;
    }

    // 시그내처 불변
    public AttackIntent attack() {
        // 1 가장 약한 유닛이 있는 타일을 공격
        // 2 자신의 위치에 유닛이 있다면 그 타일을 공격.
        //   그렇지 않을 경우 북쪽(위쪽)에 유닛이 있다면 그 타일을 공격.
        //   그렇지 않을 경우 시계 방향으로 검색하다 찾은 유닛의 타일을 공격

        if (getAction() != EAction.ATTACK) {
            return new AttackIntent(this, false, ImmutableIntVector2D.MINUS_ONE);
        }

        assert (targetOrNull != null);

        return new AttackIntent(this, false, targetOrNull);
    }

    // 시그내처 불변
    public void onAttacked(int damage) {
        subHp(damage);
    }

    // 시그내처 불변
    public void onSpawn() {
        SimulationManager.getInstance().registerThinkable(this);
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
        return false;
    }

    public boolean isICollision() {
        return false;
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

                for (final EUnitType unitType : CAN_VISION_UNIT_TYPES) {
                    if (unit.getUnitType() == unitType) {
                        if (minHp == null || minHp.getHp() > unit.getHp()) {
                            minHp = unit;
                        }
                    }
                }
            }
        }

        if (minHp == null) {
            return null;
        }

        return new ImmutableIntVector2D(minHp.getPosition());
    }
}
