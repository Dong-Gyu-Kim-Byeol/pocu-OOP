package academy.pocu.comp2500.assignment2;

public enum EBusinessCardType {
    LINEN_SINGLE_SIDE,
    LAID_SINGLE_SIDE,
    SMOOTH_SINGLE_SIDE,

    LINEN_DOUBLE_SIDE,
    LAID_DOUBLE_SIDE,
    SMOOTH_DOUBLE_SIDE;

    // public
    public EProductType getProductType() {
        final EProductType productType;
        switch (this) {
            case LINEN_SINGLE_SIDE:
                productType = EProductType.LINEN_SINGLE_SIDE_BUSINESS_CARD;
                break;
            case LAID_SINGLE_SIDE:
                productType = EProductType.LAID_SINGLE_SIDE_BUSINESS_CARD;
                break;
            case SMOOTH_SINGLE_SIDE:
                productType = EProductType.SMOOTH_SINGLE_SIDE_BUSINESS_CARD;
                break;

            case LINEN_DOUBLE_SIDE:
                productType = EProductType.LINEN_DOUBLE_SIDE_BUSINESS_CARD;
                break;
            case LAID_DOUBLE_SIDE:
                productType = EProductType.LAID_DOUBLE_SIDE_BUSINESS_CARD;
                break;
            case SMOOTH_DOUBLE_SIDE:
                productType = EProductType.SMOOTH_DOUBLE_SIDE_BUSINESS_CARD;
                break;

            default:
                throw new IllegalArgumentException("unknown type");
        }

        return productType;
    }
}
