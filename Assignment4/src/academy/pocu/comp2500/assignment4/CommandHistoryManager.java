package academy.pocu.comp2500.assignment4;

import java.util.LinkedList;

public final class CommandHistoryManager {
    private final Canvas canvas;
    private final LinkedList<ICommand> commands;
    private final LinkedList<ICommand> canUndoCommands;
    private final LinkedList<ICommand> canRedoCommands;

    public CommandHistoryManager(final Canvas canvas) {
        this.canvas = canvas;
        this.commands = new LinkedList<>();
        this.canUndoCommands = new LinkedList<>();
        this.canRedoCommands = new LinkedList<>();
    }

    // ---

    public final boolean execute(final ICommand command) {
        this.canUndoCommands.addLast(command);
        this.canRedoCommands.clear();

        return command.execute(this.canvas);
    }

    public final boolean canUndo() {
        return !this.canUndoCommands.isEmpty();
    }

    public final boolean undo() {
        if (!canUndo()) {
            return false;
        }

        final ICommand command = this.canUndoCommands.getLast();
        this.canUndoCommands.removeLast();

        final boolean out = command.undo();
        this.canRedoCommands.addFirst(command);

        return out;
    }

    public final boolean canRedo() {
        return !this.canRedoCommands.isEmpty();
    }

    public final boolean redo() {
        if (!canRedo()) {
            return false;
        }

        final ICommand command = this.canRedoCommands.getFirst();
        this.canRedoCommands.removeFirst();

        final boolean out = command.redo();
        this.canUndoCommands.addLast(command);

        return out;
    }

}
