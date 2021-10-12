package academy.pocu.comp2500.lab6;

public class DeathByDesserts extends Meal {
    private static final int PRICE = 20;

    private static final int MAX_APPETIZER_COUNT = 0;
    private static final int MAX_MAIN_COURSE_COUNT = 0;
    private static final int MAX_DESSERT_COUNT = 4;

    public DeathByDesserts() {
        super(PRICE);
    }

    public void setDesserts(final Dessert dessert1, final Dessert dessert2, final Dessert dessert3, final Dessert dessert4) {
        super.setDessertsAndSetIsValid(MAX_APPETIZER_COUNT, MAX_MAIN_COURSE_COUNT, MAX_DESSERT_COUNT, dessert1, dessert2, dessert3, dessert4);
    }
}
