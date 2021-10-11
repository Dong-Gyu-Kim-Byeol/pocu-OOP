package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class VeggiePizza extends Pizza {
    protected static final int PRICE = 17;

    protected static final int MAX_CHEESE_COUNT = 2;

    public VeggiePizza() {
        super(EPizzaType.VEGGIE_PIZZA);

        ArrayList<Topping> toppings = new ArrayList<Topping>();
        toppings.add(Topping.BLACK_OLIVES);
        toppings.add(Topping.RED_ONIONS);
        toppings.add(Topping.GREEN_PEPPERS);
        super.initToppings(toppings);
    }

    public boolean addMozzarellaCheese() {
        if (isValid()) {
            return false;
        }

        return super.add(Topping.MOZZARELLA_CHEESE);
    }

    public boolean removeMozzarellaCheese() {
        return super.remove(Topping.MOZZARELLA_CHEESE);
    }

    public boolean addCheddarCheese() {
        if (isValid()) {
            return false;
        }

        return super.add(Topping.CHEDDAR_CHEESE);
    }

    public boolean removeCheddarCheese() {
        return super.remove(Topping.CHEDDAR_CHEESE);
    }

    public boolean addFetaCheese() {
        if (isValid()) {
            return false;
        }

        return super.add(Topping.FETA_CHEESE);
    }

    public boolean removeFetaCheese() {
        return super.remove(Topping.FETA_CHEESE);
    }
}
