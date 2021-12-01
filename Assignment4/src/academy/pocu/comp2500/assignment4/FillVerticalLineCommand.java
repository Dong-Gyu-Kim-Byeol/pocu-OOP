package academy.pocu.comp2500.assignment4;

public class FillVerticalLineCommand extends CommandBase {
    private char[] backup;

    private final char character;
    private final int x;

    // ---

    public FillVerticalLineCommand(final int x, final char character) {
        super();

        this.x = x;
        this.character = character;
    }

    // ---

    @Override
    protected final void doOperation(final Canvas canvas) {
        if (this.backup == null) {
            this.backup = new char[canvas.getHeight()];
            for (int y = 0; y < canvas.getHeight(); ++y) {
                this.backup[y] = canvas.getPixel(this.x, y);
            }
        }

        for (int y = 0; y < canvas.getHeight(); ++y) {
            assert (this.backup[y] == canvas.getPixel(this.x, y));
        }
        canvas.fillVerticalLine(this.x, this.character);
    }

    @Override
    protected final void undoOperation(final Canvas canvas) {
        for (int y = 0; y < canvas.getHeight(); ++y) {
            canvas.drawPixel(this.x, y, this.backup[y]);
        }
    }
}
