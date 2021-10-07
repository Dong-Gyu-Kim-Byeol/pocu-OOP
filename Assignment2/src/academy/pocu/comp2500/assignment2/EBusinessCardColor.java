package academy.pocu.comp2500.assignment2;

public enum EBusinessCardColor {
    GRAY,
    IVORY,
    WHITE;

    private static final Color GRAY_COLOR = new Color(0xE6, 0xE6, 0xE6);
    private static final Color IVORY_COLOR = new Color(0xff, 0xff, 0xf0);
    private static final Color WHITE_COLOR = Color.WHITE;

    // public method
    public Color getColor() {
        final Color color;
        switch (this) {
            case GRAY:
                color = GRAY_COLOR;
                break;
            case IVORY:
                color = IVORY_COLOR;
                break;
            case WHITE:
                color = WHITE_COLOR;
                break;
            default:
                throw new IllegalArgumentException("unknown type");
        }

        return color;
    }
}
