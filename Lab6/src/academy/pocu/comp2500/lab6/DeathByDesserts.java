package academy.pocu.comp2500.lab6;

public class DeathByDesserts extends Meal {
    protected static final int PRICE = 20;

    public DeathByDesserts() {
        super(EMealType.DEATH_BY_DESSERTS);
    }

    public void setDesserts(final Dessert dessert1, final Dessert dessert2, final Dessert dessert3, final Dessert dessert4) {
        super.setDesserts(dessert1, dessert2, dessert3, dessert4);
    }
}
