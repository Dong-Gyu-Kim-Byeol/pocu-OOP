package academy.pocu.comp2500.assignment3;

public class Mine extends Unit implements ICollision, IThinkable {
    public static final char SYMBOL = 'N';
    private static final EUnitType UNIT_TYPE = EUnitType.MINE;
    private static final int VISION = 0;
    private static final int ATTACK_AREA_OF_EFFECT = 0;
    private static final int ATTACK_POINT = 10;
    private static final int HP = 1;
    private static final EUnitType[] CAN_ATTACK_UNIT_TYPES = {EUnitType.GROUND, EUnitType.MINE};
    private static final ImmutableIntVector2D[] CAN_ATTACK_AREA_OFFSET = {
            new ImmutableIntVector2D(0, 0)
    };
    private static final EUnitType[] CAN_VISION_UNIT_TYPES = {};

    protected boolean isCanStepOnAttack() {
        return this.minStepOn <= 0;
    }

    @Override
    public final void checkCollision(final Unit unit) {
        if (unit == this) {
            return;
        }

        if (unit.getUnitType() != EUnitType.GROUND) {
            return;
        }

        deceaseMinStepOn();
    }

    @Override
    public EAction think() {
        assert (getAction() == EAction.DO_NOTHING);

        if (isCanStepOnAttack()) {
            setAction(EAction.ATTACK);
            return EAction.ATTACK;
        }

        setAction(EAction.DO_NOTHING);
        return EAction.DO_NOTHING;
    }

    public ImmutableIntVector2D getCollisionPosition() {
        return immutablePosition;
    }

    // 시그내처 불변
    public final AttackIntent attack() {
        // 지뢰는 움직일 수 없는 유닛이며, 다른 유닛은 지뢰를 볼 수 없습니다.
        // 지뢰는 다른 유닛이 일정 횟수만큼 밟으면 그때 터집니다. 지뢰 위치에 있는 다른 유닛들은 모두 피해를 입습니다.
        // 이 횟수는 지뢰마다 다르게 지정할 수 있습니다.
        // 터진 지뢰는 파괴됩니다.

        assert (getAction() == EAction.ATTACK);
        assert (this.minStepOn <= 0);

        subHp(HP);

        return new AttackIntent(this, new ImmutableIntVector2D(getPosition().getX(), getPosition().getY()));
    }

    // 시그내처 불변
    public final void onAttacked(int damage) {
        subHp(damage);
    }

    // 시그내처 불변
    public final void onSpawn() {
        SimulationManager.getInstance().registerThinkable(this);
        SimulationManager.getInstance().registerCollisionEventListener(this);
    }

    // 시그내처 불변
    public char getSymbol() {
        return SYMBOL;
    }

    private int minStepOn;
    private final ImmutableIntVector2D immutablePosition;

    public Mine(final IntVector2D position, final int minStepOn) {
        super(UNIT_TYPE, HP, position);

        this.minStepOn = minStepOn;
        this.immutablePosition = new ImmutableIntVector2D(getPosition().getX(), getPosition().getY());
    }

    protected final int getMinStepOn() {
        return minStepOn;
    }

    protected final void deceaseMinStepOn() {
        --minStepOn;
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
