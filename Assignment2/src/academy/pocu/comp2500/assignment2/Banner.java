package academy.pocu.comp2500.assignment2;

public class Banner extends ProductCanAddApertures {
    private final EBannerType bannerType;

    // public
    public Banner(final String productId, final EBannerType bannerType, final EBannerSize bannerSize, final short r, final short g, final short b, final EOrientation orientation) {
        super(productId, bannerType.getProductType(), orientation);

        final int price;
        switch (bannerType) {
            case GLOSS: {
                switch (bannerSize) {
                    case MM_1000_X_500:
                        price = 5000;
                        break;
                    case MM_1000_X_1000:
                        price = 5200;
                        break;
                    case MM_2000_X_500:
                        price = 5300;
                        break;
                    case MM_3000_X_1000:
                        price = 6000;
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
                        price = 5100;
                        break;
                    case MM_1000_X_1000:
                        price = 5300;
                        break;
                    case MM_2000_X_500:
                        price = 5400;
                        break;
                    case MM_3000_X_1000:
                        price = 6100;
                        break;
                    default:
                        throw new IllegalArgumentException("unknown type");
                }
            }
            break;
            default:
                throw new IllegalArgumentException("unknown type");
        }

        super.setWidth(bannerSize.getWidth());
        super.setHeight(bannerSize.getHeight());

        super.setColor(r, g, b);
        super.setBasePrice(price);

        this.bannerType = bannerType;
    }

    public EBannerType getBannerType() {
        return bannerType;
    }
}
