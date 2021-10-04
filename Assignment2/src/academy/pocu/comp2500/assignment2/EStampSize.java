package academy.pocu.comp2500.assignment2;

public enum EStampSize {
    MM_40_X_30,
    MM_50_X_20,
    MM_70_X_40;

    // public
    public int getWidth() {
        final int width;
        switch (this) {
            case MM_40_X_30:
                width = 40;
                break;
            case MM_50_X_20:
                width = 50;
                break;
            case MM_70_X_40:
                width = 70;
                break;
            default:
                throw new IllegalArgumentException("unknown type");
        }

        return width;
    }

    public int getHeight() {
        final int height;
        switch (this) {
            case MM_40_X_30:
                height = 30;
                break;
            case MM_50_X_20:
                height = 20;
                break;
            case MM_70_X_40:
                height = 40;
                break;
            default:
                throw new IllegalArgumentException("unknown type");
        }

        return height;
    }
}
