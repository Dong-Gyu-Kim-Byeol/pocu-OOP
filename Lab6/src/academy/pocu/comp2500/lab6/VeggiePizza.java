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

        this.toppings.add(Topping.MOZZARELLA_CHEESE);
        ++this.cheeseCount;
        return true;
    }

    public boolean removeMozzarellaCheese() {
        boolean isRemoved = this.toppings.remove(Topping.MOZZARELLA_CHEESE);

        if (isRemoved) {
            --this.cheeseCount;
        }

        return isRemoved;
    }

    public boolean addCheddarCheese() {
        if (isValid()) {
            return false;
        }

        this.toppings.add(Topping.CHEDDAR_CHEESE);
        ++this.cheeseCount;
        return true;
    }

    public boolean removeCheddarCheese() {
        boolean isRemoved = this.toppings.remove(Topping.CHEDDAR_CHEESE);

        if (isRemoved) {
            --this.cheeseCount;
        }

        return isRemoved;
    }

    public boolean addFetaCheese() {
        if (isValid()) {
            return false;
        }

        this.toppings.add(Topping.FETA_CHEESE);
        ++this.cheeseCount;
        return true;
    }

    public boolean removeFetaCheese() {
        boolean isRemoved = this.toppings.remove(Topping.FETA_CHEESE);

        if (isRemoved) {
            --this.cheeseCount;
        }

        return isRemoved;
    }
}
