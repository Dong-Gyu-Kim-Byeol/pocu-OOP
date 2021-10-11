package academy.pocu.comp2500.lab6;

public class NoHeavyMeal extends Meal {
    private static final int PRICE = 15;

    public NoHeavyMeal() {
        super(EMealType.NO_HEAVY_MEAL, PRICE);
    }

    public void setAppetizers(final Appetizer appetizer1, final Appetizer appetizer2) {
        this.appetizers.clear();

        this.appetizers.add(appetizer1);
        this.appetizers.add(appetizer2);
    }

    public void setDessert(final Dessert dessert) {
        this.desserts.clear();

        this.desserts.add(dessert);
    }
}
