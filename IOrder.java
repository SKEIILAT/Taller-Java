import java.util.List;
import java.util.Map;

interface IOrder {
    public void addNewMeal(String meal, int quantity);

    public Map<String, Integer> getOrder();

    public int getTotalCost();
}