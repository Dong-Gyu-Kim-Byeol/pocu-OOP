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
        this.desserts.clear();

        this.desserts.add(dessert1);
        this.desserts.add(dessert2);
        this.desserts.add(dessert3);
        this.desserts.add(dessert4);
        super.setIsValid(MAX_APPETIZER_COUNT, MAX_MAIN_COURSE_COUNT, MAX_DESSERT_COUNT);
    }
}
