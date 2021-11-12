package academy.pocu.comp2500.assignment3;

public abstract class Unit {
    private final IntVector2D position;
    private int hp;
    private int damage;

    protected Unit(final int hp, final int damage, final IntVector2D startPosition) {
        this.hp = hp;
        this.damage = damage;
        this.position = startPosition;
    }

    public final IntVector2D getPosition() {
        return position;
    }

    public final int getHp() {
        return hp;
    }

    public abstract AttackIntent attack();


    public abstract void onAttacked(int damage);


    public abstract void onSpawn();


    public abstract char getSymbol();

}