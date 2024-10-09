package dinning;

import java.util.Map.Entry;

public class Cost {
    double baseCost = 5;

    public double calc(Order order, Menu menu) {
        double totalCost = baseCost;
        int mealsCount = 0;

        for (Entry<String, Integer> item : order.getOrder().entrySet()) {
            totalCost += menu.getPrice(item.getKey()) * item.getValue();
            mealsCount += item.getValue();
        }

        double discount = mealsDiscount(mealsCount);

        totalCost = totalCost - (totalCost * discount);

        if (totalCost > 50) {
            totalCost = totalCost - 10;
        } else if (totalCost > 100) {
            totalCost = totalCost - 25;
        }
        return totalCost;
    }

    public double mealsDiscount(int mealsCount){
        if (mealsCount > 5) {
            return  0.1;
        } else if (mealsCount > 10) {
           return  0.2;
        }
        return 0;
    }
}