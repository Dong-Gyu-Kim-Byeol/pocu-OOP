package academy.pocu.comp2500.assignment3;

public class Mine extends Unit implements ICollision {
    public static final char SYMBOL = 'N';
    private static final EUnitType UNIT_TYPE = EUnitType.MINE;
    private static final int ATTACK_AREA_OF_EFFECT = 0;
    private static final int ATTACK_POINT = 10;
    private static final int HP = 1;
    private static final EUnitType[] CAN_ATTACK_UNIT_TYPES = {EUnitType.GROUND, EUnitType.MINE};


    private int minStepOn;
    private final ImmutableIntVector2D immutablePosition;

    public Mine(final IntVector2D position, final int minStepOn) {
        super(UNIT_TYPE, HP, position);

        this.minStepOn = minStepOn;
        this.immutablePosition = new ImmutableIntVector2D(getPosition());
    }

    @Override
    public final void checkCollision(final Unit unit) {
        if (unit == this) {
            return;
        }

        switch (unit.getUnitType()) {
            case GROUND:
                // intentional fallthrough
            case MINE:
                deceaseMinStepOn();
                break;
            case AIR:
                break;
            default:
                throw new IllegalArgumentException("unknown type");
        }
    }

    public final ImmutableIntVector2D getCollisionPosition() {
        return immutablePosition;
    }

    // 시그내처 불변
    public AttackIntent attack() {
        // 지뢰는 움직일 수 없는 유닛이며, 다른 유닛은 지뢰를 볼 수 없습니다.
        // 지뢰는 다른 유닛이 일정 횟수만큼 밟으면 그때 터집니다. 지뢰 위치에 있는 다른 유닛들은 모두 피해를 입습니다.
        // 이 횟수는 지뢰마다 다르게 지정할 수 있습니다.
        // 터진 지뢰는 파괴됩니다.

        if (isCanStepOnAttack()) {
            setHpZero();
            return new AttackIntent(this, true, new ImmutableIntVector2D(getPosition()));
        }

        return new AttackIntent(this, true, ImmutableIntVector2D.MINUS_ONE);
    }

    // 시그내처 불변
    public final void onAttacked(int damage) {
        subHp(damage);
    }

    // 시그내처 불변
    public final void onSpawn() {
        SimulationManager.getInstance().registerCollisionEventListener(this);
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
        return false;
    }

    public boolean isIMovable() {
        return false;
    }

    public boolean isICollision() {
        return true;
    }


    protected final boolean isCanStepOnAttack() {
        return this.minStepOn <= 0;
    }

    protected final void deceaseMinStepOn() {
        --minStepOn;
    }
}
