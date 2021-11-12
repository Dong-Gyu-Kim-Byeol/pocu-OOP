package academy.pocu.comp2500.assignment3;

public class Tank extends Unit implements IMovable {
    // 전차에는 두 가지 모드(mode)가 있습니다.
    //
    // 전차(tank) 모드 (기본 모드): 전차 모드인 경우, 이동할 수 있으나 공격할 수는 없습니다.
    // 공성(siege) 모드: 공성 모드인 경우, 이동할 수 없으나 공격할 수는 있습니다.
    // 전차는 모드를 바꿀 때 1 프레임을 소모합니다.

    // 공성 모드인 전차는 탱크 모드일 때보다 2배의 피해를 받습니다.

    private static final char SYMBOL = 'T';
    private static final EUnitType UNIT_TYPE = EUnitType.GROUND;
    private static final int VISION = 3;
    private static final int ATTACK_AREA_OF_EFFECT = 1;
    private static final int ATTACK_POINT = 8;
    private static final int HP = 85;
    private static final EUnitType[] CAN_ATTACK_UNIT_TYPES = {EUnitType.GROUND};
    private static final ImmutableIntVector2D[] CAN_ATTACK_AREA_OFFSET = {
            new ImmutableIntVector2D(0, -2), // up
            new ImmutableIntVector2D(1, -2),

            new ImmutableIntVector2D(2, -1),
            new ImmutableIntVector2D(2, 0), // right
            new ImmutableIntVector2D(2, 1),

            new ImmutableIntVector2D(1, 2),
            new ImmutableIntVector2D(0, 2), // down
            new ImmutableIntVector2D(-1, 2),

            new ImmutableIntVector2D(-2, 1),
            new ImmutableIntVector2D(-2, 0), // left
            new ImmutableIntVector2D(-2, -1),

            new ImmutableIntVector2D(-1, -2),
    };
    private static final EUnitType[] CAN_VISION_UNIT_TYPES = {EUnitType.GROUND};


    private ETankMode tankMode;

    public Tank(final IntVector2D position) {

    }

    // 시그내처 불변
    public AttackIntent attack() {
        // 1 현재 공성 모드가 아닌 경우 공성 모드로 변경
        // 2 가장 약한 유닛이 있는 타일을 공격
        // 3 북쪽에 유닛이 있다면 그 타일을 공격. 그렇지 않을 경우 시계 방향으로 검색하다가 찾은 유닛의 타일을 공격
        // 전차가 시야 안에서 적을 찾으면 공성 모드로 변환하여 공격할 준비를 합니다.

    }

    @Override
    public void move() {
        // 전차가 시야 안에서 적을 찾지 못하면 다음의 이동 규칙을 따릅니다. (역시 우선순위 순)
        //
        // 1 월드의 동쪽(오른쪽) 끝까지 이동
        // 2 월드의 서쪽(왼쪽) 끝까지 이동
        // 3 시야 안에서 적을 발견할 때까지 1 - 2를 반복

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
}
