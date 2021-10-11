package academy.pocu.comp2500.lab6;

public class HousePizza extends Pizza {
    protected static final int PRICE = 20;

    protected static final int MAX_MEAT_COUNT = 2;
    protected static final int MAX_VEGGIE_COUNT = 0;
    protected static final int MAX_CHEESE_COUNT = 0;

    public HousePizza() {
        super(EPizzaType.HOUSE_PIZZA, Topping.BLACK_OLIVES, Topping.RED_ONIONS, Topping.GREEN_PEPPERS, Topping.MOZZARELLA_CHEESE);
    }

    public boolean addBacon() {
        if (isValid()) {
            return false;
        }

        return super.addTopping(Topping.BACON);
    }

    public boolean removeBacon() {
        return super.removeTopping(Topping.BACON);
    }

    public boolean addPeperoni() {
        if (isValid()) {
            return false;
        }

        return super.addTopping(Topping.PEPERONI);
    }

    public boolean removePeperoni() {
        return super.removeTopping(Topping.PEPERONI);
    }

    public boolean addSausages() {
        if (isValid()) {
            return false;
        }

        return super.addTopping(Topping.SAUSAGES);
    }

    public boolean removeSausages() {
        return super.removeTopping(Topping.SAUSAGES);
    }
}
