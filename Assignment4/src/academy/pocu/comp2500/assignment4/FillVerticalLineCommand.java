package academy.pocu.comp2500.assignment4;

public class FillVerticalLineCommand extends CommandBase {
    private char[] backup;
    private char[] lastWorkedBackup;

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
    protected final boolean doOperation(final Canvas canvas) {
        if (this.x < 0 || canvas.getWidth() <= this.x) {
            return false;
        }

        if (this.backup == null) {
            this.backup = new char[canvas.getHeight()];
            this.lastWorkedBackup = new char[canvas.getHeight()];

            for (int y = 0; y < canvas.getHeight(); ++y) {
                this.backup[y] = canvas.getPixel(this.x, y);
            }
        }

        for (int y = 0; y < canvas.getHeight(); ++y) {
            assert (this.backup[y] == canvas.getPixel(this.x, y));
        }
        canvas.fillVerticalLine(this.x, this.character);
        return true;
    }

    @Override
    protected final void undoOperation(final Canvas canvas) {
        for (int y = 0; y < canvas.getHeight(); ++y) {
            canvas.drawPixel(this.x, y, this.backup[y]);
        }
    }

    @Override
    protected final boolean checkCanUpdate(final Canvas canvas) {
        for (int y = 0; y < canvas.getHeight(); ++y) {
            if (this.lastWorkedBackup[y] != canvas.getPixel(this.x, y)) {
                return false;
            }
        }

        return true;
    }

    @Override
    protected final void setLastWorkedBackup(final Canvas canvas) {
        for (int y = 0; y < canvas.getHeight(); ++y) {
            this.lastWorkedBackup[y] = canvas.getPixel(this.x, y);
        }
    }
}
