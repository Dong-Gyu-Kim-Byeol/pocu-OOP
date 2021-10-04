package academy.pocu.comp2500.assignment2;

public enum EProductType {
    STAMP,

    WALL_CALENDAR,
    DESK_CALENDAR,
    MAGNET_CALENDAR,

    GLOSS_BANNER,
    SCRIM_BANNER,
    MESH_BANNER,

    LINEN_SINGLE_SIDE_BUSINESS_CARD,
    LAID_SINGLE_SIDE_BUSINESS_CARD,
    SMOOTH_SINGLE_SIDE_BUSINESS_CARD,

    LINEN_DOUBLE_SIDE_BUSINESS_CARD,
    LAID_DOUBLE_SIDE_BUSINESS_CARD,
    SMOOTH_DOUBLE_SIDE_BUSINESS_CARD;

    public boolean canBackSideAperture() {
        switch (this) {
            case LINEN_DOUBLE_SIDE_BUSINESS_CARD:
                // intentional fallthrough
            case LAID_DOUBLE_SIDE_BUSINESS_CARD:
                // intentional fallthrough
            case SMOOTH_DOUBLE_SIDE_BUSINESS_CARD:
                return true;
            default:
                return false;
        }
    }
}
