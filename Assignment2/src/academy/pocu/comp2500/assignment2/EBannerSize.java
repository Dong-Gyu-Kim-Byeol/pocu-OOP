package academy.pocu.comp2500.assignment2;

public enum EBannerSize {
    MM_1000_X_500,
    MM_1000_X_1000,
    MM_2000_X_500,
    MM_3000_X_1000;

    // public method
    public int getWidth() {
        final int width;
        switch (this) {
            case MM_1000_X_500:
                width = 1000;
                break;
            case MM_1000_X_1000:
                width = 1000;
                break;
            case MM_2000_X_500:
                width = 2000;
                break;
            case MM_3000_X_1000:
                width = 3000;
                break;
            default:
                throw new IllegalArgumentException("unknown type");
        }

        return width;
    }

    public int getHeight() {
        final int height;
        switch (this) {
            case MM_1000_X_500:
                height = 500;
                break;
            case MM_1000_X_1000:
                height = 1000;
                break;
            case MM_2000_X_500:
                height = 500;
                break;
            case MM_3000_X_1000:
                height = 1000;
                break;
            default:
                throw new IllegalArgumentException("unknown type");
        }

        return height;
    }
}
