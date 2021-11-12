package academy.pocu.comp2500.assignment3;

// 공격 의도
public class AttackIntent {
    private final Unit attackUnit;
    private final IntVector2D attackedPosition;
    private final int damage;


    public AttackIntent(final Unit attackUnit, final IntVector2D attackedPosition, final int damage) {
        this.attackUnit = attackUnit;
        this.attackedPosition = attackedPosition;
        this.damage = damage;
    }

    public Unit getAttackUnit() {
        return attackUnit;
    }

    // 피해치(x, y) = (공격 지점에서의 피해치) * (1 - 공격 지점으로부터의 거리 / (공격의 AoE 값 + 1))

    //    거리는 다음과 같이 정의합니다. 다음 그림에서 숫자는 공격 지점으로부터의 거리값을 나타냅니다.
    //        3 3 3 3 3 3 3
    //        3 2 2 2 2 2 3
    //        3 2 1 1 1 2 3
    //        3 2 1 * 1 2 3
    //        3 2 1 1 1 2 3
    //        3 2 2 2 2 2 3
    //        3 3 3 3 3 3 3
    // 계산 중에는 double 형을 사용하고 최종 계산 뒤에는 소수점 이하는 버리세요.
    public int getDamage() {
        return damage;
    }

    public IntVector2D getAttackedPosition() {
        return attackedPosition;
    }
}