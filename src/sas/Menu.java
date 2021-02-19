package sas;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private Buyer buyer;
    private Buyer buyer2;
    private Provider provider;
    private Seller seller;
    private List<String> arrayList;

    public Menu(Buyer buyer, Buyer buyer2, Provider provider, Seller seller) {
        this.buyer = buyer;
        this.buyer2 = buyer2;
        this.provider = provider;
        this.seller = seller;
        arrayList = new ArrayList();
        arrayList.add("Дебет  || № счета 50 | Сумма " + seller.getMoney() + " | Ввод начальных остатков, баланс = " + seller.getMoney() + " у.е.");
    }

    public String getBuyerInformation() {
        return
                "У " + buyer.getName() + " " + buyer.getMoney() + " у.е. и " + buyer.getNumberOfPots() + " горшков \n" +
                "У " + buyer2.getName() + " " + buyer2.getMoney() + " у.е. и " + buyer2.getNumberOfPots() + " горшков";
    }

    public String getProviderInformation() {
        return
                "У поставщика есть " + provider.getNumberOfPots() + " горшков по " + provider.getPotPrice() + " у.е.";
    }

    public String getSellerInformation() {
        return
                "У продовца есть " + seller.getMoney() + " у.е. и " + seller.getNumberOfPots() +
                        " горшков по " + seller.getPotPrice() + " у.е.";
    }

    public String buyPotForSeller() {
        if (getPotPriceProvider() > getMoneySeller()) return "У продовца мало денег(" + seller.getMoney() + " у.е.)";
        seller.setMoney(-100);
        arrayList.add("Дебет  || № счета 60 | Сумма " + provider.getPotPrice() + " | Мы оплатили горшки, остаток = " + seller.getMoney() + " у.е.");
        arrayList.add("Кредит || № счета 50 | Сумма " + provider.getPotPrice() + " | Нам привезли горшки");
        return Main.space() + "Мы купили горшок у поставщика" + Main.space();
    }

    public String buyPotForBuyer() {
        if (getPotPriceSeller() > getMoneyBuyer()) return "У покупателя мало денег(" + buyer.getMoney() + " у.е.)";
        buyer.setMoney(-200);
        arrayList.add("Дебет  || № счета 90 | Сумма " + provider.getPotPrice() + " | Мы списали горшки, остаток = " + seller.getMoney() + " у.е.");
        arrayList.add("Кредит || № счета 50 | Сумма " + provider.getPotPrice() + " | Нам привезли горшки");
        return Main.space() + "Мы купили горшок у поставщика" + Main.space();
    }

    public String buyPotForBuyer2() {
        return "bS";
    }

    private int getPotPriceSeller() {
        return seller.getPotPrice();
    }

    private int getPotPriceProvider() {
        return provider.getPotPrice();
    }

    private int getMoneySeller() {
        return seller.getMoney();
    }

    private int getMoneyBuyer() {
        return buyer.getMoney();
    }

    public String getArray() {
        String temp = "Выполненные операции:\n";
        for (int i = 0; i < arrayList.size(); i++) {
            temp += arrayList.get(i) + "\n";
        }
        return temp;
    }
}
