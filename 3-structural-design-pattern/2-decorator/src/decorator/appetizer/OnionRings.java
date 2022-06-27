package decorator.appetizer;

import meal.Meal;
/**
 * a decorator class that adds onion rings to a meal
 */
public class OnionRings implements Meal {
    private Meal meal;

    public OnionRings(Meal meal) {
        System.out.println("Adding Onion Rings to the meal of price 80 taka");
        this.meal = meal;
    }

    @Override
    public double getPrice() {
        return meal.getPrice() + 80;
    }
}
