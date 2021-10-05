package academy.pocu.comp2500.lab5;

public class Pet {
    private final String name;
    private int attack;

    // public
    public Pet(final String name, final int attack) {
        this.name = name;
        this.attack = attack;
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }
}
