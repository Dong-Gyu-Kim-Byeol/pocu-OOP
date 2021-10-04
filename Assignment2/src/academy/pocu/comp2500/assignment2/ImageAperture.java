package academy.pocu.comp2500.assignment2;

public class ImageAperture extends Aperture {
    private final String imagePath;

    public ImageAperture(final String apertureId, final int x, final int y, final EApertureSide sides, final String imagePath) {
        super(apertureId, x, y, sides);
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }
}
