package academy.pocu.comp2500.assignment2;

public class Aperture {
    private final String apertureId;
    private final EApertureSide side;
    private final int x;
    private final int y;

    // public
    public String getApertureId() {
        return apertureId;
    }

    public EApertureSide getSide() {
        return side;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // protected
    protected Aperture(final String apertureId, final int x, final int y, final EApertureSide sides) {
        this.apertureId = apertureId;
        this.x = x;
        this.y = y;
        this.side = sides;
    }
}
