package academy.pocu.comp2500.lab6;

public class ThreeCourseMeal extends Meal {
    private static final int PRICE = 25;

    public ThreeCourseMeal() {
        super(PRICE);
    }

    public boolean isValid() {
        return this.appetizers.size() == 1 && this.mainCourses.size() == 1 && this.desserts.size() == 1;
    }

    public void setMainCourse(final MainCourse mainCourse) {
        this.mainCourses.clear();
        this.mainCourses.add(mainCourse);
    }

    public void setAppetizer(final Appetizer appetizer) {
        this.appetizers.clear();
        this.appetizers.add(appetizer);
    }

    public void setDessert(final Dessert dessert) {
        this.desserts.clear();
        this.desserts.add(dessert);
    }
}
