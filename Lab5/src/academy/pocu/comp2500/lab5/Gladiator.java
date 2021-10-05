package academy.pocu.comp2500.lab5;

import java.util.HashMap;

public class Gladiator extends Barbarian {
    private final HashMap<String, Move> moves;

    public Gladiator(final String name, final int hp, final int attack, final int defense) {
        super(name, hp, attack, defense);

        this.moves = new HashMap<String, Move>();
    }

    public boolean addMove(final Move move) {
        if (this.moves.containsKey(move.getName())) {
            return false;
        } else {
            this.moves.put(move.getName(), move);
            return true;
        }
    }

    public boolean removeMove(final String moveName) {
        if (this.moves.containsKey(moveName)) {
            this.moves.remove(moveName);
            return true;
        } else {
            return false;
        }
    }

    public void attack(final String moveName, final Barbarian other) {
        if (other.getName().equals(this.getName())) {
            return;
        }

        if (super.isAlive() == false) {
            return;
        }

        final Move move = this.moves.get(moveName);
        if (move == null) {
            return;
        }

        if (move.canMove() == false) {
            return;
        }

        int damage = (int) (((double) this.getAttack() / (double) other.getDefense() * (double) move.getPower()) / 2.0);
        move.decreasePowerPoint();
        if (damage < 1) {
            damage = 1;
        }

        other.damage(damage);
    }

    public void rest() {
        super.addHp(10);
        for (final Move move : this.moves.values()) {
            move.increasePowerPoint();
        }
    }
}
