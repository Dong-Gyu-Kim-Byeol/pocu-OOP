package academy.pocu.comp2500.assignment3;

public class Turret extends Unit {
        private static final char SYMBOL = 'U';
    private static final EUnitType UNIT_TYPE = EUnitType.GROUND;
    private static final int VISION = 2;
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

    // 시그내처 불변
    public AttackIntent attack() {
        // 1 가장 약한 유닛이 있는 타일을 공격
        // 2 자신의 위치에 유닛이 있다면 그 타일을 공격.
        //   그렇지 않을 경우 북쪽(위쪽)에 유닛이 있다면 그 타일을 공격.
        //   그렇지 않을 경우 시계 방향으로 검색하다 찾은 유닛의 타일을 공격
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

    public Turret(final IntVector2D position) {

    }
}
