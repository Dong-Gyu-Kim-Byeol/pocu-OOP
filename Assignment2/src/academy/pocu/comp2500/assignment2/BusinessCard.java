package academy.pocu.comp2500.assignment2;

public class BusinessCard extends ProductCanAddApertures {
    // public
    public BusinessCard(final EBusinessCardType businessCardType, final EBusinessCardColor businessCardColor, final EOrientation orientation) {
        super(businessCardType.getProductType(), orientation);

        final int basePrice;
        switch (businessCardType) {
            case LINEN_SINGLE_SIDE:
                basePrice = 110;
                break;
            case LAID_SINGLE_SIDE:
                basePrice = 120;
                break;
            case SMOOTH_SINGLE_SIDE:
                basePrice = 100;
                break;

            case LINEN_DOUBLE_SIDE:
                basePrice = 140;
                break;
            case LAID_DOUBLE_SIDE:
                basePrice = 150;
                break;
            case SMOOTH_DOUBLE_SIDE:
                basePrice = 130;
                break;

            default:
                throw new IllegalArgumentException("unknown type");
        }

        super.setWidth(90);
        super.setHeight(50);

        super.setColor(businessCardColor.getR(), businessCardColor.getG(), businessCardColor.getB());
        super.setBasePrice(basePrice);
    }
}
