package academy.pocu.comp2500.lab6;

public class MeatLoverPizza extends Pizza {
    protected static final int PRICE = 21;

    protected static final int MAX_MEAT_COUNT = 0;
    protected static final int MAX_VEGGIE_COUNT = 1;
    protected static final int MAX_CHEESE_COUNT = 0;

    public MeatLoverPizza() {
        super(EPizzaType.MEAT_LOVER_PIZZA, Topping.BACON, Topping.CHEDDAR_CHEESE, Topping.SAUSAGES, Topping.HAM, Topping.PEPERONI);
    }

    public boolean addBlackOlives() {
        if (isValid()) {
            return false;
        }

        return super.addTopping(Topping.BLACK_OLIVES);
    }

    public boolean removeBlackOlives() {
        return super.removeTopping(Topping.BLACK_OLIVES);
    }

    public boolean addRedOnions() {
        if (isValid()) {
            return false;
        }

        return super.addTopping(Topping.RED_ONIONS);
    }

    public boolean removeRedOnions() {
        return super.removeTopping(Topping.RED_ONIONS);
    }

    public boolean addGreenPeppers() {
        if (isValid()) {
            return false;
        }

        return super.addTopping(Topping.GREEN_PEPPERS);
    }

    public boolean removeGreenPeppers() {
        return super.removeTopping(Topping.GREEN_PEPPERS);
    }
}
