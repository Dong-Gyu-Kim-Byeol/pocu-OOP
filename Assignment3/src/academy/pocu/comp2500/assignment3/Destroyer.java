package academy.pocu.comp2500.assignment3;

public final class Destroyer extends Unit {
    private static final char SYMBOL = 'D';
    private static final EUnitType UNIT_TYPE = EUnitType.AIR;

    private static final int VISION = Math.max(SimulationManager.getInstance().getMap().xSize(), SimulationManager.getInstance().getMap().ySize());
    private static final int ATTACK_AREA_OF_EFFECT = VISION;
    private static final int ATTACK_POINT = 1000 * VISION;
    private static final int HP = 1000;
    private static final EUnitType[] CAN_ATTACK_UNIT_TYPES = {EUnitType.GROUND, EUnitType.AIR, EUnitType.INVISIBLE};

    // ---

    public Destroyer(final IntVector2D position) {
        super(SYMBOL, UNIT_TYPE, HP, position);
    }

    // ---

    // 시그내처 불변
    @Override
    public AttackIntent attack() {
        // 이 유닛은 알려진 것이 별로 없습니다. 이 유닛을 개발한 군사 과학자에 따르면 이 유닛은 망령을 제외한 모든 유닛을 한 프레임 만에 모두 파괴할 수 있다고 합니다.
        // (망령을 죽이지 못하는 이유는 방어막 때문)

        return new AttackIntent(this, false, ImmutableIntVector2D.ONE, ATTACK_POINT, ATTACK_AREA_OF_EFFECT, CAN_ATTACK_UNIT_TYPES);
    }

    // 시그내처 불변
    @Override
    public void onAttacked(int damage) {
        // 파괴자는 공격자의 공격력과는 상관없이 1의 피해만 받습니다.
        subHp(1);
    }

    // 시그내처 불변
    @Override
    public void onSpawn() {
    }

    @Override
    public void onDestroy() {
    }
}
