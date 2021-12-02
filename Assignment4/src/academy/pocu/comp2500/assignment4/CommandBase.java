package academy.pocu.comp2500.assignment4;

public abstract class CommandBase implements ICommand {
    private boolean canUndo;
    private Canvas canvas;

    protected CommandBase() {
    }

    // ---

    @Override
    public final boolean execute(final Canvas canvas) {
        if (this.canvas != null) {
            return false;
        }

        this.canvas = canvas;
        canUndo = doOperation(this.canvas);;
        return canUndo;
    }

    @Override
    public final boolean undo() {
        if (this.canvas == null) {
            return false;
        }

        if (!canUndo) {
            return false;
        }

        undoOperation(this.canvas);
        canUndo = false;
        return true;
    }

    @Override
    public final boolean redo() {
        if (this.canvas == null) {
            return false;
        }

        if (canUndo) {
            return false;
        }
;
        canUndo = doOperation(this.canvas);
        return canUndo;
    }

    // ---

    protected abstract boolean doOperation(final Canvas canvas);

    protected abstract void undoOperation(final Canvas canvas);

}
