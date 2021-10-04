package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

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
        if (0 <= textAperture.getX() && textAperture.getX() < super.getSize().getX()) {
            if (0 <= textAperture.getY() && textAperture.getY() < super.getSize().getY()) {
                this.textApertures.put(textAperture.getApertureId(), textAperture);
                this.setAddPrice();
            }
        }
    }

    public HashMap<String, ImageAperture> getImageApertures() {
        return imageApertures;
    }

    public void addImageAperture(final ImageAperture imageAperture) {
        if (0 <= imageAperture.getX() && imageAperture.getX() < super.getSize().getX()) {
            if (0 <= imageAperture.getY() && imageAperture.getY() < super.getSize().getY()) {
                this.imageApertures.put(imageAperture.getApertureId(), imageAperture);
                this.setAddPrice();
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
    private void setAddPrice() {
        super.setAddPrice(this.textApertures.size() * ADD_PRICE + this.imageApertures.size() * ADD_PRICE);
    }
}
