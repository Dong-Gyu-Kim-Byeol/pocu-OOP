package academy.pocu.comp2500.assignment2;

public enum EStampColor {
    RED,
    GREEN,
    BLUE;

    // public
    public int getColor() {
        final int color;
        switch (this) {
            case RED:
                color = 0xff0000;
                break;
            case GREEN:
                color = 0x008000;
                break;
            case BLUE:
                color = 0x0000ff;
                break;
            default:
                throw new IllegalArgumentException("unknown type");
        }

        return color;
    }
}
