package academy.pocu.comp2500.assignment2;

public enum EStampColor {
    RED,
    GREEN,
    BLUE;

    // public
    public Color getColor() {
        final Color color;
        switch (this) {
            case RED:
                color = new Color(0xff, 0, 0);
                break;
            case GREEN:
                color = new Color(0, 0x80, 0);
                break;
            case BLUE:
                color = new Color(0, 0, 0xff);
                break;
            default:
                throw new IllegalArgumentException("unknown type");
        }

        return color;
    }
}
