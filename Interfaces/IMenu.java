package Interfaces;
public interface IMenu {

    void fillMenu();

    void showMenu();

    boolean isValidFood(String food);

    double getPrice(String food);
}
