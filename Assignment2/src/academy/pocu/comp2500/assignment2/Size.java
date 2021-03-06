package academy.pocu.comp2500.assignment2;

public class Size {
    private final int width;
    private final int height;

    public Size(final int width, final int height) {
        assert (width > 0);
        assert (height > 0);

        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
