package academy.pocu.comp2500.lab6;

public class MeatLoverPizza extends Pizza {
    protected static final int PRICE = 21;

    protected static final int MAX_VEGGIE_COUNT = 1;

    public MeatLoverPizza() {
        super(EPizzaType.MEAT_LOVER_PIZZA, PRICE);

        super.initAdd(Topping.BACON);
        super.initAdd(Topping.PEPERONI);
        super.initAdd(Topping.HAM);
        super.initAdd(Topping.SAUSAGES);
        super.initAdd(Topping.CHEDDAR_CHEESE);
    }

    public boolean addBlackOlives() {
        if (isValid()) {
            return false;
        }

        return super.add(Topping.BLACK_OLIVES, 0, MAX_VEGGIE_COUNT, 0);
    }

    public boolean removeBlackOlives() {
        return super.remove(Topping.BLACK_OLIVES);
    }

    public boolean addRedOnions() {
        if (isValid()) {
            return false;
        }

        return super.add(Topping.RED_ONIONS, 0, MAX_VEGGIE_COUNT, 0);
    }

    public boolean removeRedOnions() {
        return super.remove(Topping.RED_ONIONS);
    }

    public boolean addGreenPeppers() {
        if (isValid()) {
            return false;
        }

        return super.add(Topping.GREEN_PEPPERS, 0, MAX_VEGGIE_COUNT, 0);
    }

    public boolean removeGreenPeppers() {
        return super.remove(Topping.GREEN_PEPPERS);
    }
}
