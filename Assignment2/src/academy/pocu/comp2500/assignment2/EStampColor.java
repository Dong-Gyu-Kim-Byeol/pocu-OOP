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
                color = new Color((short) 0xff, (short) 0, (short) 0);
                break;
            case GREEN:
                color = new Color((short) 0, (short) 0x80, (short) 0);
                break;
            case BLUE:
                color = new Color((short) 0, (short) 0, (short) 0xff);
                break;
            default:
                throw new IllegalArgumentException("unknown type");
        }

        return color;
    }
}
