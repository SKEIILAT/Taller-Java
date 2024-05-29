package dinning;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    Map<String, Double> items;


    void fillmenu() {
        items = new HashMap<>();
        items.put("Burger", 10.0);
        items.put("Pizza", 15.0);
        items.put("Salad", 8.0);
        items.put("Pasta", 12.0);
    }

    void showMenu() {
        System.out.println("Menu:");
        
        for (Map.Entry<String, Double> item : items.entrySet()) {
            System.out.println(item.getKey() + ": $" + item.getValue());
        }
    }

    boolean isValidFood(String food) {
        return food.equals("Burger") || food.equals("Pizza") || food.equals("Salad") || food.equals("Pasta");
    }

    double getPrice(String food) {
        return items.get(food);
    }
    
}
