package academy.pocu.comp2500.assignment2;

import java.util.HashSet;

public class ProductCanAddApertures extends Product {
    private static final int APERTURE_PRICE = 5;

    private final boolean canBackSideAperture;
    private final EOrientation orientation;
    private final HashSet<Aperture> apertures;

    // public
    public HashSet<Aperture> getApertures() {
        return apertures;
    }

    public void addAperture(final Aperture aperture) {
        if (aperture.getApertureSide() != EApertureSide.FRONT && this.canBackSideAperture() == false) {
            return;
        }

        if (0 <= aperture.getX() && aperture.getX() < super.getWidth()) {
            if (0 <= aperture.getY() && aperture.getY() < super.getHeight()) {
                this.apertures.add(aperture);
                this.setAperturesPrice();
            }
        }
    }

    public EOrientation getOrientation() {
        return orientation;
    }

    // protected
    protected ProductCanAddApertures(final EProductType productType, final boolean canBackSideAperture, final EOrientation orientation) {
        super(productType);

        this.canBackSideAperture = canBackSideAperture;
        this.apertures = new HashSet<Aperture>();
        this.orientation = orientation;
    }

    // private
    private void setAperturesPrice() {
        super.aperturesPrice = this.apertures.size() * APERTURE_PRICE;
    }

    public boolean canBackSideAperture() {
        return canBackSideAperture;
    }
}
