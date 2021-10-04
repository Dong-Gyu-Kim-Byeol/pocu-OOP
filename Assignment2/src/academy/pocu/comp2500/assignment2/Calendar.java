package academy.pocu.comp2500.assignment2;

public class Calendar extends Product {
    // public
    public Calendar(final ECalendarType calendarType) {
        super(calendarType.getProductType());

        final int width;
        final int height;
        final int basePrice;
        switch (calendarType) {
            case WALL:
                width = 400;
                height = 400;
                basePrice = 1000;
                break;
            case DESK:
                width = 200;
                height = 150;
                basePrice = 1000;
                break;
            case MAGNET:
                width = 100;
                height = 200;
                basePrice = 1500;
                break;
            default:
                throw new IllegalArgumentException("unknown type");
        }

        super.setWidth(width);
        super.setHeight(height);

        super.setColor((short) 0xff, (short) 0xff, (short) 0xff);
        super.setBasePrice(basePrice);
    }
}
