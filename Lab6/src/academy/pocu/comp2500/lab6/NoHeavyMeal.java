package academy.pocu.comp2500.lab6;

public class NoHeavyMeal extends Meal {
    protected static final int PRICE = 15;

    public NoHeavyMeal() {
        super(PRICE);
    }

    public boolean isValid() {
        return super.isValid(2, 0, 1);
    }


    public void setAppetizers(Appetizer appetizer1, Appetizer appetizer2) {
        this.appetizers.clear();

        this.appetizers.add(appetizer1);
        this.appetizers.add(appetizer2);
    }

    public void setDessert(Dessert dessert) {
        this.desserts.clear();

        this.desserts.add(dessert);
    }
}
