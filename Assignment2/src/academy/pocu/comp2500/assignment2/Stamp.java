package academy.pocu.comp2500.assignment2;

public class Stamp extends Product {
    private final String text;

    // public
    public Stamp(final String productId, final EStampSize stampSize, final EStampColor stampColor, final String text) {
        super(productId, EProductType.STAMP);

        final int price;
        switch (stampSize) {
            case MM_40_X_30:
                // intentional fallthrough
            case MM_50_X_20:
                price = 2300;
                break;
            case MM_70_X_40:
                price = 2600;
                break;
            default:
                throw new IllegalArgumentException("unknown type");
        }

        super.setWidth(stampSize.getWidth());
        super.setHeight(stampSize.getHeight());

        super.setColor(stampColor.getColor());
        super.setPrice(price);

        this.text = text;
    }

    public String getText() {
        return text;
    }
}
