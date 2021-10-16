package academy.pocu.comp2500.assignment2;

public enum EBusinessCardColor {
    GRAY,
    IVORY,
    WHITE;

    // public method
    public Color getColor() {
        final Color color;
        switch (this) {
            case GRAY:
                color = Color.GRAY;
                break;
            case IVORY:
                color = Color.IVORY;
                break;
            case WHITE:
                color = Color.WHITE;
                break;
            default:
                throw new IllegalArgumentException("unknown type");
        }

        return color;
    }
}
