package academy.pocu.comp2500.assignment2;

import java.util.HashSet;

public class ProductCanAddApertures extends Product {
    private static final int APERTURE_PRICE = 5;

    private final boolean canBackSideAperture;
    private final HashSet<Aperture> apertures;

    // public method
    public HashSet<Aperture> getApertures() {
        return apertures;
    }

    public void addAperture(final Aperture aperture) {
        if (aperture.getApertureSides() != EApertureSides.FRONT && this.canBackSideAperture() == false) {
            return;
        }

        if (0 <= aperture.getX() && aperture.getX() < super.getSize().getWidth()) {
            if (0 <= aperture.getY() && aperture.getY() < super.getSize().getHeight()) {
                this.apertures.add(aperture);
                this.setAperturesPrice();
            }
        }
    }

    // protected method
    protected ProductCanAddApertures(final EProductType productType, final boolean canBackSideAperture) {
        super(productType);

        this.canBackSideAperture = canBackSideAperture;
        this.apertures = new HashSet<Aperture>();
    }

    // private method
    private void setAperturesPrice() {
        super.aperturePrice = this.apertures.size() * APERTURE_PRICE;
    }

    public boolean canBackSideAperture() {
        return canBackSideAperture;
    }
}
