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
        super.setAppetizersAndSetIsValid(MAX_APPETIZER_COUNT, MAX_MAIN_COURSE_COUNT, MAX_DESSERT_COUNT, appetizer1, appetizer2);
    }

    public void setDessert(final Dessert dessert) {
        super.setDessertsAndSetIsValid(MAX_APPETIZER_COUNT, MAX_MAIN_COURSE_COUNT, MAX_DESSERT_COUNT, dessert);
    }
}
