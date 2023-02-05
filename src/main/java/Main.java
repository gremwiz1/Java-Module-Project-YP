// dev branch for Y.Practicum

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число пользователей на которых нужно разделить счет");
        int quantityUsers = 0;
        while (quantityUsers < 2) {
            while (!scanner.hasNextInt()) {
                System.out.println("Некорректный ввод");
                scanner.nextLine();
            }
            quantityUsers = scanner.nextInt();
            if (quantityUsers < 2) {
                System.out.println("Кол-во пользователй должно быть больше одного");
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
            while (!scanner.hasNextDouble()) {
                System.out.println("Некорректный ввод");
                scanner.nextLine();
            }
            priceProduct = scanner.nextDouble();
            if (priceProduct < 0) {
                System.out.println("Цена должна быть положительной");
            }
        }
        return priceProduct;
    }

    public static class Product {
        String nameProduct;
        double priceProduct;

        Product(String name, double price) {
            nameProduct = name;
            priceProduct = price;
        }
    }

    public static class Calculator {
        double sum;
        String output = "Добавленные товары:";

        public void addProduct(String name, double price) {
            output += "\n" + name;
            sum += price;
        }
    }

    public static class Formatter {
        public String format(double price) {
            int count = (int) price;
            String currency;
            if (count >= 11 && count < 15) {
                currency = "рублей";
            } else {
                int lastCharacter = count % 10;
                switch (lastCharacter) {
                    case 1:
                        currency = "рубль";
                        break;
                    case 2:
                    case 3:
                    case 4:
                        currency = "рубля";
                        break;
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 0:
                    default:
                        currency = "рублей";
                        break;
                }
            }
            return String.format("%.2f " + currency, price);
        }
    }
}

