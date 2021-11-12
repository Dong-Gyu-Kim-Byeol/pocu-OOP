package academy.pocu.comp2500.assignment3;

public class Wraith extends Unit implements IMovable {
    // 망령은 공격을 받으면 즉시 가동되는 특수 방어막을 가지고 있습니다.
    // 한 번 가동된 방어막은 현재 프레임이 끝날 때까지 지속되어 망령은 피해를 입지 않습니다.
    // 다음 프레임부터는 공격을 받으면 피해를 입습니다.

    private static final char SYMBOL = 'W';
    private static final EUnitType UNIT_TYPE = EUnitType.AIR;
    private static final int VISION = 4;
    private static final int ATTACK_AREA_OF_EFFECT = 0;
    private static final int ATTACK_POINT = 6;
    private static final int HP = 80;
    private static final EUnitType[] CAN_ATTACK_UNIT_TYPES = {EUnitType.GROUND, EUnitType.AIR};
    private static final ImmutableIntVector2D[] CAN_ATTACK_AREA_OFFSET = {
            new ImmutableIntVector2D(0, 0),
            new ImmutableIntVector2D(0, -1), // up
            new ImmutableIntVector2D(1, 0), // right
            new ImmutableIntVector2D(0, 1), // down
            new ImmutableIntVector2D(-1, 0), // left
    };
    private static final EUnitType[] CAN_VISION_UNIT_TYPES = {EUnitType.GROUND, EUnitType.AIR};

    // 시그내처 불변
    public AttackIntent attack() {
        // 1 공중 유닛들을 공격할 후보로 선택. 선택할 공중 유닛이 없다면 지상 유닛들을 선택
        // 2 가장 약한 유닛이 있는 타일을 공격
        // 3 자신의 위치에 유닛이 있다면 그 타일을 공격.
        //   그렇지 않을 경우 북쪽(위쪽)에 유닛이 있다면 그 타일을 공격.
        //   그렇지 않을 경우 시계 방향으로 검색하다 찾은 유닛의 타일을 공격
    }

    @Override
    public void move() {
        // 1 공중 유닛들을 따라갈 후보로 선택. 선택할 공중 유닛이 없다면 지상 유닛들을 선택
        // 2 가장 가까이 있는 유닛 쪽으로 이동
        // 3 가장 약한 유닛 쪽으로 이동
        // 4 북쪽에 있는 유닛 쪽으로 이동. 북쪽에 유닛이 없다면 시계 방향으로 검색하다 찾은 유닛 쪽으로 이동
        // 이동할 때는 언제나 y축을 따라 이동하는 게 우선입니다.
        //
        // 망령이 시야 안에서 적을 찾지 못한 경우, 자기의 처음 위치 쪽으로 이동해야 합니다. 이때 역시 y축을 따라 먼저 이동합니다.

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


    private boolean isUseShield;

    public Wraith(final IntVector2D position) {

    }
}
