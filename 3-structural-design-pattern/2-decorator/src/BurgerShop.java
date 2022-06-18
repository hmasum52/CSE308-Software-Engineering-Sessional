import appetizer.FrenchFry;
import appetizer.OnionRings;
import burger.BeefBurger;
import burger.VeggiBurger;
import drinks.Coffee;
import drinks.Coke;
import drinks.Water;
import meal.Meal;

public class BurgerShop {
    public static void main(String[] args) {
        // 1. Beef burger with French fry and cheese
        System.out.println("Placing meal order: Beef burger with French fry and cheese");
        Meal beefBurger = new BeefBurger();
        beefBurger = new FrenchFry(beefBurger);
        System.out.println("Total price: " + beefBurger.getPrice()+" takta\n");

        // 2. Veggi burger with onion rings and Bottle of Water
        System.out.println("Placing meal order: Veggi burger with onion rings and Bottle of Water");
        Meal veggiBurger = new VeggiBurger();
        veggiBurger = new OnionRings(veggiBurger);
        veggiBurger = new Water(veggiBurger);
        System.out.println("Total price: " + veggiBurger.getPrice() + " takta\n");

        // 3. A combo meal with Veggi burger, French Fry and Coke
        System.out.println("Placing meal order: A combo meal with Veggi burger, French Fry and Coke");
        Meal veggiBurger2 = new VeggiBurger();
        veggiBurger2 = new FrenchFry(veggiBurger2);
        veggiBurger2 = new Coke(veggiBurger2);
        System.out.println("Total price: " + veggiBurger2.getPrice() + " takta\n");

        // 4. A combo meal with Veggi burger, Onion Rings, Coffee and Water
        System.out.println("Placing meal order: A combo meal with Veggi burger, French Fry and Coke");
        Meal veggiBurger3 = new VeggiBurger();
        veggiBurger3 = new OnionRings(veggiBurger3);
        veggiBurger3 = new Coffee(veggiBurger3);
        veggiBurger3 = new Water(veggiBurger3);
        System.out.println("Total price: " + veggiBurger3.getPrice() + " takta\n");

        // 5. A Beef burger only
        System.out.println("Placing meal order: A Beef burger only");
        Meal beefBurger2 = new BeefBurger();
        System.out.println("Total price: " + beefBurger2.getPrice() + " takta\n");
    }
}
