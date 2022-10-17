package decorator;

import meal.Meal;

/**
 * A decorator class that adds cheese to a burger
 */
public class Cheese extends DecoratorBase {

    public Cheese(Meal meal) {
        super(meal);
        System.out.println("Adding Cheese to the meal of price 10 taka");
    }

    @Override
    public double getPrice() {
        return meal.getPrice() + 10; // cheese price 10 taka
    }
}
