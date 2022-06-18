package appetizer;

import meal.Meal;

/**
 * a decorator class that adds french fires to a meal
 */
public class FrenchFry implements Meal {
    private Meal meal;

    public FrenchFry(Meal meal) {
        System.out.println("Adding French Fries to the meal of price 110 taka");
        this.meal = meal;
    }

    @Override
    public double getPrice() {
        return meal.getPrice() + 110;
    }
    
}
