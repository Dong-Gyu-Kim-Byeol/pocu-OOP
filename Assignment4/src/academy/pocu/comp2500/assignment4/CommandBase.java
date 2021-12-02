package academy.pocu.comp2500.assignment4;

public abstract class CommandBase implements ICommand {
    private boolean canUndoTry;
    private Canvas canvas;
    private char[][] lastWorkedBackup;

    protected CommandBase() {
    }

    // ---

    @Override
    public final boolean execute(final Canvas canvas) {
        if (this.canvas != null) {
            return false;
        }

        this.canvas = canvas;
        this.lastWorkedBackup = new char[canvas.getHeight()][canvas.getWidth()];

        canUndoTry = doOperation(this.canvas);

        setLastWorkedBackup();
        return canUndoTry;
    }

    @Override
    public final boolean undo() {
        if (this.canvas == null) {
            return false;
        }

        if (!canUndoTry) {
            return false;
        }

        if (checkCanUpdate()) {
            undoOperation(this.canvas);
            canUndoTry = false;

            setLastWorkedBackup();
            return true;
        }

        return false;
    }

    @Override
    public final boolean redo() {
        if (this.canvas == null) {
            return false;
        }

        if (canUndoTry) {
            return false;
        }

        if (checkCanUpdate()) {
            canUndoTry = doOperation(this.canvas);

            setLastWorkedBackup();
            return canUndoTry;
        }

        return false;
    }

    // ---

    protected abstract boolean doOperation(final Canvas canvas);

    protected abstract void undoOperation(final Canvas canvas);

    // ---

    private boolean checkCanUpdate() {
        for (int y = 0; y < canvas.getHeight(); ++y) {
            for (int x = 0; x < canvas.getWidth(); ++x) {
                if (this.lastWorkedBackup[y][x] != canvas.getPixel(x, y)) {
                    return false;
                }
            }
        }

        return true;
    }

    private void setLastWorkedBackup() {
        for (int y = 0; y < canvas.getHeight(); ++y) {
            for (int x = 0; x < canvas.getWidth(); ++x) {
                this.lastWorkedBackup[y][x] = canvas.getPixel(x, y);
            }
        }
    }

}
