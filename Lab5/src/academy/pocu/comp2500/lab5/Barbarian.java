package academy.pocu.comp2500.lab5;

public class Barbarian {
    private final String name;
    private int hp;
    private final int attack;
    private final int defense;

    // public
    public Barbarian(final String name, final int hp, final int attack, final int defense) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public boolean isAlive() {
        return this.getHp() > 0;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }


    public void attack(final Barbarian other) {
        int damage = (this.getAttack() - other.getDefense()) / 2;
        if (damage < 1) {
            damage = 1;
        }

        other.damage(damage);
    }

    // protected
    protected void damage(final int damage) {
        assert (damage >= 1);
        this.addHp(damage);
    }

    protected void addHp(final int addHp) {
        this.hp += addHp;
        if (this.hp < 0) {
            this.hp = 0;
        }
    }

}
