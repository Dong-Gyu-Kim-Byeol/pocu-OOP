package academy.pocu.comp2500.assignment2;

public class ProductCanAddTextAndImage extends Product {
    private static final int ADD_PRICE = 5;

    private final Orientation orientation;
    private AddText text;
    private AddImage image;


    // public
    public AddText getText() {
        return text;
    }

    public void setText(AddText text) {
        if (0 <= text.getPosision().getX() && text.getPosision().getX() <= getSize().getX()) {
            if (0 <= text.getPosision().getY() && text.getPosision().getY() <= getSize().getY()) {
                this.text = text;
            }
        }
    }

    public AddImage getImage() {
        return image;
    }

    public void setImage(AddImage image) {
        if (0 <= image.getPosision().getX() && image.getPosision().getX() <= getSize().getX()) {
            if (0 <= image.getPosision().getY() && image.getPosision().getY() <= getSize().getY()) {
                this.image = image;
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
        super.setAddPrice((this.text != null ? ADD_PRICE : 0) + (this.image != null ? ADD_PRICE : 0));
    }
}