package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Meal extends Product {
    private final EMealType mealType;

    // protected
    protected final ArrayList<Appetizer> appetizers;
    protected final ArrayList<MainCourse> mainCourses;
    protected final ArrayList<Dessert> desserts;

    // public
    public ArrayList<Appetizer> getAppetizers() {
        return appetizers;
    }

    public ArrayList<MainCourse> getMainCourses() {
        return mainCourses;
    }

    public ArrayList<Dessert> getDesserts() {
        return desserts;
    }

    public boolean isValid() {
        switch (mealType) {
            case THREE_COURSE_MEAL:
                return this.appetizers.size() == 1
                        && this.mainCourses.size() == 1
                        && this.desserts.size() == 1;

            case NO_HEAVY_MEAL:
                return this.appetizers.size() == 2
                        && this.desserts.size() == 1;

            case DEATH_BY_DESSERTS:
                return this.desserts.size() == 4;

            default:
                throw new IllegalArgumentException("unknown type");
        }
    }

    // protected
    protected Meal(final EMealType mealType, final int price) {
        super(mealType.getProductType(), price);

        this.mealType = mealType;
        this.appetizers = new ArrayList<Appetizer>();
        this.mainCourses = new ArrayList<MainCourse>();
        this.desserts = new ArrayList<Dessert>();
    }
}
