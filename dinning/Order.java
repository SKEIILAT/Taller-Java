package dinning;

import java.util.Map;

import java.util.HashMap;

public class Order implements Interfaces.IOrder {
    Map<String, Integer> orders;

    public Order() {
        this.orders = new HashMap<>();
    }

    public void addNewMeal(String meal, int quantity) {
        orders.put(meal, quantity);
        System.out.println("Meal added");
        return;
    }

    public Map<String, Integer> getOrder() {
        return orders;
    }

    public int getTotalCost() {
        int total = 0;
        for (int quantity : orders.values()) {
            total += quantity;
        }
        return total;
    }
}
