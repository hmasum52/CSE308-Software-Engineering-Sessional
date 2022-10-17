package decorator.drinks;

import decorator.DecoratorBase;
import meal.Meal;

/**
 * a decorator class that adds water to a meal
 */
public class Water extends DecoratorBase {
    public Water(Meal meal) {
        super(meal);
        System.out.println("Adding Water to the meal of price 15 taka");
    }

    @Override
    public double getPrice() {
        return meal.getPrice() + 15; // 15 is the price of water
    }   
}
