package academy.pocu.comp2500.assignment4;

public interface ICommand {
    boolean execute(final Canvas canvas);
    boolean undo();
    boolean redo();
}
