package academy.pocu.comp2500.lab6;

public class HousePizza extends Pizza {
    protected static final int PRICE = 20;

    protected static final int MAX_MEAT_COUNT = 2;

    public HousePizza() {
        super(EPizzaType.HOUSE_PIZZA);

        super.initTopping(Topping.BLACK_OLIVES, Topping.RED_ONIONS, Topping.GREEN_PEPPERS, Topping.MOZZARELLA_CHEESE);
    }

    public boolean addBacon() {
        if (isValid()) {
            return false;
        }

        return super.add(Topping.BACON);
    }

    public boolean removeBacon() {
        return super.remove(Topping.BACON);
    }

    public boolean addPeperoni() {
        if (isValid()) {
            return false;
        }

        return super.add(Topping.PEPERONI);
    }

    public boolean removePeperoni() {
        return super.remove(Topping.PEPERONI);
    }

    public boolean addSausages() {
        if (isValid()) {
            return false;
        }

        return super.add(Topping.SAUSAGES);
    }

    public boolean removeSausages() {
        return super.remove(Topping.SAUSAGES);
    }
}
