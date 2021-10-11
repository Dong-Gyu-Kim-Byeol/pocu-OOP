package academy.pocu.comp2500.lab6;

public class FreeSoulPizza extends Pizza {
    protected static final int PRICE = 25;

    protected static final int MAX_MEAT_COUNT = 2;
    protected static final int MAX_VEGGIE_COUNT = 2;
    protected static final int MAX_CHEESE_COUNT = 1;

    public FreeSoulPizza() {
        super(EPizzaType.FREE_SOUL_PIZZA);
    }

    public boolean addTopping(final Topping topping) {
        if ((isMeat(topping) && this.meatCount >= MAX_MEAT_COUNT)
                || (isVeggie(topping) && this.veggieCount >= MAX_VEGGIE_COUNT)
                || (isCheese(topping) && this.cheeseCount >= MAX_CHEESE_COUNT)) {
            return false;
        }

        this.toppings.add(topping);

        if (isMeat(topping)) {
            ++this.meatCount;
        }

        if (isVeggie(topping)) {
            ++this.veggieCount;
        }

        if (isCheese(topping)) {
            ++this.cheeseCount;
        }

        return true;
    }

    public boolean removeTopping(final Topping topping) {
        boolean isRemoved = this.toppings.remove(topping);

        if (isRemoved) {
            if (isMeat(topping)) {
                --this.meatCount;
            }

            if (isVeggie(topping)) {
                --this.veggieCount;
            }

            if (isCheese(topping)) {
                --this.cheeseCount;
            }
        }

        return isRemoved;
    }

}
