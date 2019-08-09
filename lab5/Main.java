package ru.eltex.app.lab5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("\nМеню:\n1.Телефон\n2.Смартфон\n3.Планшет\n");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        Controller.OrderFileTest(choice);
    }
}
