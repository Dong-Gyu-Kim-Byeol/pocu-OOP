package academy.pocu.comp2500.assignment4;

public class ToUpperCommand extends CommandBase {
    private char backup;
    private char lastWorkedBackup;

    private final int x;
    private final int y;

    // ---

    public ToUpperCommand(final int x, final int y) {
        super();

        this.x = x;
        this.y = y;
    }

    // ---

    @Override
    protected final boolean doOperation(final Canvas canvas) {
        if (this.x < 0 || canvas.getWidth() <= this.x) {
            return false;
        }
        if (this.y < 0 || canvas.getHeight() <= this.y) {
            return false;
        }

        if (this.backup == 0) {
            this.backup = canvas.getPixel(this.x, this.y);
        }

        assert (this.backup == canvas.getPixel(this.x, this.y));
        canvas.toUpper(this.x, this.y);
        return true;
    }

    @Override
    protected final void undoOperation(final Canvas canvas) {
        canvas.drawPixel(this.x, this.y, this.backup);
    }

    @Override
    protected final boolean checkCanUpdate(final Canvas canvas) {
        return this.lastWorkedBackup == canvas.getPixel(this.x, this.y);
    }

    @Override
    protected final void setLastWorkedBackup(final Canvas canvas) {
        this.lastWorkedBackup = canvas.getPixel(this.x, this.y);
    }
}
