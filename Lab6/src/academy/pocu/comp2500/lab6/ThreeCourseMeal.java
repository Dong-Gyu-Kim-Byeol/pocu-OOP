package academy.pocu.comp2500.lab6;

public class ThreeCourseMeal extends Meal {
    protected static final int PRICE = 25;

    public ThreeCourseMeal() {
        super(PRICE);
    }

    public boolean isValid() {
        return super.isValid(1, 1, 1);
    }


    public void setMainCourse(MainCourse mainCourse) {
        this.mainCourses.clear();

        this.mainCourses.add(mainCourse);
    }

    public void setAppetizer(Appetizer appetizer) {
        this.appetizers.clear();

        this.appetizers.add(appetizer);
    }

    public void setDessert(Dessert dessert) {
        this.desserts.clear();

        this.desserts.add(dessert);
    }
}
