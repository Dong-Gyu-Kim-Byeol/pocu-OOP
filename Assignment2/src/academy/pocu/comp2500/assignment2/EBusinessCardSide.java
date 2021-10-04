package academy.pocu.comp2500.assignment2;

public enum EBusinessCardSide {
    SINGLE,
    DOUBLE;

    public boolean canBackSideAperture() {
        switch (this) {
            case SINGLE:
                return false;

            case DOUBLE:
                return true;

            default:
                throw new IllegalArgumentException("unknown typr");
        }
    }
}
