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
                productType = EProductType.LINEN_BUSINESS_CARD;
                break;
            case LAID:
                productType = EProductType.LAID_BUSINESS_CARD;
                break;
            case SMOOTH:
                productType = EProductType.SMOOTH_BUSINESS_CARD;
                break;
            default:
                throw new IllegalArgumentException("unknown type");
        }

        return productType;
    }
}
