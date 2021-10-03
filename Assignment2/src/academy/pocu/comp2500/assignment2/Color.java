package academy.pocu.comp2500.assignment2;

public class Color {
    private final short r;
    private final short g;
    private final short b;

    // public
    public Color(final short r, final short g, final short b) {
        assert (0 <= r && r <= 0xff);
        assert (0 <= g && g <= 0xff);
        assert (0 <= b && b <= 0xff);

        this.r = r;
        this.g = g;
        this.b = b;
    }

    public short getR() {
        return r;
    }

    public short getG() {
        return g;
    }

    public short getB() {
        return b;
    }
}
