package academy.pocu.comp2500.lab5;

public class Move {
    private final String name;
    private final int power;
    private final int maxPowerPoint;
    private int countPowerPoint;

    // public
    public Move(final String name, final int power, final int maxPowerPoint) {
        this.name = name;
        this.power = power;
        this.maxPowerPoint = maxPowerPoint;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public boolean canMove() {
        return this.maxPowerPoint > this.countPowerPoint;
    }

    public int getPowerPoint() {
        return this.maxPowerPoint - this.countPowerPoint;
    }

    public void decreasePowerPoint() {
        this.countPowerPoint += 1;
        if (this.countPowerPoint > this.maxPowerPoint) {
            this.countPowerPoint = this.maxPowerPoint;
        }
    }

    public void increasePowerPoint() {
        this.countPowerPoint -= 1;
        if (this.countPowerPoint < 0) {
            this.countPowerPoint = 0;
        }
    }
}
