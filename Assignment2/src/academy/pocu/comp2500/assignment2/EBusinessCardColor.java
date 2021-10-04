package academy.pocu.comp2500.assignment2;

public enum EBusinessCardColor {
    GRAY,
    IVORY,
    WHITE;

    // public
    public int getColor() {
        final int color;
        switch (this) {
            case GRAY:
                color = 0xE6E6E6;
                break;
            case IVORY:
                color = 0xfffff0;
                break;
            case WHITE:
                color = 0xffffff;
                break;
            default:
                throw new IllegalArgumentException("unknown type");
        }

        return color;
    }
}
