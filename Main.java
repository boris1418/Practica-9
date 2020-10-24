package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ClientData data = new ClientData();
        data.loadData("C:\\Users\\boris\\Desktop\\exceptions");
        Scanner sc = new Scanner(System.in);
        label:
        while (true) {
            String text = sc.nextLine();
            switch (text) {
                case "exit":
                    System.out.println("Goodbye");
                    break label;
                case "inn&fio":
                    System.out.println("Write INN and FIO");
                    text = sc.nextLine();
                    try {
                        String[] nameInn = text.split(" +", 2);
                        data.checkClient(nameInn[1], nameInn[0]);
                        System.out.println("OK");
                    } catch (BadINNException | BadFIOException err) {
                        err.printStackTrace();
                    }
                    break;
                case "inn":
                    System.out.println("Write INN");
                    text = sc.nextLine();
                    try {
                        data.checkINN(text);
                        System.out.println("OK");
                    } catch (BadINNException err) {
                        err.printStackTrace();
                    }
                    break;
                case "fio":
                    System.out.println("Write FIO");
                    text = sc.nextLine();
                    try {
                        data.checkFIO(text);
                        System.out.println("OK");
                    } catch (BadFIOException err) {
                        err.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("Bad command. CommandList: fio, inn, inn&fio, exit");
                    break;
            }
        }
    }
}
