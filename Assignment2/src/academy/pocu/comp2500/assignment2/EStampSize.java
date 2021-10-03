package academy.pocu.comp2500.assignment2;

public enum EStampSize {
    MM_40_X_30,
    MM_50_X_20,
    MM_70_X_40;

    // public
    public Size getSize() {
        final Size size;
        switch (this) {
            case MM_40_X_30:
                size = new Size(40, 30);
                break;
            case MM_50_X_20:
                size = new Size(50, 20);
                break;
            case MM_70_X_40:
                size = new Size(70, 40);
                break;
            default:
                throw new IllegalArgumentException("unknown type");
        }

        return size;
    }
}
