package decorator.drinks;

import meal.Meal;

/**
 * a decorator class that adds coke to a meal
 */
public class Coke implements Meal {
    private Meal meal;

    public Coke(Meal meal) {
        System.out.println("Adding Coke to the meal of price 30 taka");
        this.meal = meal;
    }


    @Override
    public double getPrice() {
        return meal.getPrice() + 30;
    }   
}
