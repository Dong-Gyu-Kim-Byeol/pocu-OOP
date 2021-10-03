package academy.pocu.comp2500.assignment2;

public class Text {
    private final Posision posision;
    private final String text;

    // public
    public Text(final Posision posision, final String text) {
        this.posision = posision;
        this.text = text;
    }

    public Posision getPosision() {
        return posision;
    }

    public String getText() {
        return text;
    }
}
