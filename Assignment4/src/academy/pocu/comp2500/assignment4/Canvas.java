package academy.pocu.comp2500.assignment4;

public class Canvas {
    private static final char DEFAULT_CHARACTER = ' ';

    private static final char UNDER_LIMIT_CHAR = 32;
    private static final char UPPER_LIMIT_CHAR = 126;

    // ---

    private final char[][] canvas;

    // ---

    public Canvas(final int width, final int height) {
        this.canvas = new char[height][width];
        clear();
    }

    // ---

    public final void clear() {
        for (int y = 0; y < this.getHeight(); ++y) {
            for (int x = 0; x < this.getWidth(); ++x) {
                this.drawPixel(x, y, DEFAULT_CHARACTER);
            }
        }
    }

    // ---

    public final String getDrawing() {
        final StringBuilder sb = new StringBuilder((getWidth() + 2) * (getHeight() + 2) + 2);

        sb.append('+');
        for (int w = 0; w < getWidth(); ++w) {
            sb.append("-");
        }
        sb.append('+');
        sb.append(System.lineSeparator());

        for (int y = 0; y < this.getHeight(); ++y) {
            sb.append('|');
            for (int x = 0; x < this.getWidth(); ++x) {
                sb.append(this.getPixel(x, y));
            }
            sb.append('|');
            sb.append(System.lineSeparator());
        }

        sb.append('+');
        for (int w = 0; w < getWidth(); ++w) {
            sb.append("-");
        }
        sb.append('+');
        sb.append(System.lineSeparator());

        return sb.toString();
    }

    public final int getWidth() {
        return this.canvas[0].length;
    }

    public final int getHeight() {
        return this.canvas.length;
    }

    public void drawPixel(final int x, final int y, final char character) {
        assert (UNDER_LIMIT_CHAR <= character && character <= UPPER_LIMIT_CHAR);

        this.canvas[y][x] = character;
    }

    public final char getPixel(final int x, final int y) {
        return this.canvas[y][x];
    }

    public final boolean increasePixel(final int x, final int y) {
        if (this.getPixel(x, y) < UPPER_LIMIT_CHAR) {
            this.drawPixel(x, y, (char) (this.getPixel(x, y) + 1));
            return true;
        }

        return false;
    }

    public final boolean decreasePixel(final int x, final int y) {
        if (this.getPixel(x, y) > UNDER_LIMIT_CHAR) {
            this.drawPixel(x, y, (char) (this.getPixel(x, y) - 1));
            return true;
        }

        return false;
    }

    public final void toUpper(final int x, final int y) {
        this.drawPixel(x, y, Character.toUpperCase(this.getPixel(x, y)));
    }

    public final void toLower(final int x, final int y) {
        this.drawPixel(x, y, Character.toLowerCase(this.getPixel(x, y)));
    }

    public final void fillHorizontalLine(final int y, final char character) {
        for (int x = 0; x < this.getWidth(); ++x) {
            this.drawPixel(x, y, character);
        }
    }

    public final void fillVerticalLine(final int x, final char character) {
        for (int y = 0; y < this.getHeight(); ++y) {
            this.drawPixel(x, y, character);
        }
    }
}
