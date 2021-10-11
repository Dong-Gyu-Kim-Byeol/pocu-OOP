package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class HousePizza extends Pizza {
    protected static final int PRICE = 20;

    protected static final int MAX_MEAT_COUNT = 2;

    public HousePizza() {
        super(EPizzaType.HOUSE_PIZZA);

        ArrayList<Topping> toppings = new ArrayList<Topping>();
        toppings.add(Topping.BLACK_OLIVES);
        toppings.add(Topping.RED_ONIONS);
        toppings.add(Topping.GREEN_PEPPERS);
        toppings.add(Topping.MOZZARELLA_CHEESE);
        super.initToppings(toppings);
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
