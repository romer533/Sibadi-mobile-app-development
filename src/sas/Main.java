package sas;

import java.util.Scanner;

public class Main {

    static Scanner scanner;
    static Menu menu;

    public static void main(String[] args) {

        scanner = new Scanner(System.in);

        Buyer buyer = new Buyer("Roman", 1000);
        Buyer buyer2 = new Buyer("Garry", 1000);
        Provider provider = new Provider(100, 10);
        Seller seller = new Seller(200, 0, 500);
        menu = new Menu(buyer, buyer2, provider, seller);

        System.out.println("Доро пожаловать в \"Простую систему бухучета\". \n" +
                "В системе есть 2 покупателя: " + buyer.getName() + " и " + buyer2.getName() + ".\n" +
                "А также поставщик и продавец. \n" +
                "У " + buyer.getName() + " " + buyer.getMoney() + " условных единиц. \n" +
                "У " + buyer2.getName() + " " + buyer2.getMoney() + " условных единиц. \n" +
                "У поставщика есть " + provider.getNumberOfPots() + " горшков по " + provider.getPotPrice() + " у.е.\n" +
                "У продовца есть " + seller.getNumberOfPots() + " горшков по " + seller.getPotPrice() + " у.е.\n" +
                space() + "Выберите действие, которое хотите совершить: ");

        menu();

    }

    private static void selectMenu(int num) {
        switch (num) {
            case 1:
                System.out.println(menu.getBuyerInformation());
                break;
            case 2:
                System.out.println(menu.getProviderInformation());
                break;
            case 3:
                System.out.println(menu.getSellerInformation());
                break;
            case 4:
                System.out.println(menu.buyPotForSeller());
                break;
            case 5:
                System.out.println(menu.buyPotForBuyer());
                break;
            case 6:
                System.out.println(menu.buyPotForBuyer2());
                break;
            case 7:
                System.out.println(menu.getArray());
                break;
            default:
                System.out.println("Введите число из списка меню");
        }
        menu();
    }

    private static void menu() {
        System.out.println("- 1: Вывести информацию о покупателях.");
        System.out.println("- 2: Вывести информацию о поставщике.");
        System.out.println("- 3: Вывести информацию о продавце.");
        System.out.println("- 4: Купить горшок продавцу у поставщика.");
        System.out.println("- 5: Купить горшок первому покупателю.");
        System.out.println("- 6: Купить горшок второму покупателю.");
        System.out.println("- 7: Вывести список операций.");
        selectMenu(scanner.nextInt());
    }

    public static String space() {
        return "\n------------------------------------------------\n";
    }

}
