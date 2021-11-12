package academy.pocu.comp2500.assignment3;

public final class Mine extends Unit{
    private static final char SYMBOL = 'N';
    private static final EUnitType UNIT_TYPE = EUnitType.MINE;
    private static final int VISION = 0;
    private static final int ATTACK_AREA_OF_EFFECT = 0;
    private static final int ATTACK_POINT = 10;
    private static final int HP = 1;
    private static final EUnitType[] CAN_ATTACK_UNIT_TYPES = {EUnitType.GROUND};
    private static final ImmutableIntVector2D[] CAN_ATTACK_AREA_OFFSET = {
            new ImmutableIntVector2D(0, 0)
    };
    private static final EUnitType[] CAN_VISION_UNIT_TYPES = {EUnitType., EUnitType.};

    // 시그내처 불변
    public AttackIntent attack() {
        // 지뢰는 움직일 수 없는 유닛이며, 다른 유닛은 지뢰를 볼 수 없습니다.
        // 지뢰는 다른 유닛이 일정 횟수만큼 밟으면 그때 터집니다. 지뢰 위치에 있는 다른 유닛들은 모두 피해를 입습니다.
        // 이 횟수는 지뢰마다 다르게 지정할 수 있습니다.
        // 터진 지뢰는 파괴됩니다.
    }

    // 시그내처 불변
    public void onAttacked(int damage) {

    }

    // 시그내처 불변
    public void onSpawn() {

    }

    // 시그내처 불변
    public char getSymbol() {
        return SYMBOL;
    }


    public Mine(final IntVector2D position, final int minStepOn) {

    }



}
