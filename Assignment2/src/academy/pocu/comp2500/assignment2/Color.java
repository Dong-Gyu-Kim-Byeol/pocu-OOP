package academy.pocu.comp2500.assignment2;

public class Color {
    public static final Color BLACK = new Color(0, 0, 0);
    public static final Color WHITE = new Color(0xff, 0xff, 0xff);

    public static final Color RED = new Color(0xff, 0, 0);
    public static final Color GREEN = new Color(0, 0x80, 0);
    public static final Color BLUE = new Color(0, 0, 0xff);

    public static final Color GRAY = new Color(0xE6, 0xE6, 0xE6);
    public static final Color IVORY = new Color(0xff, 0xff, 0xf0);

    private final short r;
    private final short g;
    private final short b;

    public Color(int r, int g, int b) {
        if (r < 0) {
            r = 0;
        } else if (r > 0xff) {
            r = 0xff;
        }

        if (g < 0) {
            g = 0;
        } else if (g > 0xff) {
            g = 0xff;
        }

        if (b < 0) {
            b = 0;
        } else if (b > 0xff) {
            b = 0xff;
        }

        this.r = (short) r;
        this.g = (short) g;
        this.b = (short) b;
    }

    public short getRed() {
        return r;
    }

    public short getGreen() {
        return g;
    }

    public short getBlue() {
        return b;
    }
}
