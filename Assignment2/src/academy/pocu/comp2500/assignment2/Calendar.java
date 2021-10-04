package academy.pocu.comp2500.assignment2;

public class Calendar extends Product {
    private final ECalendarType calendarType;

    // public
    public Calendar(final String productId, final ECalendarType calendarType) {
        super(productId, calendarType.getProductType());

        final Size size;
        final int price;
        switch (calendarType) {
            case WALL:
                size = new Size(400, 400);
                price = 1000;
                break;
            case DESK:
                size = new Size(200, 150);
                price = 1000;
                break;
            case MAGNET:
                size = new Size(100, 200);
                price = 1500;
                break;
            default:
                throw new IllegalArgumentException("unknown type");
        }

        super.setSize(size);
        super.setColor(new Color((short) 0xff, (short) 0xff, (short) 0xff));
        super.setPrice(price);

        this.calendarType = calendarType;
    }

    public ECalendarType getCalendarType() {
        return calendarType;
    }
}
