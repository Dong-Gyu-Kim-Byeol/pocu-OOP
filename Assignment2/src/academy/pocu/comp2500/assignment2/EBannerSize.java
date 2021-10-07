package academy.pocu.comp2500.assignment2;

public enum EBannerSize {
    MM_1000_X_500,
    MM_1000_X_1000,
    MM_2000_X_500,
    MM_3000_X_1000;

    private static final Size MM_1000_X_500_LANDSCAPE_SIZE = new Size(1000, 500);
    private static final Size MM_1000_X_500_PORTRAIT_SIZE = new Size(500, 1000);

    private static final Size MM_1000_X_1000_SIZE = new Size(1000, 1000);

    private static final Size MM_2000_X_500_LANDSCAPE_SIZE = new Size(2000, 500);
    private static final Size MM_2000_X_500_PORTRAIT_SIZE = new Size(500, 2000);

    private static final Size MM_3000_X_1000_LANDSCAPE_SIZE = new Size(3000, 1000);
    private static final Size MM_3000_X_1000_PORTRAIT_SIZE = new Size(1000, 3000);

    // public method
    public Size getSize(final EOrientation orientation) {
        final Size size;
        switch (this) {
            case MM_1000_X_500: {
                switch (orientation) {
                    case LANDSCAPE:
                        size = MM_1000_X_500_LANDSCAPE_SIZE;
                        break;
                    case PORTRAIT:
                        size = MM_1000_X_500_PORTRAIT_SIZE;
                        break;
                    default:
                        throw new IllegalArgumentException("unknown type");
                }
                break;
            }

            case MM_1000_X_1000: {
                switch (orientation) {
                    case LANDSCAPE:
                        // intentional fallthrough
                    case PORTRAIT:
                        size = MM_1000_X_1000_SIZE;
                        break;
                    default:
                        throw new IllegalArgumentException("unknown type");
                }
                break;
            }

            case MM_2000_X_500: {
                switch (orientation) {
                    case LANDSCAPE:
                        size = MM_2000_X_500_LANDSCAPE_SIZE;
                        break;
                    case PORTRAIT:
                        size = MM_2000_X_500_PORTRAIT_SIZE;
                        break;
                    default:
                        throw new IllegalArgumentException("unknown type");
                }
                break;
            }

            case MM_3000_X_1000: {
                switch (orientation) {
                    case LANDSCAPE:
                        size = MM_3000_X_1000_LANDSCAPE_SIZE;
                        break;
                    case PORTRAIT:
                        size = MM_3000_X_1000_PORTRAIT_SIZE;
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
