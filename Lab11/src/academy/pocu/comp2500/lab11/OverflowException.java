package academy.pocu.comp2500.lab11;

public class OverflowException extends RuntimeException {
    private static final long serialVersionUID = 3422179582713735628L;

    // ---

    public OverflowException(final String msg) {
        super(msg);
    }
}
