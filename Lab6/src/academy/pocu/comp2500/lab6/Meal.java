package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Meal extends Product {
    private final ArrayList<Appetizer> appetizers;
    private final ArrayList<MainCourse> mainCourses;
    private final ArrayList<Dessert> desserts;

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

    // protected
    protected Meal(final int price) {
        super(price);

        this.appetizers = new ArrayList<Appetizer>();
        this.mainCourses = new ArrayList<MainCourse>();
        this.desserts = new ArrayList<Dessert>();
    }

    protected void setAppetizersAndSetIsValid(final int maxAppetizerCount, final int maxMainCourseCount, final int maxDessertCount, final Appetizer... appetizers) {
        this.appetizers.clear();

        for (final Appetizer appetizer : appetizers) {
            this.appetizers.add(appetizer);
        }

        this.setIsValid(maxAppetizerCount, maxMainCourseCount, maxDessertCount);
    }

    protected void setMainCoursesAndSetIsValid(final int maxAppetizerCount, final int maxMainCourseCount, final int maxDessertCount, final MainCourse... mainCourses) {
        this.mainCourses.clear();

        for (final MainCourse mainCourse : mainCourses) {
            this.mainCourses.add(mainCourse);
        }

        this.setIsValid(maxAppetizerCount, maxMainCourseCount, maxDessertCount);
    }

    protected void setDessertsAndSetIsValid(final int maxAppetizerCount, final int maxMainCourseCount, final int maxDessertCount, final Dessert... desserts) {
        this.desserts.clear();

        for (final Dessert dessert : desserts) {
            this.desserts.add(dessert);
        }

        this.setIsValid(maxAppetizerCount, maxMainCourseCount, maxDessertCount);
    }

    // private
    private void setIsValid(final int maxAppetizerCount, final int maxMainCourseCount, final int maxDessertCount) {
        super.setIsValid(this.appetizers.size() == maxAppetizerCount
                && this.mainCourses.size() == maxMainCourseCount
                && this.desserts.size() == maxDessertCount);
    }
}
