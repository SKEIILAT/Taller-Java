package Interfaces;

import java.util.Map;

public interface IOrder {
    public void addNewMeal(String meal, int quantity);

    public Map<String, Integer> getOrder();

    public int getTotalCost();
}