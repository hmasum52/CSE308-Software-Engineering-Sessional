package decorator.appetizer;

import decorator.DecoratorBase;
import meal.Meal;

/**
 * a decorator class that adds french fires to a meal
 */
public class FrenchFry extends DecoratorBase {
    public FrenchFry(Meal meal) {
        super(meal);
        System.out.println("Adding French Fries to the meal of price 110 taka");
    }

    @Override
    public double getPrice() {
        return meal.getPrice() + 110; // 110 is the frechfry price
    }
}
