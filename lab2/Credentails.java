package ru.eltex.app.lab2;

import java.util.Scanner;
import java.util.UUID;


public class Credentails{

    UUID ID;
    private String firstname;
    private String lastname;
    private String middlename;
    private String email;


    public Credentails(){
        ID = UUID.randomUUID();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выполни регистрацию для начала покупок:\nФамилия: ");
        this.lastname = scanner.nextLine();
        System.out.println("Имя: ");
        this.firstname = scanner.nextLine();
        System.out.println("Отчество: ");
        this.middlename = scanner.nextLine();
        System.out.println("Email: ");
        this.email = scanner.nextLine();
    }

    public void show(){
        System.out.println("Покупатель");
        System.out.println("ID = " + ID);
        System.out.println("Lastname = " + lastname);
        System.out.println("Firstname = " + firstname);
        System.out.println("Middlename = " + middlename);
        System.out.println("Email = " + email);
    }
}
