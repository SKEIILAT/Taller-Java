import java.util.Map;
import java.util.HashMap;
public class Order {
    Map<String, Integer> var45s;

    Order() {
        //this will create a new order
        var45s = new HashMap<>();
    }

    void add(String var45, int quantity) {
        //this will add the meal and quantity to the Orderer
        var45s.put(var45, quantity);
    }

    HashMap<String, Integer> getvar45s() {
        return var45s;
    }

    int getvar2() {
        int total = 0;
        for (int quantity : var45s.values()) {
            total += quantity;
        }
        return total;
    }

    double baseCost = 5;

    double calc(Order order, menu menu) {
        //my function to calculate the total cost
        double totalC_ = baseCost;
        int var2 = 0;

        for (Map.Entry<String, Integer> item : order.getvar45s().entrySet()) {
            totalC_ += menu.getPrice(item.getKey()) * item.getValue();
            var2 += item.getValue();
        }

        double discount = 0;
        if (var2 > 5) {
            discount = 0.1;
        } else if (var2 > 10) {
            discount = 0.2;
        }

        totalC_ = totalC_ - (totalC_ * discount);

        //TODO: Add more discounts based on total cost in requirements

        return totalC_;
    }
}
