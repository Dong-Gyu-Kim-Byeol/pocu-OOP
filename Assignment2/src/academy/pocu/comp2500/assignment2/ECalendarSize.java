package academy.pocu.comp2500.assignment2;

public enum ECalendarSize {
    MM_400_X_400,
    MM_200_X_150,
    MM_100_X_200;

    private static final Size MM_400_X_400_SIZE = new Size(400, 400);
    private static final Size MM_200_X_150_SIZE = new Size(200, 150);
    private static final Size MM_100_X_200_SIZE = new Size(100, 200);

    // public method
    public Size getSize() {
        final Size size;
        switch (this) {
            case MM_400_X_400:
                size = MM_400_X_400_SIZE;
                break;
            case MM_200_X_150:
                size = MM_200_X_150_SIZE;
                break;
            case MM_100_X_200:
                size = MM_100_X_200_SIZE;
                break;
            default:
                throw new IllegalArgumentException("unknown type");
        }

        return size;
    }
}
