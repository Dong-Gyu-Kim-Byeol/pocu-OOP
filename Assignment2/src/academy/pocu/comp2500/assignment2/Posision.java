package academy.pocu.comp2500.assignment2;

public class Posision {
    private final boolean isDoubleSidedBusinessCard;
    private final int x;
    private final int y;

    // public
    public Posision(final int x, final int y, final boolean doubleSidedBusinessCard) {
        this.x = x;
        this.y = y;
        this.isDoubleSidedBusinessCard = doubleSidedBusinessCard;
    }

    public boolean isDoubleSidedBusinessCard() {
        return isDoubleSidedBusinessCard;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
