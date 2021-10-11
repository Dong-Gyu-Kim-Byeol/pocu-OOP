package academy.pocu.comp2500.lab6;

public class DeathByDesserts extends Meal {
    private static final int PRICE = 20;

    private boolean isValid;

    public DeathByDesserts() {
        super(PRICE);
    }

    public boolean isValid() {
        return this.isValid;
    }

    public void setDesserts(final Dessert dessert1, final Dessert dessert2, final Dessert dessert3, final Dessert dessert4) {
        this.desserts.clear();

        this.desserts.add(dessert1);
        this.desserts.add(dessert2);
        this.desserts.add(dessert3);
        this.desserts.add(dessert4);
        this.isValid = true;
    }
}
