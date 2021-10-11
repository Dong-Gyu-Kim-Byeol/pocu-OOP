package academy.pocu.comp2500.lab6;

public enum EMealType {
    THREE_COURSE_MEAL,
    NO_HEAVY_MEAL,
    DEATH_BY_DESSERTS;

    public EProductType getProductType() {
        final EProductType productType;

        switch (this) {
            case THREE_COURSE_MEAL:
                productType = EProductType.THREE_COURSE_MEAL;
                break;

            case NO_HEAVY_MEAL:
                productType = EProductType.NO_HEAVY_MEAL;
                break;

            case DEATH_BY_DESSERTS:
                productType = EProductType.DEATH_BY_DESSERTS;
                break;

            default:
                throw new IllegalArgumentException("unknown type");
        }

        return productType;
    }
}
