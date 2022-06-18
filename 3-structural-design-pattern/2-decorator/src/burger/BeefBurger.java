package burger;

import meal.Meal;

/**
 * concrete component
 */
public class BeefBurger implements Meal {
    
    public BeefBurger(){
        System.out.println("Adding Beef Burger to the meal of price 220 taka");
    }


    @Override
    public double getPrice() {
        return 220;
    }    
}
