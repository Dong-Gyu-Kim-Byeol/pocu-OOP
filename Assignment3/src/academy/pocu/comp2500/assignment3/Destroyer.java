package academy.pocu.comp2500.assignment3;

public class Destroyer extends Unit{
    public static final char SYMBOL = 'D';
    private static final EUnitType UNIT_TYPE = EUnitType.GROUND;
    private static final int HP = 1000;
    private static final EUnitType[] CAN_ATTACK_UNIT_TYPES = {EUnitType.GROUND, EUnitType.AIR, EUnitType.MINE};
    private static final EUnitType[] CAN_VISION_UNIT_TYPES = {EUnitType.GROUND, EUnitType.AIR, EUnitType.MINE};

    // 시그내처 불변
    public AttackIntent attack() {
        // 이 유닛은 알려진 것이 별로 없습니다. 이 유닛을 개발한 군사 과학자에 따르면 이 유닛은 망령을 제외한 모든 유닛을 한 프레임 만에 모두 파괴할 수 있다고 합니다.
        // (망령을 죽이지 못하는 이유는 방어막 때문)

    }

    // 시그내처 불변
    public void onAttacked(int damage) {
        // 파괴자는 공격자의 공격력과는 상관없이 1의 피해만 받습니다.
    }

    // 시그내처 불변
    public void onSpawn() {

    }

    // 시그내처 불변
    public char getSymbol() {
        return SYMBOL;
    }


    public Destroyer(final IntVector2D position) {

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
