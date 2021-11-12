package academy.pocu.comp2500.assignment3;

public abstract class Unit {
    // 유닛이 할 수 있는 행동은 이동, 공격, '아무것도 안 함' 중 하나입니다.
    // 유닛은 현재 위치에 바로 인접한 타일로만 이동할 수 있습니다. 즉, 동서남북 중 한 방향으로만 이동할 수 있으며 대각선 이동은 허용하지 않습니다.
    // 유닛은 공격 구역에 있는 적을 발견하면 반드시 그 타일을 공격해야 합니다.
    // 이동 가능한 유닛은 공격 구역에 있는 적을 발견하지 못한 경우에만 이동할 수 있습니다.
    // 유닛은 자기 자신에게 피해를 입힐 수 없습니다.

    private final IntVector2D position;
    private int hp;
    private int attackPoint;
    private final int attackAreaOfEffect;
    private final int vision;

    protected Unit(final int hp, final int damage, final IntVector2D startPosition) {
        this.hp = hp;
        this.damage = damage;
        this.position = startPosition;
    }

    // 시그내처 불변
    public final IntVector2D getPosition() {
        return position;
    }

    // 시그내처 불변
    public final int getHp() {
        return hp;
    }



    // 시그내처 불변
    public abstract AttackIntent attack();

    // 시그내처 불변
    public abstract void onAttacked(int damage);

    // 시그내처 불변
    public abstract void onSpawn();

    // 시그내처 불변
    public abstract char getSymbol();

}