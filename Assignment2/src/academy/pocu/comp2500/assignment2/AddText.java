package academy.pocu.comp2500.assignment2;

public class AddText {
    private final Position position;
    private final String text;

    // public
    public AddText(final Position position, final String text) {
        this.position = position;
        this.text = text;
    }

    public Position getPosision() {
        return position;
    }

    public String getText() {
        return text;
    }
}
