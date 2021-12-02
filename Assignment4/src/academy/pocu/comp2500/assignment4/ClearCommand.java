package academy.pocu.comp2500.assignment4;

public final class ClearCommand extends CommandBase {
    private char[][] backup;

    // ---

    public ClearCommand() {
        super();
    }

    // ---

    @Override
    protected final boolean doOperation(final Canvas canvas) {
        if (backup == null) {
            this.backup = new char[canvas.getHeight()][canvas.getWidth()];

            for (int y = 0; y < canvas.getHeight(); ++y) {
                for (int x = 0; x < canvas.getWidth(); ++x) {
                    this.backup[y][x] = canvas.getPixel(x, y);
                }
            }
        }

        for (int y = 0; y < canvas.getHeight(); ++y) {
            for (int x = 0; x < canvas.getWidth(); ++x) {
                assert (this.backup[y][x] == canvas.getPixel(x, y));
            }
        }

        canvas.clear();
        return true;
    }

    @Override
    protected final void undoOperation(final Canvas canvas) {
        for (int y = 0; y < canvas.getHeight(); ++y) {
            for (int x = 0; x < canvas.getWidth(); ++x) {
                canvas.drawPixel(x, y, this.backup[y][x]);
            }
        }
    }
}
