package academy.pocu.comp2500.lab6;

public class VeggiePizza extends Pizza {
    private static final int PRICE = 17;

    private static final int MAX_MEAT_COUNT = 0;
    private static final int MAX_VEGGIE_COUNT = 0;
    private static final int MAX_CHEESE_COUNT = 2;

    public VeggiePizza() {
        super(PRICE, Topping.BLACK_OLIVES, Topping.RED_ONIONS, Topping.GREEN_PEPPERS);
    }

    public boolean addMozzarellaCheese() {
        return super.addToppingAndSetIsValid(Topping.MOZZARELLA_CHEESE, MAX_MEAT_COUNT, MAX_VEGGIE_COUNT, MAX_CHEESE_COUNT);
    }

    public boolean removeMozzarellaCheese() {
        return super.removeToppingAndSetIsValid(Topping.MOZZARELLA_CHEESE, MAX_MEAT_COUNT, MAX_VEGGIE_COUNT, MAX_CHEESE_COUNT);
    }

    public boolean addCheddarCheese() {
        return super.addToppingAndSetIsValid(Topping.CHEDDAR_CHEESE, MAX_MEAT_COUNT, MAX_VEGGIE_COUNT, MAX_CHEESE_COUNT);
    }

    public boolean removeCheddarCheese() {
        return super.removeToppingAndSetIsValid(Topping.CHEDDAR_CHEESE, MAX_MEAT_COUNT, MAX_VEGGIE_COUNT, MAX_CHEESE_COUNT);
    }

    public boolean addFetaCheese() {
        return super.addToppingAndSetIsValid(Topping.FETA_CHEESE, MAX_MEAT_COUNT, MAX_VEGGIE_COUNT, MAX_CHEESE_COUNT);
    }

    public boolean removeFetaCheese() {
        return super.removeToppingAndSetIsValid(Topping.FETA_CHEESE, MAX_MEAT_COUNT, MAX_VEGGIE_COUNT, MAX_CHEESE_COUNT);
    }
}
