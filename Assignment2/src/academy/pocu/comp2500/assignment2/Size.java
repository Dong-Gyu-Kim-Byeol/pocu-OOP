package academy.pocu.comp2500.assignment2;

public class Size {
    private final int x;
    private final int y;

    // public
    public Size(final int x, final int y) {
        assert (0 <= x);
        assert (0 <= y);

        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
