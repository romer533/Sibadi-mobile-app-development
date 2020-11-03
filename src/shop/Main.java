package shop;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int num = writeNumOrders(in);

        ArrayList<Client> clients = new ArrayList<>();

        clients.add(new Client("Василий"));
        clients.add(new Client("Павел", 1000));
        clients.add(new Client("Роман"));
        clients.add(new Client("Юрий"));
        clients.add(new Client("Геннадий"));
        clients.add(new Client("Иван"));
        clients.add(new Client("Рустам", 500));
        clients.add(new Client("Руслан"));
        clients.add(new Client("Арсений"));
        clients.add(new Client("Антон"));

        System.out.println("В магазине имеется:");
        System.out.println(Shop.getProducts());

        for (int i = 0; i < num;  i ++) {
            int numOrders = (int) (Math.random() * 5);
            if (clients.get(i).getMoney() == 0)
                System.out.println(clients.get(i).entry((int) (Math.random() * 500)));
            else
                System.out.println(clients.get(i).entry());
            for (int j = 0; j < numOrders; j++) {
                int product = (int) (Math.random() * 4);
                switch (product) {
                    case 0:
                        clients.get(i).buy(Shop.BOOK);
                        break;
                    case 1:
                        clients.get(i).buy(Shop.FOOD);
                        break;
                    case 2:
                        clients.get(i).buy(Shop.WATER);
                        break;
                    case 3:
                        clients.get(i).buy(Shop.TEA);
                        break;
                }
            }
            System.out.println(clients.get(i).exit(clients.get(i).getMoney()));
        }
    }

    static int writeNumOrders(Scanner in) {
        System.out.print("Введите количество покупателей (от 1 до 10): ");
        int num = in.nextInt();
        if (num <= 10 && num > 0) {
            return num;
        }
        writeNumOrders(in);
        return 0;
    }

}
