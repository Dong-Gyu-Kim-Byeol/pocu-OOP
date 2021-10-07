package academy.pocu.comp2500.assignment2;

public enum EStampSize {
    MM_40_X_30,
    MM_50_X_20,
    MM_70_X_40;

    private static final Size MM_40_X_30_SIZE = new Size(40, 30);
    private static final Size MM_50_X_20_SIZE = new Size(50, 20);
    private static final Size MM_70_X_40_SIZE = new Size(70, 40);

    // public method
    public Size getSize() {
        final Size size;
        switch (this) {
            case MM_40_X_30:
                size = MM_40_X_30_SIZE;
                break;
            case MM_50_X_20:
                size = MM_50_X_20_SIZE;
                break;
            case MM_70_X_40:
                size = MM_70_X_40_SIZE;
                break;
            default:
                throw new IllegalArgumentException("unknown type");
        }

        return size;
    }
}
