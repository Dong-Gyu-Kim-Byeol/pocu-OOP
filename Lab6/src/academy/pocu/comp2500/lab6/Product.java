package academy.pocu.comp2500.lab6;

public class Product {
    // private
    private final EProductType productType;

    // public
    public int getPrice() {
        switch (productType) {
            case HOUSE_PIZZA:
                return HousePizza.PRICE;
            case MEAT_LOVER_PIZZA:
                return MeatLoverPizza.PRICE;
            case VEGGIE_PIZZA:
                return VeggiePizza.PRICE;
            case FREE_SOUL_PIZZA:
                return FreeSoulPizza.PRICE;

            case THREE_COURSE_MEAL:
                return ThreeCourseMeal.PRICE;
            case NO_HEAVY_MEAL:
                return NoHeavyMeal.PRICE;
            case DEATH_BY_DESSERTS:
                return DeathByDesserts.PRICE;

            default:
                throw new IllegalArgumentException("unknown type");
        }
    }

    // protected
    protected Product(final EProductType productType) {
        this.productType = productType;
    }
}
