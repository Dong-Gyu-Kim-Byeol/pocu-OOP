package academy.pocu.comp2500.assignment2;

public enum EStampColor {
    RED,
    GREEN,
    BLUE;

    private static final Color RED_COLOR = new Color(0xff, 0, 0);
    private static final Color GREEN_COLOR = new Color(0, 0x80, 0);
    private static final Color BLUE_COLOR = new Color(0, 0, 0xff);

    // public method
    public Color getColor() {
        final Color color;
        switch (this) {
            case RED:
                color = RED_COLOR;
                break;
            case GREEN:
                color = GREEN_COLOR;
                break;
            case BLUE:
                color = BLUE_COLOR;
                break;
            default:
                throw new IllegalArgumentException("unknown type");
        }

        return color;
    }
}
