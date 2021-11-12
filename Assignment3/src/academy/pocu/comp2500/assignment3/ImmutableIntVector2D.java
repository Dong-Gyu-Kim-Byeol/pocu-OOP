package academy.pocu.comp2500.assignment3;

public class ImmutableIntVector2D {
    private int x;
    private int y;

    public ImmutableIntVector2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return this.x;
    }

    public int y() {
        return this.y;
    }
}
