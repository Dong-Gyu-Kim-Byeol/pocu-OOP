package academy.pocu.comp2500.assignment2;

public class BusinessCard extends ProductCanAddApertures {
    private final EBusinessCardType businessCardType;
    private final EBusinessCardSide sides;

    // public method
    public BusinessCard(final EBusinessCardType businessCardType, final EBusinessCardSide sides, final EOrientation orientation, final EBusinessCardColor businessCardColor) {
        super(businessCardType.getProductType(), orientation, sides.canBackSideAperture());

        final int basePrice;
        switch (businessCardType) {
            case LINEN:
                switch (sides) {
                    case SINGLE:
                        basePrice = 110;
                        break;
                    case DOUBLE:
                        basePrice = 140;
                        break;
                    default:
                        throw new IllegalArgumentException("unknown type");
                }
                break;

            case LAID:
                switch (sides) {
                    case SINGLE:
                        basePrice = 120;
                        break;
                    case DOUBLE:
                        basePrice = 150;
                        break;
                    default:
                        throw new IllegalArgumentException("unknown type");
                }
                break;

            case SMOOTH:
                switch (sides) {
                    case SINGLE:
                        basePrice = 100;
                        break;
                    case DOUBLE:
                        basePrice = 130;
                        break;
                    default:
                        throw new IllegalArgumentException("unknown type");
                }
                break;

            default:
                throw new IllegalArgumentException("unknown type");
        }

        super.setSize(EBusinessCardSize.MM_90_X_50.getSize());
        super.setColor(businessCardColor.getColor());
        super.setBasePrice(basePrice);

        this.businessCardType = businessCardType;
        this.sides = sides;
    }

    public EBusinessCardType getBusinessCardType() {
        return businessCardType;
    }

    public EBusinessCardSide getSides() {
        return sides;
    }
}
