package academy.pocu.comp2500.assignment4;

public class DecreasePixelCommand extends CommandBase {
    private char backup;

    private final int x;
    private final int y;

    // ---

    public DecreasePixelCommand(final int x, final int y) {
        super();

        this.x = x;
        this.y = y;
    }

    // ---

    @Override
    protected final void doOperation(final Canvas canvas) {
        if (this.backup == 0) {
            this.backup = canvas.getPixel(this.x, this.y);
        }

        assert (this.backup == canvas.getPixel(this.x, this.y));
        canvas.decreasePixel(this.x, this.y);
    }

    @Override
    protected final void undoOperation(final Canvas canvas) {
        canvas.drawPixel(this.x, this.y, this.backup);
    }
}
