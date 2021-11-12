package academy.pocu.comp2500.assignment3;

public final class ImmutableIntVector2D {
    public static final ImmutableIntVector2D MINUS_ONE = new ImmutableIntVector2D(-1, -1);

    private final int x;
    private final int y;

    public ImmutableIntVector2D(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public ImmutableIntVector2D(final IntVector2D other) {
        this.x = other.getX();
        this.y = other.getY();
    }

    public int x() {
        return this.x;
    }

    public int y() {
        return this.y;
    }
}
