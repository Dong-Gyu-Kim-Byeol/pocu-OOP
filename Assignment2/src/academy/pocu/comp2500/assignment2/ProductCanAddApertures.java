package academy.pocu.comp2500.assignment2;

import java.util.HashSet;

public class ProductCanAddApertures extends Product {
    private static final int ADD_PRICE = 5;

    private final EOrientation orientation;
    private final HashSet<TextAperture> textApertures;
    private final HashSet<ImageAperture> imageApertures;

    // public
    public HashSet<TextAperture> getTextApertures() {
        return textApertures;
    }

    public void addTextAperture(final TextAperture textAperture) {
        if (textAperture.getApertureSide() == EApertureSide.BACK && super.getProductType().canBackSideAperture() == false) {
            return;
        }

        if (0 <= textAperture.getX() && textAperture.getX() < super.getWidth()) {
            if (0 <= textAperture.getY() && textAperture.getY() < super.getHeight()) {
                this.textApertures.add(textAperture);
                this.setAperturesPrice();
            }
        }
    }

    public HashSet<ImageAperture> getImageApertures() {
        return imageApertures;
    }

    public void addImageAperture(final ImageAperture imageAperture) {
        if (0 <= imageAperture.getX() && imageAperture.getX() < super.getWidth()) {
            if (0 <= imageAperture.getY() && imageAperture.getY() < super.getHeight()) {
                this.imageApertures.add(imageAperture);
                this.setAperturesPrice();
            }
        }
    }

    public EOrientation getOrientation() {
        return orientation;
    }

    // protected
    protected ProductCanAddApertures(final EProductType productType, final EOrientation orientation) {
        super(productType);

        this.textApertures = new HashSet<TextAperture>();
        this.imageApertures = new HashSet<ImageAperture>();
        this.orientation = orientation;
    }

    // private
    private void setAperturesPrice() {
        super.setAperturesPrice(this.textApertures.size() * ADD_PRICE + this.imageApertures.size() * ADD_PRICE);
    }
}
