package academy.pocu.comp2500.assignment2;

public enum EBusinessCardColor {
    GRAY,
    IVORY,
    WHITE;

    // public
    public Color getColor() {
        final Color color;
        switch (this) {
            case GRAY:
                color = new Color((short) 0xE6, (short) 0xE6, (short) 0xE6);
                break;
            case IVORY:
                color = new Color((short) 0xff, (short) 0xff, (short) 0xf0);
                break;
            case WHITE:
                color = new Color((short) 0xff, (short) 0xff, (short) 0xff);
                break;
            default:
                throw new IllegalArgumentException("unknown type");
        }

        return color;
    }
}
