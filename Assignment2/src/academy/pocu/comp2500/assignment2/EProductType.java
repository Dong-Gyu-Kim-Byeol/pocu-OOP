package academy.pocu.comp2500.assignment2;

public enum EProductType {
    STAMP,

    WALL_CALENDAR,
    DESK_CALENDAR,
    MAGNET_CALENDAR,

    GLOSS_BANNER,
    SCRIM_BANNER,
    MESH_BANNER,

    LINEN_BUSINESS_CARD,
    LAID_BUSINESS_CARD,
    SMOOTH_BUSINESS_CARD;

    private static final String STAMP_STRING = "Stamp";

    private static final String WALL_CALENDAR_STRING = "Wall Calendar";
    private static final String DESK_CALENDAR_STRING = "Desk Calendar";
    private static final String MAGNET_CALENDAR_STRING = "Magnet Calendar";

    private static final String GLOSS_BANNER_STRING = "Gloss Banner";
    private static final String SCRIM_BANNER_STRING = "Scrim Banner";
    private static final String MESH_BANNER_STRING = "Mesh Banner";

    private static final String LINEN_BUSINESS_CARD_STRING = "Linen Business Card";
    private static final String LAID_BUSINESS_CARD_STRING = "Laid Business Card";
    private static final String SMOOTH_BUSINESS_CARD_STRING = "Smooth Business Card";

    public String getName() {
        final String name;
        switch (this) {
            case STAMP:
                name = STAMP_STRING;
                break;

            case WALL_CALENDAR:
                name = WALL_CALENDAR_STRING;
                break;
            case DESK_CALENDAR:
                name = DESK_CALENDAR_STRING;
                break;
            case MAGNET_CALENDAR:
                name = MAGNET_CALENDAR_STRING;
                break;

            case GLOSS_BANNER:
                name = GLOSS_BANNER_STRING;
                break;
            case SCRIM_BANNER:
                name = SCRIM_BANNER_STRING;
                break;
            case MESH_BANNER:
                name = MESH_BANNER_STRING;
                break;

            case LINEN_BUSINESS_CARD:
                name = LINEN_BUSINESS_CARD_STRING;
                break;
            case LAID_BUSINESS_CARD:
                name = LAID_BUSINESS_CARD_STRING;
                break;
            case SMOOTH_BUSINESS_CARD:
                name = SMOOTH_BUSINESS_CARD_STRING;
                break;

            default:
                throw new IllegalArgumentException("unknown type");
        }

        return name;
    }
}
