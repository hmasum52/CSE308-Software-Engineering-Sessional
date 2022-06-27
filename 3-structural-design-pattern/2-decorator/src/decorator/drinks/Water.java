package decorator.drinks;

import meal.Meal;

/**
 * a decorator class that adds water to a meal
 */
public class Water implements Meal {
    private Meal meal;

    public Water(Meal meal) {
        System.out.println("Adding Water to the meal of price 15 taka");
        this.meal = meal;
    }

    @Override
    public double getPrice() {
        return meal.getPrice() + 15;
    }   
}
