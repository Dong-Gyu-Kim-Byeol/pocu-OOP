package academy.pocu.comp2500.lab5;

import java.util.HashMap;

public class Knight extends Gladiator {
    private Pet petOrNull;

    public Knight(final String name, final int hp, final int attack, final int defense) {
        super(name, hp, attack, defense);
    }

    public void setPet(Pet petOrNull) {
        this.petOrNull = petOrNull;
    }

    public void attackTogether(final Barbarian other) {
        if (this.petOrNull == null) {
            return;
        }

        int damage = (this.getAttack() + this.petOrNull.getAttack() - other.getDefense()) / 2;
        if (damage < 1) {
            damage = 1;
        }

        other.damage(damage);
    }

}
