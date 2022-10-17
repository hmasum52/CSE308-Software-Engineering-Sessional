package decorator.appetizer;

import decorator.DecoratorBase;
import meal.Meal;
/**
 * a decorator class that adds onion rings to a meal
 */
public class OnionRings extends DecoratorBase {
    public OnionRings(Meal meal) {
        super(meal);
        System.out.println("Adding Onion Rings to the meal of price 80 taka");
    }

    @Override
    public double getPrice() {
        return meal.getPrice() + 80; // 80 is Orinion Rings price
    }
}
