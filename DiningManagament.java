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

        while (true) {
            menu.showMenu();
            System.out.print("Enter meal name to order or 'done' to finish: ");
            String meal = scanner.nextLine();
            
            if (meal.equals("done")) break;
            
            if (!menu.isValidFood(meal)) {
                System.out.println("meal not available. Please re-select.");
                continue;
            }

            System.out.print("Enter quantity for " + meal + ": ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (quantity <= 0) {
                System.out.println("Invalid quantity. Please re-enter.");
                continue;
            }

            order.addNewMeal(meal, quantity);
        }

        double totalC_ = calculator.calc(order, menu);
        int totalCost = order.getTotalCost();

        
        if (totalCost > 100) {
            System.out.println("Order quantity exceeds maximum limit. Please re-enter.");
            return;
        }

        System.out.println("Your Ord:");
        for (Map.Entry<String, Integer> item : order.getOrder().entrySet()) {
            System.out.println(item.getKey() + ": " + item.getValue());
        }

        System.out.println("Total Cost: $" + totalC_);
        System.out.print("Confirm order (yes/no): ");
        String confirm = scanner.nextLine();

        if (!confirm.toLowerCase().equals("yes")) {
            System.out.println("Order canceled.");
            System.out.println(-1);
            return;
        }

        System.out.println("Order confirmed. Total cost is: $" + totalC_);
    }
}
