package academy.pocu.comp2500.assignment2;

public enum EStampColor {
    RED,
    GREEN,
    BLUE;

    // public method
    public Color getColor() {
        final Color color;
        switch (this) {
            case RED:
                color = Color.RED;
                break;
            case GREEN:
                color = Color.GREEN;
                break;
            case BLUE:
                color = Color.BLUE;
                break;
            default:
                throw new IllegalArgumentException("unknown type");
        }

        return color;
    }
}
