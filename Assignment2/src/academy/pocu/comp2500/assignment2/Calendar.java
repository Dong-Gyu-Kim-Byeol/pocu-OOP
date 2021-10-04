package academy.pocu.comp2500.assignment2;

public class Calendar extends Product {
    private final ECalendarType calendarType;

    // public
    public Calendar(final String productId, final ECalendarType calendarType) {
        super(productId, calendarType.getProductType());

        final int width;
        final int height;
        final int price;
        switch (calendarType) {
            case WALL:
                width = 400;
                height = 400;
                price = 1000;
                break;
            case DESK:
                width = 200;
                height = 150;
                price = 1000;
                break;
            case MAGNET:
                width = 100;
                height = 200;
                price = 1500;
                break;
            default:
                throw new IllegalArgumentException("unknown type");
        }

        super.setWidth(width);
        super.setHeight(height);

        super.setColor(new Color((short) 0xff, (short) 0xff, (short) 0xff));
        super.setPrice(price);

        this.calendarType = calendarType;
    }

    public ECalendarType getCalendarType() {
        return calendarType;
    }
}
