package academy.pocu.comp2500.assignment3;

public final class Destroyer extends Unit {
    public static final char SYMBOL = 'D';
    private static final EUnitType UNIT_TYPE = EUnitType.GROUND;
    private static final int VISION = Math.max(SimulationManager.X_MAP_SIZE, SimulationManager.Y_MAP_SIZE);
    private static final int ATTACK_AREA_OF_EFFECT = VISION;
    private static final int WANT_DAMAGE = 1000;
    private static final int ATTACK_POINT = calculateAttackPoint();
    private static final int HP = 1000;
    private static final EUnitType[] CAN_ATTACK_UNIT_TYPES = {EUnitType.GROUND, EUnitType.AIR, EUnitType.MINE};


    public Destroyer(final IntVector2D position) {
        super(UNIT_TYPE, HP, position);
    }

    // 시그내처 불변
    public AttackIntent attack() {
        // 이 유닛은 알려진 것이 별로 없습니다. 이 유닛을 개발한 군사 과학자에 따르면 이 유닛은 망령을 제외한 모든 유닛을 한 프레임 만에 모두 파괴할 수 있다고 합니다.
        // (망령을 죽이지 못하는 이유는 방어막 때문)

        return new AttackIntent(this, ImmutableIntVector2D.ZERO);
    }

    // 시그내처 불변
    public void onAttacked(int damage) {
        // 파괴자는 공격자의 공격력과는 상관없이 1의 피해만 받습니다.
        subHp(1);
    }

    // 시그내처 불변
    public void onSpawn() {
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


    private static int calculateAttackPoint() {
        final double distance = VISION;
        final double aoe = ATTACK_AREA_OF_EFFECT;
        final double damage = WANT_DAMAGE;

        assert (distance <= aoe);

        final double ap = damage / (1.0 - distance / (aoe + 1.0));

        assert (ap > 0);
        assert (ap >= damage);
        assert (ap >= AttackIntent.calculateDamage(new Destroyer(new IntVector2D(0, 0)), ImmutableIntVector2D.ZERO, VISION, VISION));

        return (int) ap;
    }
}
