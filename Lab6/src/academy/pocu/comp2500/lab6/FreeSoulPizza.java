package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class FreeSoulPizza extends Pizza {
    protected static final int PRICE = 25;

    protected static final int MAX_MEAT_COUNT = 2;
    protected static final int MAX_VEGGIE_COUNT = 2;
    protected static final int MAX_CHEESE_COUNT = 1;

    public FreeSoulPizza() {
        super(EPizzaType.FREE_SOUL_PIZZA);

        ArrayList<Topping> toppings = new ArrayList<Topping>();
        super.initToppings(toppings);
    }

    public boolean addTopping(Topping topping) {
        return super.add(topping);
    }

    public boolean removeTopping(final Topping topping) {
        return super.remove(topping);
    }
}
