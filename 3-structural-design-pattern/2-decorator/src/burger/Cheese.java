package burger;

import meal.Meal;

/**
 * A decorator class that adds cheese to a burger
 */
public class Cheese implements Meal {
    private Meal meal;

    public Cheese(Meal meal) {
        System.out.println("Adding Cheese to the meal of price 10 taka");
        this.meal = meal;
    }

    @Override
    public double getPrice() {
        return meal.getPrice() + 10; // cheese price 10 taka
    }
}
