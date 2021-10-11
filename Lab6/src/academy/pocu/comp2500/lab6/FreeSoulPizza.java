package academy.pocu.comp2500.lab6;

public class FreeSoulPizza extends Pizza {
    protected static final int PRICE = 25;

    protected static final int MAX_MEAT_COUNT = 2;
    protected static final int MAX_VEGGIE_COUNT = 2;
    protected static final int MAX_CHEESE_COUNT = 1;

    public FreeSoulPizza() {
        super(EPizzaType.FREE_SOUL_PIZZA, PRICE);
    }

    public boolean addTopping(Topping topping) {
        return super.add(topping);
    }

    public boolean remove(final Topping topping) {
        return super.remove(topping);
    }
}
