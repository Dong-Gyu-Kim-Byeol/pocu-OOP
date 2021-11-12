package academy.pocu.comp2500.assignment3;

public final class IntVector2D {
    private int x;
    private int y;

    // 시그내처 불변
    public IntVector2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 시그내처 불변
    public int getX() {
        return this.x;
    }

    // 시그내처 불변
    public void setX(int x) {
        this.x = x;
    }

    // 시그내처 불변
    public int getY() {
        return this.y;
    }

    // 시그내처 불변
    public void setY(int y) {
        this.y = y;
    }
}