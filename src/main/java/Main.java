// dev branch for Y.Practicum

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число пользователей на которых нужно разделить счет");
        int quantityUsers = 0;
        while (quantityUsers < 2) {
            if (!scanner.hasNextInt()) {
                System.out.println("Некорректный ввод");
                scanner.nextLine();
            } else {
                quantityUsers = scanner.nextInt();
                if (quantityUsers < 2) {
                    System.out.println("Кол-во пользователй должно быть больше одного");
                }
            }
        }
        Calculator calculator = new Calculator();
        while (true) {
            String nameProduct = inputNameProduct(scanner);
            if (nameProduct.equalsIgnoreCase("завершить")) {
                break;
            }
            double priceProduct = inputPrice(scanner);
            Product product = new Product(nameProduct, priceProduct);
            calculator.addProduct(product.nameProduct, product.priceProduct);
        }
        Formatter formatter = new Formatter();
        System.out.println(calculator.output + "\n" + "Каждый человек должен заплатить " +
                formatter.format(calculator.sum / quantityUsers));
        scanner.close();

    }

    public static String inputNameProduct(Scanner scanner) {
        System.out.println("Введите название товара, если не хотите больше добавлять товары - " +
                "введите слово Завершить");
        return scanner.next();
    }

    public static double inputPrice(Scanner scanner) {
        double priceProduct = -1;
        System.out.println("Введите стоимость товара в формате рубли,копейки");
        while (priceProduct < 0) {
            if (!scanner.hasNextDouble()) {
                System.out.println("Некорректный ввод");
                scanner.nextLine();
            } else {
                priceProduct = scanner.nextDouble();
                if (priceProduct < 0) {
                    System.out.println("Цена должна быть положительной");
                }
            }
        }
        return priceProduct;
    }
}

