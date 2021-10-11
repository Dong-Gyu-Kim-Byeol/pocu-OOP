package academy.pocu.comp2500.lab6;

public class VeggiePizza extends Pizza {
    protected static final int PRICE = 17;

    protected static final int MAX_MEAT_COUNT = 0;
    protected static final int MAX_VEGGIE_COUNT = 0;
    protected static final int MAX_CHEESE_COUNT = 2;

    public VeggiePizza() {
        super(EPizzaType.VEGGIE_PIZZA, Topping.BLACK_OLIVES, Topping.RED_ONIONS, Topping.GREEN_PEPPERS);
    }

    public boolean addMozzarellaCheese() {
        if (isValid()) {
            return false;
        }

        return super.addTopping(Topping.MOZZARELLA_CHEESE);
    }

    public boolean removeMozzarellaCheese() {
        return super.removeTopping(Topping.MOZZARELLA_CHEESE);
    }

    public boolean addCheddarCheese() {
        if (isValid()) {
            return false;
        }

        return super.addTopping(Topping.CHEDDAR_CHEESE);
    }

    public boolean removeCheddarCheese() {
        return super.removeTopping(Topping.CHEDDAR_CHEESE);
    }

    public boolean addFetaCheese() {
        if (isValid()) {
            return false;
        }

        return super.addTopping(Topping.FETA_CHEESE);
    }

    public boolean removeFetaCheese() {
        return super.removeTopping(Topping.FETA_CHEESE);
    }
}
