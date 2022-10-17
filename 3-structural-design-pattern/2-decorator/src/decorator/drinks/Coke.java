package decorator.drinks;

import decorator.DecoratorBase;
import meal.Meal;

/**
 * a decorator class that adds coke to a meal
 */
public class Coke extends DecoratorBase {
    public Coke(Meal meal) {
        super(meal);
        System.out.println("Adding Coke to the meal of price 30 taka");
    }

    @Override
    public double getPrice() {
        return meal.getPrice() + 30; // 30 is the price of the coke
    }   
}
