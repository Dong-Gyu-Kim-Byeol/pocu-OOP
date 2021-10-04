package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class ProductCanAddTextAndImage extends Product {
    private static final int ADD_PRICE = 5;

    private final Orientation orientation;
    private final ArrayList<TextAperture> textApertures;
    private final ArrayList<ImageAperture> imageApertures;

    // public
    public ArrayList<TextAperture> getTextApertures() {
        return textApertures;
    }

    public void addTextAperture(final TextAperture textAperture) {
        if (0 <= textAperture.getX() && textAperture.getX() < super.getSize().getX()) {
            if (0 <= textAperture.getY() && textAperture.getY() < super.getSize().getY()) {
                this.textApertures.add(textAperture);
                this.setAddPrice();
            }
        }
    }

    public ArrayList<ImageAperture> getImageApertures() {
        return imageApertures;
    }

    public void addImageAperture(final ImageAperture imageAperture) {
        if (0 <= imageAperture.getX() && imageAperture.getX() < super.getSize().getX()) {
            if (0 <= imageAperture.getY() && imageAperture.getY() < super.getSize().getY()) {
                this.imageApertures.add(imageAperture);
                this.setAddPrice();
            }
        }
    }

    public Orientation getOrientation() {
        return orientation;
    }


    // protected
    protected ProductCanAddTextAndImage(final EProductType productType, final Orientation orientation) {
        super(productType);

        this.textApertures = new ArrayList<TextAperture>();
        this.imageApertures = new ArrayList<ImageAperture>();
        this.orientation = orientation;
    }

    // private
    private void setAddPrice() {
        super.setAddPrice(this.textApertures.size() * ADD_PRICE + this.imageApertures.size() * ADD_PRICE);
    }
}
