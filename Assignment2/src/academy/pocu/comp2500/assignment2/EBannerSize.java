package academy.pocu.comp2500.assignment2;

public enum EBannerSize {
    MM_1000_X_500,
    MM_1000_X_1000,
    MM_2000_X_500,
    MM_3000_X_1000;

    // public
    public Size getSize() {
        final Size size;
        switch (this) {
            case MM_1000_X_500:
                size = new Size(1000, 500);
                break;
            case MM_1000_X_1000:
                size = new Size(1000, 1000);
                break;
            case MM_2000_X_500:
                size = new Size(2000, 500);
                break;
            case MM_3000_X_1000:
                size = new Size(3000, 1000);
                break;
            default:
                throw new IllegalArgumentException("unknown type");
        }

        return size;
    }
}
