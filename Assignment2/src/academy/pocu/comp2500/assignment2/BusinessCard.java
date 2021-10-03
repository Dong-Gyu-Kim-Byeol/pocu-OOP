package academy.pocu.comp2500.assignment2;

public class BusinessCard extends ProductCanAddTextAndImage {
    private final EBusinessCardType businessCardType;
    private final boolean isDoubleSidedBusinessCard;

    // public
    public BusinessCard(final EBusinessCardType businessCardType, final EBusinessCardColor businessCardColor, final Orientation orientation, final boolean doubleSidedBusinessCard) {
        super(businessCardType.getProductType(), orientation);

        final int price;
        switch (businessCardType) {
            case LINEN:
                price = doubleSidedBusinessCard ? 140 : 110;
                break;
            case LAID:
                price = doubleSidedBusinessCard ? 150 : 120;
                break;
            case SMOOTH:
                price = doubleSidedBusinessCard ? 130 : 100;
                break;
            default:
                throw new IllegalArgumentException("unknown type");
        }

        super.setSize(new Size(90, 50));
        super.setColor(businessCardColor.getColor());
        super.setPrice(price);

        this.businessCardType = businessCardType;
        this.isDoubleSidedBusinessCard = doubleSidedBusinessCard;
    }

    public EBusinessCardType getBusinessCardType() {
        return businessCardType;
    }

    public boolean isDoubleSidedBusinessCard() {
        return isDoubleSidedBusinessCard;
    }
}
