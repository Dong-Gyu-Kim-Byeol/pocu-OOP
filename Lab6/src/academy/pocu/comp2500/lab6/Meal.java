package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Meal {
    private final EMealType mealType;

    private final ArrayList<Appetizer> appetizers;
    private final ArrayList<MainCourse> mainCourses;
    private final ArrayList<Dessert> desserts;

    // public
    public int getPrice() {
        switch (mealType) {
            case THREE_COURSE_MEAL:
                return ThreeCourseMeal.PRICE;

            case NO_HEAVY_MEAL:
                return NoHeavyMeal.PRICE;

            case DEATH_BY_DESSERTS:
                return DeathByDesserts.PRICE;

            default:
                throw new IllegalArgumentException("unknown type");
        }
    }

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
    protected Meal(final EMealType mealType) {
        this.mealType = mealType;
        this.appetizers = new ArrayList<Appetizer>();
        this.mainCourses = new ArrayList<MainCourse>();
        this.desserts = new ArrayList<Dessert>();
    }

    protected void setMainCourses(final MainCourse... mainCourses) {
        this.mainCourses.clear();
        for (final MainCourse mainCourse : mainCourses) {
            this.mainCourses.add(mainCourse);
        }
    }

    protected void setAppetizers(final Appetizer... appetizers) {
        this.appetizers.clear();
        for (final Appetizer appetizer : appetizers) {
            this.appetizers.add(appetizer);
        }
    }

    protected void setDesserts(final Dessert... desserts) {
        this.desserts.clear();
        for (final Dessert dessert : desserts) {
            this.desserts.add(dessert);
        }
    }
}
