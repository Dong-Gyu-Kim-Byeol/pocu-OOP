package academy.pocu.comp2500.assignment2;

public class Calendar extends Product {
    private final ECalendarType calendarType;
    private static final Color CALENDAR_COLOR = Color.WHITE;

    // public method
    public Calendar(final ECalendarType calendarType) {
        super(calendarType.getProductType());

        final Size size;
        final int basePrice;
        switch (calendarType) {
            case WALL:
                size = ECalendarSize.MM_400_X_400.getSize();
                basePrice = 1000;
                break;
            case DESK:
                size = ECalendarSize.MM_200_X_150.getSize();
                basePrice = 1000;
                break;
            case MAGNET:
                size = ECalendarSize.MM_100_X_200.getSize();
                basePrice = 1500;
                break;
            default:
                throw new IllegalArgumentException("unknown type");
        }

        super.setSize(size);
        super.setColor(CALENDAR_COLOR);
        super.setBasePrice(basePrice);

        this.calendarType = calendarType;
    }

    public ECalendarType getCalendarType() {
        return calendarType;
    }

    public Color getCalendarColor() {
        return super.getColor();
    }
}
