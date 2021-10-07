package academy.pocu.comp2500.assignment2;

public class TextAperture extends Aperture {
    private final String text;

    public TextAperture(final EApertureSide sides, final int x, final int y, final String text) {
        super(EApertureType.TEXT, sides, x, y);
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
