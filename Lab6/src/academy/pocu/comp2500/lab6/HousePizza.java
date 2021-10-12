package academy.pocu.comp2500.lab6;

public class HousePizza extends Pizza {
    private static final int PRICE = 20;

    private static final int MAX_MEAT_COUNT = 2;
    private static final int MAX_VEGGIE_COUNT = 0;
    private static final int MAX_CHEESE_COUNT = 0;

    public HousePizza() {
        super(PRICE, Topping.BLACK_OLIVES, Topping.RED_ONIONS, Topping.GREEN_PEPPERS, Topping.MOZZARELLA_CHEESE);
    }

    public boolean addBacon() {
        return super.addToppingAndSetIsValid(Topping.BACON, MAX_MEAT_COUNT, MAX_VEGGIE_COUNT, MAX_CHEESE_COUNT);
    }

    public boolean removeBacon() {
        return super.removeToppingAndSetIsValid(Topping.BACON, MAX_MEAT_COUNT, MAX_VEGGIE_COUNT, MAX_CHEESE_COUNT);
    }

    public boolean addPeperoni() {
        return super.addToppingAndSetIsValid(Topping.PEPERONI, MAX_MEAT_COUNT, MAX_VEGGIE_COUNT, MAX_CHEESE_COUNT);
    }

    public boolean removePeperoni() {
        return super.removeToppingAndSetIsValid(Topping.PEPERONI, MAX_MEAT_COUNT, MAX_VEGGIE_COUNT, MAX_CHEESE_COUNT);
    }

    public boolean addSausages() {
        return super.addToppingAndSetIsValid(Topping.SAUSAGES, MAX_MEAT_COUNT, MAX_VEGGIE_COUNT, MAX_CHEESE_COUNT);
    }

    public boolean removeSausages() {
        return super.removeToppingAndSetIsValid(Topping.SAUSAGES, MAX_MEAT_COUNT, MAX_VEGGIE_COUNT, MAX_CHEESE_COUNT);
    }
}
