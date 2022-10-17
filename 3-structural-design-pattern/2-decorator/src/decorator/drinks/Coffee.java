package decorator.drinks;

import decorator.DecoratorBase;
import meal.Meal;

/**
 * a decorator class that adds coffee to a meal
 */
public class Coffee extends DecoratorBase {
    
    public Coffee(Meal meal) {
        super(meal);
        System.out.println("Adding Coffee to the meal of price 25 taka");
        this.meal = meal;
    }

    @Override
    public double getPrice() {
        return meal.getPrice() + 25;
    }
}
