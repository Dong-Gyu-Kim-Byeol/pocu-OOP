package academy.pocu.comp2500.lab6;

public class ThreeCourseMeal extends Meal {
    private static final int PRICE = 25;

    private static final int MAX_APPETIZER_COUNT = 1;
    private static final int MAX_MAIN_COURSE_COUNT = 1;
    private static final int MAX_DESSERT_COUNT = 1;

    public ThreeCourseMeal() {
        super(PRICE);
    }

    public void setAppetizer(final Appetizer appetizer) {
        super.setAppetizersAndSetIsValid(MAX_APPETIZER_COUNT, MAX_MAIN_COURSE_COUNT, MAX_DESSERT_COUNT, appetizer);
    }

    public void setMainCourse(final MainCourse mainCourse) {
        super.setMainCoursesAndSetIsValid(MAX_APPETIZER_COUNT, MAX_MAIN_COURSE_COUNT, MAX_DESSERT_COUNT, mainCourse);
    }

    public void setDessert(final Dessert dessert) {
        super.setDessertsAndSetIsValid(MAX_APPETIZER_COUNT, MAX_MAIN_COURSE_COUNT, MAX_DESSERT_COUNT, dessert);
    }
}
