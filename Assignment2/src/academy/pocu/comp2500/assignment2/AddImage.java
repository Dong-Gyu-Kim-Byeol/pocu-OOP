package academy.pocu.comp2500.assignment2;

public class AddImage {
    private final Posision posision;
    private final String imagePath;

    // public
    public AddImage(final Posision posision, final String imagePath) {
        this.posision = posision;
        this.imagePath = imagePath;
    }

    public Posision getPosision() {
        return posision;
    }

    public String getImagePath() {
        return imagePath;
    }
}
