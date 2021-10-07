package academy.pocu.comp2500.assignment2;

public class Banner extends ProductCanAddApertures {
    private final EBannerType bannerType;

    // public
    public Banner(final EBannerType bannerType, final EBannerSize bannerSize, final Color color, final EOrientation orientation) {
        super(bannerType.getProductType(), false, orientation);

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
            }
            break;

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
            }
            break;

            default:
                throw new IllegalArgumentException("unknown type");
        }

        assert (bannerSize.getWidth() >= bannerSize.getHeight());
        switch (orientation) {
            case LANDSCAPE:
                super.setWidth(bannerSize.getWidth());
                super.setHeight(bannerSize.getHeight());
                break;
            case PORTRAIT:
                super.setWidth(bannerSize.getHeight());
                super.setHeight(bannerSize.getWidth());
                break;
            default:
                throw new IllegalArgumentException("unknown type");
        }


        super.setColor(color);
        super.setBasePrice(basePrice);

        this.bannerType = bannerType;
    }

    public EBannerType getBannerType() {
        return bannerType;
    }
}
