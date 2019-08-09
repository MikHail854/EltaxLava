package ru.eltex.app.lab5;

import ru.eltex.app.lab1.Phone;
import ru.eltex.app.lab1.Products;
import ru.eltex.app.lab1.Smartphone;
import ru.eltex.app.lab1.TheTablet;
import ru.eltex.app.lab2.Credentails;
import ru.eltex.app.lab2.Order;
import ru.eltex.app.lab2.Orders;
import ru.eltex.app.lab2.ShoppingCart;

import java.util.Scanner;

public class Controller {
    public static void OrderFileTest(int choice) {
        Credentails user = new Credentails("Михаил", "Чигуров", "Евгеньевич", "vip.moneta95@mail.ru");
        Scanner scanner = new Scanner(System.in);
        ShoppingCart<Products> cart = new ShoppingCart<>();

        int numObj = 0;
        if (choice == 1){
            System.out.println("Сколько товаров требуется?");
            numObj = scanner.nextInt();
            Phone[] products = new Phone[numObj];
            for (int i = 0; i < numObj; i++){
                products[i] = new Phone();
                products[i].create();
                products[i].read();
                cart.add(products[i]);
            }
        }
        if (choice == 2){
            System.out.println("Сколько товаров требуется?");
            numObj = scanner.nextInt();
            Smartphone[] products = new Smartphone[numObj];
            for (int i = 0; i < numObj; i++){
                products[i] = new Smartphone();
                products[i].create();
                products[i].read();
                cart.add(products[i]);
            }
        }
        if (choice == 3){
            System.out.println("Сколько товаров требуется?");
            numObj = scanner.nextInt();
            TheTablet[] products = new TheTablet[numObj];
            for (int i = 0; i < numObj; i++){
                products[i] = new TheTablet();
                products[i].create();
                products[i].read();
                cart.add(products[i]);
            }
        }

        System.out.println("\nКол-во товара:" + Products.CounterObject);
        System.out.println("\n1.Оформить заказ\n2.Выход");
        int choice2 = scanner.nextInt();
        if (choice2 == 1){
            Orders<Order> orders = new Orders<>();
            orders.offer(cart, user);
            ManagerOrderFile manager = new ManagerOrderFile();
            manager.saveAll(orders);
            Orders example1 = manager.readAll();
            System.out.println("Orders из бинарного файла");
            example1.show();


            System.out.println("Пример работы saveByID и readById" + "\n" +  "==================================================");

            Credentails user2 = new Credentails("Анна", "Старкова", "Сергеевна","annastarko@yandex.ru");
            Order order2 = new Order(cart, user2);
            manager.saveById(order2);
            System.out.println("Заказ из бинарного файла");
            Order example2 = manager.readById(order2.getUUID());
            example2.show();

            System.out.println("Test Json1");
            ManagerOrderJSON json = new ManagerOrderJSON();
            Order order3 = new Order(cart, user2);
            json.saveById(order3);
            Order example3 = json.readById(orders.getUUID());
            System.out.println("Order из JSON --------------------");
            example3.show();

            System.out.println("Test Json2");
            json.saveAll(orders);
            Orders example = json.readAll();
            System.out.println("Order из JSON --------------------");
            example.show();
        }else {
            return;
        }
    }
}
