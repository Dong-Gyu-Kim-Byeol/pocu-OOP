package academy.pocu.comp2500.assignment2;

public class Aperture {
    private final EApertureSide apertureSide;
    private final int x;
    private final int y;

    // public
    public EApertureSide getApertureSide() {
        return apertureSide;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // protected
    protected Aperture(final EApertureSide sides, final int x, final int y) {
        this.apertureSide = sides;
        this.x = x;
        this.y = y;
    }
}
