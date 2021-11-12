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

    public int getDamage() {
        return damage;
    }

    public IntVector2D getAttackedPosition() {
        return attackedPosition;
    }
}