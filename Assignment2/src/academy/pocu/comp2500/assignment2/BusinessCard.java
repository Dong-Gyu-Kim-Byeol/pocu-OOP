package academy.pocu.comp2500.assignment2;

public class BusinessCard extends ProductCanAddApertures {
    private final EBusinessCardType businessCardType;
    private final EBusinessCardSides cardSides;

    // public
    public BusinessCard(final EBusinessCardType businessCardType, final EBusinessCardColor businessCardColor, final EOrientation orientation, final EBusinessCardSides cardSides) {
        super(businessCardType.getProductType(), orientation);

        final int price;
        switch (businessCardType) {
            case LINEN:
                price = cardSides == EBusinessCardSides.DOUBLE_SIZE ? 140 : 110;
                break;
            case LAID:
                price = cardSides == EBusinessCardSides.DOUBLE_SIZE ? 150 : 120;
                break;
            case SMOOTH:
                price = cardSides == EBusinessCardSides.DOUBLE_SIZE ? 130 : 100;
                break;
            default:
                throw new IllegalArgumentException("unknown type");
        }

        super.setWidth(90);
        super.setHeight(50);

        super.setColor(businessCardColor.getR(), businessCardColor.getG(), businessCardColor.getB());
        super.setBasePrice(price);

        this.businessCardType = businessCardType;
        this.cardSides = cardSides;
    }

    public EBusinessCardType getBusinessCardType() {
        return businessCardType;
    }

    public EBusinessCardSides getCardSides() {
        return cardSides;
    }
}
