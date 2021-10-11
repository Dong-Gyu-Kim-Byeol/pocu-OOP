package academy.pocu.comp2500.lab6;

public class HousePizza extends Pizza {
    protected static final int PRICE = 20;

    protected static final int MAX_MEAT_COUNT = 2;

    public HousePizza() {
        super(EPizzaType.HOUSE_PIZZA, PRICE);

        super.initAdd(Topping.BLACK_OLIVES);
        super.initAdd(Topping.RED_ONIONS);
        super.initAdd(Topping.GREEN_PEPPERS);
        super.initAdd(Topping.MOZZARELLA_CHEESE);
    }

    public boolean addBacon() {
        if (isValid()) {
            return false;
        }

        return super.add(Topping.BACON, MAX_MEAT_COUNT, 0, 0);
    }

    public boolean removeBacon() {
        return super.remove(Topping.BACON);
    }

    public boolean addPeperoni() {
        if (isValid()) {
            return false;
        }

        return super.add(Topping.PEPERONI, MAX_MEAT_COUNT, 0, 0);
    }

    public boolean removePeperoni() {
        return super.remove(Topping.PEPERONI);
    }

    public boolean addSausages() {
        if (isValid()) {
            return false;
        }

        return super.add(Topping.SAUSAGES, MAX_MEAT_COUNT, 0, 0);
    }

    public boolean removeSausages() {
        return super.remove(Topping.SAUSAGES);
    }
}
