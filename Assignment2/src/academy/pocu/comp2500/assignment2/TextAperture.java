package academy.pocu.comp2500.assignment2;

public class TextAperture extends Aperture {
    private final String text;

    public TextAperture(final String apertureId, final int x, final int y, final EApertureSide sides, final String text) {
        super(apertureId, x, y, sides);
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
