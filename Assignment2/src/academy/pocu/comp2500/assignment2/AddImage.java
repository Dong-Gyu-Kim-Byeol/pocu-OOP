package academy.pocu.comp2500.assignment2;

public class AddImage {
    private final Position position;
    private final String imagePath;

    // public
    public AddImage(final Position position, final String imagePath) {
        this.position = position;
        this.imagePath = imagePath;
    }

    public Position getPosision() {
        return position;
    }

    public String getImagePath() {
        return imagePath;
    }
}
