package academy.pocu.comp2500.lab6;

public class NoHeavyMeal extends Meal {
    private static final int PRICE = 15;

    private static final int MAX_APPETIZER_COUNT = 2;
    private static final int MAX_MAIN_COURSE_COUNT = 0;
    private static final int MAX_DESSERT_COUNT = 1;

    public NoHeavyMeal() {
        super(PRICE);
    }

    public void setAppetizers(final Appetizer appetizer1, final Appetizer appetizer2) {
        this.appetizers.clear();

        this.appetizers.add(appetizer1);
        this.appetizers.add(appetizer2);
        super.setIsValid(MAX_APPETIZER_COUNT, MAX_MAIN_COURSE_COUNT, MAX_DESSERT_COUNT);
    }

    public void setDessert(final Dessert dessert) {
        this.desserts.clear();

        this.desserts.add(dessert);
        super.setIsValid(MAX_APPETIZER_COUNT, MAX_MAIN_COURSE_COUNT, MAX_DESSERT_COUNT);
    }
}
