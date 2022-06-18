package drinks;

import meal.Meal;

/**
 * a decorator class that adds coffee to a meal
 */
public class Coffee implements Meal {
    Meal meal;

    public Coffee(Meal meal) {
        System.out.println("Adding Coffee to the meal of price 25 taka");
        this.meal = meal;
    }

    @Override
    public double getPrice() {
        return meal.getPrice() + 25;
    }
}
