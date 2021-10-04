package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class ProductCanAddTextAndImage extends Product {
    private static final int ADD_PRICE = 5;

    private final Orientation orientation;
    private final ArrayList<AddText> texts;
    private final ArrayList<AddImage> images;

    // public
    public ArrayList<AddText> getTexts() {
        return texts;
    }

    public void addText(final AddText text) {
        if (0 <= text.getPosision().getX() && text.getPosision().getX() <= getSize().getX()) {
            if (0 <= text.getPosision().getY() && text.getPosision().getY() <= getSize().getY()) {
                this.texts.add(text);
            }
        }
    }

    public ArrayList<AddImage> getImages() {
        return images;
    }

    public void addImage(final AddImage image) {
        if (0 <= image.getPosision().getX() && image.getPosision().getX() <= getSize().getX()) {
            if (0 <= image.getPosision().getY() && image.getPosision().getY() <= getSize().getY()) {
                this.images.add(image);
            }
        }
    }

    public Orientation getOrientation() {
        return orientation;
    }


    // protected
    protected ProductCanAddTextAndImage(final EProductType productType, final Orientation orientation) {
        super(productType);

        this.texts = new ArrayList<AddText>();
        this.images = new ArrayList<AddImage>();
        this.orientation = orientation;
    }

    // private
    private void setAddPrice() {
        super.setAddPrice(this.texts.size() * ADD_PRICE + this.images.size() * ADD_PRICE);
    }
}
