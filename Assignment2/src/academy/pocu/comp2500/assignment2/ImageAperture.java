package academy.pocu.comp2500.assignment2;

public class ImageAperture extends Aperture {
    private final String imagePath;

    public ImageAperture(final EApertureSide sides, final int x, final int y, final String imagePath) {
        super(EApertureType.IMAGE, sides, x, y);
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }
}
