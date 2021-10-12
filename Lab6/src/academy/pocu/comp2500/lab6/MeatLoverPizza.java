package academy.pocu.comp2500.lab6;

public class MeatLoverPizza extends Pizza {
    private static final int PRICE = 21;

    private static final int MAX_MEAT_COUNT = 0;
    private static final int MAX_VEGGIE_COUNT = 1;
    private static final int MAX_CHEESE_COUNT = 0;

    public MeatLoverPizza() {
        super(PRICE, Topping.BACON, Topping.CHEDDAR_CHEESE, Topping.SAUSAGES, Topping.HAM, Topping.PEPERONI);
    }

    public boolean addBlackOlives() {
        return super.addToppingAndSetIsValid(Topping.BLACK_OLIVES, MAX_MEAT_COUNT, MAX_VEGGIE_COUNT, MAX_CHEESE_COUNT);
    }

    public boolean removeBlackOlives() {
        return super.removeToppingAndSetIsValid(Topping.BLACK_OLIVES, MAX_MEAT_COUNT, MAX_VEGGIE_COUNT, MAX_CHEESE_COUNT);
    }

    public boolean addRedOnions() {
        return super.addToppingAndSetIsValid(Topping.RED_ONIONS, MAX_MEAT_COUNT, MAX_VEGGIE_COUNT, MAX_CHEESE_COUNT);
    }

    public boolean removeRedOnions() {
        return super.removeToppingAndSetIsValid(Topping.RED_ONIONS, MAX_MEAT_COUNT, MAX_VEGGIE_COUNT, MAX_CHEESE_COUNT);
    }

    public boolean addGreenPeppers() {
        return super.addToppingAndSetIsValid(Topping.GREEN_PEPPERS, MAX_MEAT_COUNT, MAX_VEGGIE_COUNT, MAX_CHEESE_COUNT);
    }

    public boolean removeGreenPeppers() {
        return super.removeToppingAndSetIsValid(Topping.GREEN_PEPPERS, MAX_MEAT_COUNT, MAX_VEGGIE_COUNT, MAX_CHEESE_COUNT);
    }
}
