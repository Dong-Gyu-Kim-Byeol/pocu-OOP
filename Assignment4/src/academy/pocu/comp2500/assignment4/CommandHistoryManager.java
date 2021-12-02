package academy.pocu.comp2500.assignment4;

import java.util.LinkedList;

public final class CommandHistoryManager {
    private final Canvas canvas;
    private final LinkedList<ICommand> canUndoCommands;
    private final LinkedList<ICommand> canRedoCommands;

    public CommandHistoryManager(final Canvas canvas) {
        this.canvas = canvas;
        this.canUndoCommands = new LinkedList<>();
        this.canRedoCommands = new LinkedList<>();
    }

    // ---

    public final boolean execute(final ICommand command) {
        if (command.execute(this.canvas)) {
            this.canUndoCommands.addLast(command);
            this.canRedoCommands.clear();
            return true;
        }

        return false;
    }

    public final boolean canUndo() {
        return !this.canUndoCommands.isEmpty();
    }

    public final boolean undo() {
        if (!canUndo()) {
            return false;
        }

        final ICommand command = this.canUndoCommands.getLast();

        if (command.undo()) {
            this.canRedoCommands.addFirst(command);
            this.canUndoCommands.removeLast();
            return true;
        }

        return false;
    }

    public final boolean canRedo() {
        return !this.canRedoCommands.isEmpty();
    }

    public final boolean redo() {
        if (!canRedo()) {
            return false;
        }

        final ICommand command = this.canRedoCommands.getFirst();


        if (command.redo()) {
            this.canUndoCommands.addLast(command);
            this.canRedoCommands.removeFirst();
            return true;
        }

        return false;
    }

}
