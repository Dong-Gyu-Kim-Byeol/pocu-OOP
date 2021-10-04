package academy.pocu.comp2500.assignment2;

public enum EBusinessCardColor {
    GRAY,
    IVORY,
    WHITE;

    // public
    public short getR() {
        final short r;
        switch (this) {
            case GRAY:
                r = (short) 0xE6;
                break;
            case IVORY:
                r = (short) 0xff;
                break;
            case WHITE:
                r = (short) 0xff;
                break;
            default:
                throw new IllegalArgumentException("unknown type");
        }

        return r;
    }

    public short getG() {
        final short g;
        switch (this) {
            case GRAY:
                g = (short) 0xE6;
                break;
            case IVORY:
                g = (short) 0xff;
                break;
            case WHITE:
                g = (short) 0xff;
                break;
            default:
                throw new IllegalArgumentException("unknown type");
        }

        return g;
    }

    public short getB() {
        final short b;
        switch (this) {
            case GRAY:
                b = (short) 0xE6;
                break;
            case IVORY:
                b = (short) 0xf0;
                break;
            case WHITE:
                b = (short) 0xff;
                break;
            default:
                throw new IllegalArgumentException("unknown type");
        }

        return b;
    }
}
