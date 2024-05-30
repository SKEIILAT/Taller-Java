package dinning;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class Order implements Interfaces.IOrder {
    Map<String, Integer> orders;

    public Order() {
        this.orders = new HashMap<>();
    }

    public void addNewMeal(String meal, int quantity) {
        orders.put(meal, quantity);
        System.out.println("Meal added");
    }

    public Map<String, Integer> getOrder() {
        return orders;
    }

    public int getTotalQuantity() {
        int total = 0;
        for (int quantity : orders.values()) {
            total += quantity;
        }
        return total;
    }

    public static void manageOrder(Menu menu, Order order, Scanner scanner){
        String endOrder = "";
        while (!endOrder.equals("done")) {
            menu.showMenu();
            System.out.print("Enter meal name to order or 'done' to finish: ");
            String meal = scanner.nextLine();
            if(meal.equals("done") ){
                endOrder = "done";
            }
            
            if (!menu.isValidFood(meal)) {
                System.out.println("Error: meal not available. Please re-select.");
                continue;
            }

            int quantity = 0;
            try {
                System.out.print("Enter quantity for " + meal + ": ");
                quantity = scanner.nextInt();
                scanner.nextLine(); 
                
                if (quantity <= 0) {
                    throw new IllegalArgumentException(); 
                }
            } catch (Exception e) {
                System.out.println("Invalid quantity. Please re-enter.");
                scanner.nextLine(); 
                continue;
            }

            order.addNewMeal(meal, quantity);
        }

           
    }
} 

