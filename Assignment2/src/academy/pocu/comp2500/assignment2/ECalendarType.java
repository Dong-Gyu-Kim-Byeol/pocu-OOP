package academy.pocu.comp2500.assignment2;

public enum ECalendarType {
    WALL,
    DESK,
    MAGNET;

    // public method
    public EProductType getProductType() {
        final EProductType productType;
        switch (this) {
            case WALL:
                productType = EProductType.WALL_CALENDAR;
                break;
            case DESK:
                productType = EProductType.DESK_CALENDAR;
                break;
            case MAGNET:
                productType = EProductType.MAGNET_CALENDAR;
                break;
            default:
                throw new IllegalArgumentException("unknown type");
        }

        return productType;
    }
}
