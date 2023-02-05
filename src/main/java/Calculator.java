public class Calculator {
    double sum;
    String output = "Добавленные товары:";

    public void addProduct(String name, double price) {
        output += "\n" + name;
        sum += price;
    }
}
