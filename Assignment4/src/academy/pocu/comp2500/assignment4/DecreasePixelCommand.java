package academy.pocu.comp2500.assignment4;

public class DecreasePixelCommand extends CommandBase {
    private char backup;
    private char lastWorkedBackup;

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
    protected final boolean doOperation(final Canvas canvas) {
        if (!xIsValid(this.x)) {
            return false;
        }
        if (!yIsValid(this.y)) {
            return false;
        }

        if (this.backup == 0) {
            this.backup = canvas.getPixel(this.x, this.y);
        }

        assert (this.backup == canvas.getPixel(this.x, this.y));
        return canvas.decreasePixel(this.x, this.y);
    }

    @Override
    protected final void undoOperation(final Canvas canvas) {
        canvas.drawPixel(this.x, this.y, this.backup);
    }

    @Override
    protected final boolean checkCanUpdate(final Canvas canvas) {
        if (this.backup == 0) {
            return false;
        }

        return this.lastWorkedBackup == canvas.getPixel(this.x, this.y);
    }

    @Override
    protected final void setLastWorkedBackup(final Canvas canvas) {
        this.lastWorkedBackup = canvas.getPixel(x, y);
    }
}
