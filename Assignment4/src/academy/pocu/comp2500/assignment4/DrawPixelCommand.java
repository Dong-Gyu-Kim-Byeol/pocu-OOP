package academy.pocu.comp2500.assignment4;


public final class DrawPixelCommand extends CommandBase {
    private char backup;

    private final char character;
    private final int x;
    private final int y;

    // ---

    public DrawPixelCommand(final int x, final int y, final char character) {
        super();

        this.x = x;
        this.y = y;
        this.character = character;
    }

    // ---

    @Override
    protected final void doOperation(final Canvas canvas) {
        if (this.backup == 0) {
            this.backup = canvas.getPixel(this.x, this.y);
        }

        assert (this.backup == canvas.getPixel(this.x, this.y));
        canvas.drawPixel(this.x, this.y, this.character);
    }

    @Override
    protected final void undoOperation(final Canvas canvas) {
        canvas.drawPixel(this.x, this.y, this.backup);
    }
}
