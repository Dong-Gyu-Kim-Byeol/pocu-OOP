package academy.pocu.comp2500.assignment3;

public final class SmartMine extends Mine implements IThinkable {
    public static final char SYMBOL = 'A';

    // ---

    private static final int VISION = 1;
    private static final int ATTACK_AREA_OF_EFFECT = 1;
    private static final int ATTACK_POINT = 15;
    private static final int HP = 1;
    private static final EUnitType[] CAN_ATTACK_UNIT_TYPES = {EUnitType.GROUND, EUnitType.INVISIBLE};
    private static final EUnitType[] CAN_VISION_UNIT_TYPES = {EUnitType.GROUND};

    // ---

    private final int minDetectEnemy;

    // ---

    public SmartMine(final IntVector2D position, final int minStepOn, final int minDetectEnemy) {
        super(SYMBOL, UNIT_TYPE, ATTACK_POINT, ATTACK_AREA_OF_EFFECT, CAN_ATTACK_UNIT_TYPES,
                HP, position, minStepOn);

        this.minDetectEnemy = minDetectEnemy;
    }

    // ---

    @Override
    public void think() {
        if (isCanDetectAttack()) {
            setAction(EAction.ATTACK);
            return;
        }

        setAction(EAction.DO_NOTHING);
    }

    // 시그내처 불변
    @Override
    public AttackIntent attack() {
        // 스마트 지뢰는 지뢰의 상위 호환 버전입니다.
        // 스마트 지뢰는 지뢰와 동일하게 작동하는 것 외에도 초특급 울트라 레이더를 탑재한 덕분에 근처에 있는 유닛들을 감지하는 능력을 갖추고 있습니다.
        // 만약 시야 안에서 몇 명 이상의 적 유닛이 감지되면, 스마트 지뢰가 폭발합니다.
        // 폭발에 필요한 최소 적 유닛 수는 스마트 지뢰마다 다르게 지정할 수 있습니다.
        //
        // 초특급 울트라 레이더 기술 덕분에 스마트 지뢰는 시야 안에 있는 모든 지상 유닛을 감지할 수 있습니다.
        // 하지만 공중 유닛과 볼 수 없는 유닛은 감지할 수 없답니다.

        final AttackIntent superAttackIntent = super.attack();
        if (superAttackIntent.isValid()) {
            return superAttackIntent;
        }

        if (getAction() != EAction.ATTACK) {
            return new AttackIntent(this, false, ImmutableIntVector2D.MINUS_ONE);
        }

        return new AttackIntent(this, true, new ImmutableIntVector2D(getPosition()));
    }

    // 시그내처 불변
    @Override
    public void onSpawn() {
        super.onSpawn();
        SimulationManager.getInstance().registerThinkable(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        SimulationManager.getInstance().unregisterThinkable(this);
    }

    // ---

    private boolean isCanDetectAttack() {
        final Map2DCanSamePosition<Unit> map = SimulationManager.getInstance().getMap();

        int unitCount = 0;

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
                            ++unitCount;
                            break;
                        }
                    }
                }
            }
        }

        return this.minDetectEnemy <= unitCount;
    }
}
