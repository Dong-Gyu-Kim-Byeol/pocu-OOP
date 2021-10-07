package academy.pocu.comp2500.assignment2;

public enum EBusinessCardSize {
    MM_90_X_50;

    private static final Size MM_90_X_50_SIZE = new Size(90, 50);

    public Size getSize() {
        final Size size;
        switch (this) {
            case MM_90_X_50:
                size = MM_90_X_50_SIZE;
                break;

            default:
                throw new IllegalArgumentException("unknown type");
        }

        return size;
    }
}
