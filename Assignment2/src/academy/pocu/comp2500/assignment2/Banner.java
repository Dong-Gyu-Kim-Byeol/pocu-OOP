package academy.pocu.comp2500.assignment2;

public class Banner extends ProductCanAddApertures {
    private final EBannerType bannerType;

    // public method
    public Banner(final EBannerType bannerType, final EBannerSize bannerSize, final EOrientation orientation, final Color bannerColor) {
        super(bannerType.getProductType(), orientation, false);

        final int basePrice;
        switch (bannerType) {
            case GLOSS: {
                switch (bannerSize) {
                    case MM_1000_X_500:
                        basePrice = 5000;
                        break;
                    case MM_1000_X_1000:
                        basePrice = 5200;
                        break;
                    case MM_2000_X_500:
                        basePrice = 5300;
                        break;
                    case MM_3000_X_1000:
                        basePrice = 6000;
                        break;
                    default:
                        throw new IllegalArgumentException("unknown type");
                }
                break;
            }

            case SCRIM:
                // intentional fallthrough

            case MESH: {
                switch (bannerSize) {
                    case MM_1000_X_500:
                        basePrice = 5100;
                        break;
                    case MM_1000_X_1000:
                        basePrice = 5300;
                        break;
                    case MM_2000_X_500:
                        basePrice = 5400;
                        break;
                    case MM_3000_X_1000:
                        basePrice = 6100;
                        break;
                    default:
                        throw new IllegalArgumentException("unknown type");
                }
                break;
            }

            default:
                throw new IllegalArgumentException("unknown type");
        }

        super.setSize(bannerSize.getSize());
        super.setColor(bannerColor);
        super.setBasePrice(basePrice);

        this.bannerType = bannerType;
    }

    public EBannerType getBannerType() {
        return bannerType;
    }

    public Color getBannerColor() {
        return super.getColor();
    }
}
