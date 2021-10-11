package academy.pocu.comp2500.lab6;

public enum EPizzaType {
    HOUSE_PIZZA,
    MEAT_LOVER_PIZZA,
    VEGGIE_PIZZA,
    FREE_SOUL_PIZZA;

    public EProductType getProductType() {
        final EProductType productType;

        switch (this) {
            case HOUSE_PIZZA:
                productType = EProductType.HOUSE_PIZZA;
                break;

            case MEAT_LOVER_PIZZA:
                productType = EProductType.MEAT_LOVER_PIZZA;
                break;

            case VEGGIE_PIZZA:
                productType = EProductType.VEGGIE_PIZZA;
                break;

            case FREE_SOUL_PIZZA:
                productType = EProductType.FREE_SOUL_PIZZA;
                break;

            default:
                throw new IllegalArgumentException("unknown type");
        }

        return productType;
    }
}
