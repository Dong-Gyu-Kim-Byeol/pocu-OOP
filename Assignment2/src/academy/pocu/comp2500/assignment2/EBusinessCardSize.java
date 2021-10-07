package academy.pocu.comp2500.assignment2;

public enum EBusinessCardSize {
    MM_90_X_50;

    private static final Size MM_90_X_50_SIZE_LANDSCAPE = new Size(90, 50);
    private static final Size MM_90_X_50_SIZE_PORTRAIT = new Size(50, 90);

    public Size getSize(final EOrientation orientation) {
        final Size size;
        switch (this) {
            case MM_90_X_50: {
                switch (orientation) {
                    case LANDSCAPE:
                        size = MM_90_X_50_SIZE_LANDSCAPE;
                        break;
                    case PORTRAIT:
                        size = MM_90_X_50_SIZE_PORTRAIT;
                        break;
                    default:
                        throw new IllegalArgumentException("unknown type");
                }
                break;
            }

            default:
                throw new IllegalArgumentException("unknown type");
        }

        return size;
    }
}
