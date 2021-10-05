package academy.pocu.comp2500.assignment2;

public enum ERgbIndex {
    RED(0),
    GREEN(1),
    BLUE(2);

    private final int index;

    private ERgbIndex(final int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
