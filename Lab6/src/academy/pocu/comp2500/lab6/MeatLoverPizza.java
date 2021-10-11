package academy.pocu.comp2500.lab6;

public class MeatLoverPizza extends Pizza {
    protected static final int PRICE = 21;

    protected static final int MAX_MEAT_COUNT = 0;
    protected static final int MAX_VEGGIE_COUNT = 1;
    protected static final int MAX_CHEESE_COUNT = 0;

    public MeatLoverPizza() {
        super(PRICE, Topping.BACON, Topping.CHEDDAR_CHEESE, Topping.SAUSAGES, Topping.HAM, Topping.PEPERONI);
    }

    public boolean isValid() {
        return super.isValid(MAX_MEAT_COUNT, MAX_VEGGIE_COUNT, MAX_CHEESE_COUNT);
    }

    public boolean addBlackOlives() {
        if (isValid()) {
            return false;
        }

        this.toppings.add(Topping.BLACK_OLIVES);
        ++this.veggieCount;
        return true;
    }

    public boolean removeBlackOlives() {
        boolean isRemoved = this.toppings.remove(Topping.BLACK_OLIVES);

        if (isRemoved) {
            --this.veggieCount;
        }

        return isRemoved;
    }

    public boolean addRedOnions() {
        if (isValid()) {
            return false;
        }

        this.toppings.add(Topping.RED_ONIONS);
        ++this.veggieCount;
        return true;
    }

    public boolean removeRedOnions() {
        boolean isRemoved = this.toppings.remove(Topping.RED_ONIONS);

        if (isRemoved) {
            --this.veggieCount;
        }

        return isRemoved;
    }

    public boolean addGreenPeppers() {
        if (isValid()) {
            return false;
        }

        this.toppings.add(Topping.GREEN_PEPPERS);
        ++this.veggieCount;
        return true;
    }

    public boolean removeGreenPeppers() {
        boolean isRemoved = this.toppings.remove(Topping.GREEN_PEPPERS);

        if (isRemoved) {
            --this.veggieCount;
        }

        return isRemoved;
    }
}
