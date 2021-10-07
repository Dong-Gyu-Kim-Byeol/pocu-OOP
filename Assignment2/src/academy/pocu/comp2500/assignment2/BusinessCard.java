package academy.pocu.comp2500.assignment2;

public class BusinessCard extends ProductCanAddApertures {
    private static final int WIDTH = 90;
    private static final int HEIGHT = 50;

    private final EBusinessCardType businessCardType;
    private final EBusinessCardSides sides;

    // public method
    public BusinessCard(final EBusinessCardType businessCardType, final EBusinessCardSides sides, final EBusinessCardColor businessCardColor, final EOrientation orientation) {
        super(businessCardType.getProductType(sides), sides.canBackSideAperture(), orientation);

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


        assert (WIDTH >= HEIGHT);
        switch (orientation) {
            case LANDSCAPE:
                super.setWidth(WIDTH);
                super.setHeight(HEIGHT);
                break;
            case PORTRAIT:
                super.setWidth(HEIGHT);
                super.setHeight(WIDTH);
                break;
            default:
                throw new IllegalArgumentException("unknown type");
        }

        super.setColor(businessCardColor.getColor());
        super.setBasePrice(basePrice);

        this.businessCardType = businessCardType;
        this.sides = sides;
    }

    public EBusinessCardType getBusinessCardType() {
        return businessCardType;
    }

    public EBusinessCardSides getSides() {
        return sides;
    }
}
