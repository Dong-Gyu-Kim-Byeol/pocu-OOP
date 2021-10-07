package academy.pocu.comp2500.assignment2;

public class Aperture {
    private final EApertureType apertureType;
    private final EApertureSide apertureSide;
    private final int x;
    private final int y;

    // public method
    public EApertureType getApertureType() {
        return apertureType;
    }

    public EApertureSide getApertureSide() {
        return apertureSide;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // protected method
    protected Aperture(final EApertureType apertureType, final EApertureSide sides, final int x, final int y) {
        this.apertureType = apertureType;
        this.apertureSide = sides;
        this.x = x;
        this.y = y;
    }
}
