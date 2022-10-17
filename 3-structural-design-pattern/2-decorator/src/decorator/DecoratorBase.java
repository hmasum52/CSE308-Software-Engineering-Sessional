package decorator;

import meal.Meal;

public abstract class DecoratorBase implements Meal{
    protected Meal meal;

    public DecoratorBase(Meal meal){
        this.meal = meal;
    }

    @Override
    public double getPrice() {
        return meal.getPrice();
    }
}
