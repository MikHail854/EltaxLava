package ru.eltex.app.lab1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        /**
         *  программа работает от аргумента, в зависимости от вида представления(чай или кофе)
         */

        Scanner scanner = new Scanner(System.in);

        if (args[0].equalsIgnoreCase("телефон")){
            System.out.println("Введите желаемое кол-во товара: " + args[0].toLowerCase());
            int Object1 = scanner.nextInt();
            Phone[] phone = new Phone[Object1];
            for (int i = 0; i < Object1; i++) {
                phone[i] = new Phone();
                phone[i].create();
                phone[i].read();
            }

            System.out.println("\nКол-во товара: " + Products.CounterObject);
            /**
             * Пример работы функции update
             */
            System.out.println("Ручной ввод");
            phone[0].delete();
            phone[0].update();
            phone[0].read();
        } else if (args[0].equalsIgnoreCase("смартфон")){
            System.out.println("Введите желаемое кол-во товара: " + args[0].toLowerCase());
            int Object2 = scanner.nextInt();
            Smartphone[] smartphone = new Smartphone[Object2];
            for (int i = 0; i < Object2; i++) {
                smartphone[i] = new Smartphone();
                smartphone[i].create();
                smartphone[i].read();
            }
            System.out.println("\nКол-во объектов: " + Products.CounterObject);
            /**
             * Пример работы функции update
             */
            System.out.println("Ручной ввод");
            smartphone[0].delete();
            smartphone[0].create();
            smartphone[0].read();
        }else if (args[0].equalsIgnoreCase("планшет")) {
            System.out.println("Введите желаемое кол-во товара: " + args[0].toLowerCase());
            int Object3 = scanner.nextInt();
            TheTablet[] TheTablet = new TheTablet[Object3];
            for (int i = 0; i < Object3; i++) {
                TheTablet[i] = new TheTablet();
                TheTablet[i].create();
                TheTablet[i].read();
            }

            System.out.println("\nКол-во объектов: " + Products.CounterObject);
            /**
             * Пример работы функции update
             */
            System.out.println("Ручной ввод");
            TheTablet[0].delete();
            TheTablet[0].create();
            TheTablet[0].read();
        } else {
            System.out.println("Invalid input");
            return;
        }
        scanner.close();
    }
}
