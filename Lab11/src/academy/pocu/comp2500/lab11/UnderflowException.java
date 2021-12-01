package academy.pocu.comp2500.lab11;

public final class UnderflowException extends RuntimeException {
    private static final long serialVersionUID = 3422179582713735628L;

    // ---

    public UnderflowException(final String msg) {
        super(msg);
    }
}