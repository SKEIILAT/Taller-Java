import java.util.Map;
import java.util.Scanner;
import dinning.Menu;
import dinning.Order;
import dinning.Cost;

public class DiningManagament {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Order order = new Order();
        Cost calculator = new Cost();
        Scanner scanner = new Scanner(System.in);
      
        Order.manageOrder(menu, order, scanner);
        
        double totalCost = calculator.calc(order, menu);
        int totalQuantity = order.getTotalQuantity();
    
        if (totalQuantity > 100) {
            System.out.println("Order quantity exceeds maximum limit. Please re-enter.");
            scanner.close();
            return;
        }

        System.out.println("Your Order:");
        for (Map.Entry<String, Integer> item : order.getOrder().entrySet()) {
            System.out.println(item.getKey() + ": " + item.getValue());
        }

        System.out.println("Total Cost: $" + totalCost);
        System.out.print("Confirm order (yes/no): ");
        String confirm = scanner.nextLine();

        if (!confirm.equalsIgnoreCase("yes")) {
            System.out.println("Invalid input: Order canceled.");
            scanner.close();
            return;
        }

        System.out.println("Order confirmed. Total cost is: $" + totalCost);
        scanner.close();
    }
}
