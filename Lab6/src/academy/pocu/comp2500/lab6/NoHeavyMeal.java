package academy.pocu.comp2500.lab6;

public class NoHeavyMeal extends Meal {
    protected static final int PRICE = 15;

    public NoHeavyMeal() {
        super(EMealType.NO_HEAVY_MEAL);
    }

    public void setAppetizers(final Appetizer appetizer1, final Appetizer appetizer2) {
        super.setAppetizer(appetizer1, appetizer2);
    }

    public void setDessert(final Dessert dessert) {
        super.setDessert(dessert);
    }
}
