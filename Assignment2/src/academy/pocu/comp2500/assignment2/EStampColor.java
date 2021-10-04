package academy.pocu.comp2500.assignment2;

public enum EStampColor {
    RED,
    GREEN,
    BLUE;

    // public
    public short getR() {
        final short r;
        switch (this) {
            case RED:
                r = (short) 0xff;
                break;
            case GREEN:
                r = (short) 0;
                break;
            case BLUE:
                r = (short) 0;
                break;
            default:
                throw new IllegalArgumentException("unknown type");
        }

        return r;
    }

    public short getG() {
        final short g;
        switch (this) {
            case RED:
                g = (short) 0;
                break;
            case GREEN:
                g = (short) 0x80;
                break;
            case BLUE:
                g = (short) 0;
                break;
            default:
                throw new IllegalArgumentException("unknown type");
        }

        return g;
    }

    public short getB() {
        final short b;
        switch (this) {
            case RED:
                b = (short) 0;
                break;
            case GREEN:
                b = (short) 0;
                break;
            case BLUE:
                b = (short) 0xff;
                break;
            default:
                throw new IllegalArgumentException("unknown type");
        }

        return b;
    }
}
