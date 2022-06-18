package burger;

import meal.Meal;

/**
 * concrete component
 */
public class VeggiBurger implements Meal{

    public VeggiBurger(){
        System.out.println("Adding Veggi Burger to the meal of price 200 taka");
    }

    @Override
    public double getPrice() {
        return 200;
    }
    
}
