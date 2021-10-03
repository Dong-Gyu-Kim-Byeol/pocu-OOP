package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class ProductCanAddTextAndImage extends Product {
    private static final int ADD_PRICE = 5;

    private final Orientation orientation;
    private ArrayList<Text> texts;
    private ArrayList<Image> images;


    // public
    public Orientation getOrientation() {
        return orientation;
    }

    public void setTexts(ArrayList<Text> texts) {
        this.texts = texts;
        this.setAddPrice();
    }

    public void setImages(ArrayList<Image> images) {
        this.images = images;
        this.setAddPrice();
    }

    // protected
    protected ProductCanAddTextAndImage(final EProductType productType, final Orientation orientation) {
        super(productType);

        this.texts = new ArrayList<Text>();
        this.images = new ArrayList<Image>();
        this.orientation = orientation;
    }

    protected ArrayList<Text> getTexts() {
        return texts;
    }

    protected int getTextCount() {
        return texts.size();
    }

    protected ArrayList<Image> getImages() {
        return images;
    }

    protected int getImageCount() {
        return images.size();
    }

    // private
    private void setAddPrice() {
        super.setAddPrice(this.getTextCount() * ADD_PRICE + this.getImageCount() * ADD_PRICE);
    }
}
