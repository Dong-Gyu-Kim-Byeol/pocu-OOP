package academy.pocu.comp2500.assignment4;

public final class Canvas {
    private static final char DEFAULT_CHAR = ' ';

    // ---

    private final char[][] canvas;

    // ---

    public Canvas(final int width, final int height) {
        this.canvas = new char[height][width];
        for (int h = 0; h < this.canvas.length; ++h) {
            for (int w = 0; w < this.canvas[0].length; ++w) {
                this.canvas[h][w] = DEFAULT_CHAR;
            }
        }
    }

    // ---

    public final int getWidth() {
        return this.canvas[0].length;
    }

    public final int getHeight() {
        return this.canvas.length;
    }


}
