package academy.pocu.comp2500.assignment2;

public class Stamp extends Product {
    private final String text;

    // public method
    public Stamp(final EStampSize stampSize, final EStampColor stampColor, final String text) {
        super(EProductType.STAMP);

        final int basePrice;
        switch (stampSize) {
            case MM_40_X_30:
                basePrice = 2300;
                break;
            case MM_50_X_20:
                basePrice = 2300;
                break;
            case MM_70_X_40:
                basePrice = 2600;
                break;
            default:
                throw new IllegalArgumentException("unknown type");
        }

        super.setSize(stampSize.getSize());
        super.setColor(stampColor.getColor());
        super.addPrice(basePrice);

        this.text = text;
    }

    public String getText() {
        return text;
    }
}
