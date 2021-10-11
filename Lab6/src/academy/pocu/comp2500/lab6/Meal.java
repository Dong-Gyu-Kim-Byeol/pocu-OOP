package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Meal extends Product {
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

    // protected
    protected void setIsValid(final int maxAppetizerCount, final int maxMainCourseCount, final int maxDessertCount) {
        super.isValid = this.appetizers.size() == maxAppetizerCount
                && this.mainCourses.size() == maxMainCourseCount
                && this.desserts.size() == maxDessertCount;
    }

    protected Meal(final int price) {
        super(price);

        this.appetizers = new ArrayList<Appetizer>();
        this.mainCourses = new ArrayList<MainCourse>();
        this.desserts = new ArrayList<Dessert>();
    }
}
