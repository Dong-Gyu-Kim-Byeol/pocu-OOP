package academy.pocu.comp2500.assignment2;

import java.util.HashMap;

public class ProductCanAddApertures extends Product {
    private static final int ADD_PRICE = 5;

    private final Orientation orientation;
    private final HashMap<String, TextAperture> textApertures;
    private final HashMap<String, ImageAperture> imageApertures;

    // public
    public HashMap<String, TextAperture> getTextApertures() {
        return textApertures;
    }

    public void addTextAperture(final TextAperture textAperture) {
        if (0 <= textAperture.getX() && textAperture.getX() < super.getWidth()) {
            if (0 <= textAperture.getY() && textAperture.getY() < super.getHeight()) {
                this.textApertures.put(textAperture.getApertureId(), textAperture);
                this.setAperturesPrice();
            }
        }
    }

    public HashMap<String, ImageAperture> getImageApertures() {
        return imageApertures;
    }

    public void addImageAperture(final ImageAperture imageAperture) {
        if (0 <= imageAperture.getX() && imageAperture.getX() < super.getWidth()) {
            if (0 <= imageAperture.getY() && imageAperture.getY() < super.getHeight()) {
                this.imageApertures.put(imageAperture.getApertureId(), imageAperture);
                this.setAperturesPrice();
            }
        }
    }

    public Orientation getOrientation() {
        return orientation;
    }


    // protected
    protected ProductCanAddApertures(final String productId, final EProductType productType, final Orientation orientation) {
        super(productId, productType);

        this.textApertures = new HashMap<String, TextAperture>();
        this.imageApertures = new HashMap<String, ImageAperture>();
        this.orientation = orientation;
    }

    // private
    private void setAperturesPrice() {
        super.setAperturesPrice(this.textApertures.size() * ADD_PRICE + this.imageApertures.size() * ADD_PRICE);
    }
}
