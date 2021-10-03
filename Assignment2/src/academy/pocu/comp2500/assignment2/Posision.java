package academy.pocu.comp2500.assignment2;

public class Posision {
    private final ESide side;
    private final int x;
    private final int y;

    // public
    public Posision(final int x, final int y, final ESide sides) {
        this.x = x;
        this.y = y;
        this.side = sides;
    }

    public ESide getSide() {
        return side;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}