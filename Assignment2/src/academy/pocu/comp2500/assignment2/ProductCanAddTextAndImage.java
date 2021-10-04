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

    public void setText(AddText textOrNull) {
        if (textOrNull == null) {
            this.textOrNull = null;
        } else {
            if (0 <= textOrNull.getPosision().getX() && textOrNull.getPosision().getX() <= getSize().getX()) {
                if (0 <= textOrNull.getPosision().getY() && textOrNull.getPosision().getY() <= getSize().getY()) {
                    this.textOrNull = textOrNull;
                }
            }
        }
    }

    public AddImage getImageOrNull() {
        return imageOrNull;
    }

    public void setImage(AddImage imageOrNull) {
        if (imageOrNull == null) {
            this.imageOrNull = null;
        } else {
            if (0 <= imageOrNull.getPosision().getX() && imageOrNull.getPosision().getX() <= getSize().getX()) {
                if (0 <= imageOrNull.getPosision().getY() && imageOrNull.getPosision().getY() <= getSize().getY()) {
                    this.imageOrNull = imageOrNull;
                }
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
