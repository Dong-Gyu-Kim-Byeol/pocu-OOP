package academy.pocu.comp2500.assignment2;

public enum EBusinessCardType {
    LINEN,
    LAID,
    SMOOTH;

    // public
    public EProductType getProductType(final EBusinessCardSide sides) {
        final EProductType productType;
        switch (this) {
            case LINEN:
                switch (sides) {
                    case SINGLE:
                        productType = EProductType.LINEN_SINGLE_SIDE_BUSINESS_CARD;
                        break;
                    case DOUBLE:
                        productType = EProductType.LINEN_DOUBLE_SIDE_BUSINESS_CARD;
                        break;
                    default:
                        throw new IllegalArgumentException("unknown type");
                }
                break;

            case LAID:
                switch (sides) {
                    case SINGLE:
                        productType = EProductType.LAID_SINGLE_SIDE_BUSINESS_CARD;
                        break;
                    case DOUBLE:
                        productType = EProductType.LAID_DOUBLE_SIDE_BUSINESS_CARD;
                        break;
                    default:
                        throw new IllegalArgumentException("unknown type");
                }
                break;

            case SMOOTH:
                switch (sides) {
                    case SINGLE:
                        productType = EProductType.SMOOTH_SINGLE_SIDE_BUSINESS_CARD;
                        break;
                    case DOUBLE:
                        productType = EProductType.SMOOTH_DOUBLE_SIDE_BUSINESS_CARD;
                        break;
                    default:
                        throw new IllegalArgumentException("unknown type");
                }
                break;

            default:
                throw new IllegalArgumentException("unknown type");
        }

        return productType;
    }
}
