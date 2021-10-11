package academy.pocu.comp2500.lab6;

public class ThreeCourseMeal extends Meal {
    protected static final int PRICE = 25;

    public ThreeCourseMeal() {
        super(EMealType.THREE_COURSE_MEAL);
    }

    public void setMainCourse(final MainCourse mainCourse) {
        super.setMainCourse(mainCourse);
    }

    public void setAppetizer(final Appetizer appetizer) {
        super.setAppetizer(appetizer);
    }

    public void setDessert(final Dessert dessert) {
        super.setDessert(dessert);
    }
}
