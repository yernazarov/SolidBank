package com.example.solidbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;
import java.util.Scanner;

public class SolidBankApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        AccountBasicCLI accountBasicCLI = context.getBean(AccountBasicCLI.class);
        printManual();
        Scanner scanner = new Scanner(System.in);
        String clientID = "1";
        while (true) {
            System.out.println("> ");
            String number = scanner.nextLine();
            switch (number) {
                case "1" -> accountBasicCLI.getAccounts(clientID);
                case "2" -> accountBasicCLI.createAccountRequest(clientID);
                case "3" -> System.out.println("Not implemented yet");
                case "4" -> System.out.println("Not implemented yet");
                case "5" -> System.out.println("Not implemented yet");
                case "6" -> printManual();
                case "7" -> exit();
            }
        }
    }

    private static void printManual() {
        try {
            File readFile = new File("src/main/resources/manual.txt");
            Scanner scanner = new Scanner(readFile);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void exit() {
        System.out.println("Application closed");
        System.exit(0);
    }

}
