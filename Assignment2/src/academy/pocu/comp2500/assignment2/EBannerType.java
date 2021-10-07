package academy.pocu.comp2500.assignment2;

public enum EBannerType {
    GLOSS,
    SCRIM,
    MESH;

    // public method
    public EProductType getProductType() {
        final EProductType productType;
        switch (this) {
            case GLOSS:
                productType = EProductType.GLOSS_BANNER;
                break;
            case SCRIM:
                productType = EProductType.SCRIM_BANNER;
                break;
            case MESH:
                productType = EProductType.MESH_BANNER;
                break;
            default:
                throw new IllegalArgumentException("unknown type");
        }

        return productType;
    }
}
