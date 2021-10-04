package academy.pocu.comp2500.assignment2;

public class ProductCanAddTextAndImage extends Product {
    private static final int ADD_PRICE = 5;

    private final Orientation orientation;
    private AddText textOrNull;
    private AddImage imageOrNull;

    // public
    public AddText getTextOrNull() {
        return textOrNull;
    }

    public void setText(AddText text) {
        if (0 <= text.getPosision().getX() && text.getPosision().getX() <= getSize().getX()) {
            if (0 <= text.getPosision().getY() && text.getPosision().getY() <= getSize().getY()) {
                this.textOrNull = text;
            }
        }
    }

    public AddImage getImageOrNull() {
        return imageOrNull;
    }

    public void setImage(AddImage image) {
        if (0 <= image.getPosision().getX() && image.getPosision().getX() <= getSize().getX()) {
            if (0 <= image.getPosision().getY() && image.getPosision().getY() <= getSize().getY()) {
                this.imageOrNull = image;
            }
        }
    }

    public Orientation getOrientation() {
        return orientation;
    }


    // protected
    protected ProductCanAddTextAndImage(final EProductType productType, final Orientation orientation) {
        super(productType);

        this.orientation = orientation;
    }

    // private
    private void setAddPrice() {
        super.setAddPrice((this.textOrNull != null ? ADD_PRICE : 0) + (this.imageOrNull != null ? ADD_PRICE : 0));
    }
}
