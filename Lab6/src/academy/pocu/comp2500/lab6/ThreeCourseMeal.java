package academy.pocu.comp2500.lab6;

public class ThreeCourseMeal extends Meal {
    private static final int PRICE = 25;

    private static final int MAX_APPETIZER_COUNT = 1;
    private static final int MAX_MAIN_COURSE_COUNT = 1;
    private static final int MAX_DESSERT_COUNT = 1;

    public ThreeCourseMeal() {
        super(PRICE);
    }

    public void setMainCourse(final MainCourse mainCourse) {
        this.mainCourses.clear();

        this.mainCourses.add(mainCourse);
        super.setIsValid(MAX_APPETIZER_COUNT, MAX_MAIN_COURSE_COUNT, MAX_DESSERT_COUNT);
    }

    public void setAppetizer(final Appetizer appetizer) {
        this.appetizers.clear();

        this.appetizers.add(appetizer);
        super.setIsValid(MAX_APPETIZER_COUNT, MAX_MAIN_COURSE_COUNT, MAX_DESSERT_COUNT);
    }

    public void setDessert(final Dessert dessert) {
        this.desserts.clear();

        this.desserts.add(dessert);
        super.setIsValid(MAX_APPETIZER_COUNT, MAX_MAIN_COURSE_COUNT, MAX_DESSERT_COUNT);
    }
}
