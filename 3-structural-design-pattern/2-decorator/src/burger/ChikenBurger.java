package burger;

import meal.Meal;

public class ChikenBurger implements Meal {

    public ChikenBurger() {
        System.out.println("Adding Chiken Burger to the meal of price 100 taka");
    }

    @Override
    public double getPrice() {
        return 100;
    }
}
