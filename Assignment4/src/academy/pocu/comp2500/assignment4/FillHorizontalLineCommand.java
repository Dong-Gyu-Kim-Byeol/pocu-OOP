package academy.pocu.comp2500.assignment4;

public class FillHorizontalLineCommand extends CommandBase {
    private char[] backup;
    private char[] lastWorkedBackup;

    private final char character;
    private final int y;

    // ---

    public FillHorizontalLineCommand(final int y, final char character) {
        super();

        this.y = y;
        this.character = character;
    }

    // ---

    @Override
    protected final boolean doOperation(final Canvas canvas) {
        if (this.y < 0 || canvas.getHeight() <= this.y) {
            return false;
        }

        if (this.backup == null) {
            this.backup = new char[canvas.getWidth()];
            this.lastWorkedBackup = new char[canvas.getWidth()];

            for (int x = 0; x < canvas.getWidth(); ++x) {
                this.backup[x] = canvas.getPixel(x, this.y);
            }
        }

        for (int x = 0; x < canvas.getWidth(); ++x) {
            assert (this.backup[x] == canvas.getPixel(x, this.y));
        }
        canvas.fillHorizontalLine(this.y, this.character);
        return true;
    }

    @Override
    protected final void undoOperation(final Canvas canvas) {
        for (int x = 0; x < canvas.getWidth(); ++x) {
            canvas.drawPixel(x, this.y, this.backup[x]);
        }
    }

    @Override
    protected final boolean checkCanUpdate(final Canvas canvas) {
        for (int x = 0; x < canvas.getWidth(); ++x) {
            if (this.lastWorkedBackup[x] != canvas.getPixel(x, this.y)) {
                return false;
            }
        }

        return true;
    }

    @Override
    protected final void setLastWorkedBackup(final Canvas canvas) {
        for (int x = 0; x < canvas.getWidth(); ++x) {
            this.lastWorkedBackup[x] = canvas.getPixel(x, this.y);
        }
    }
}
