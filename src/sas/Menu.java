package sas;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private final Buyer buyer;
    private final Buyer buyer2;
    private final Provider provider;
    private final Seller seller;
    private final List<String> arrayList;

    public Menu(Buyer buyer, Buyer buyer2, Provider provider, Seller seller) {
        this.buyer = buyer;
        this.buyer2 = buyer2;
        this.provider = provider;
        this.seller = seller;
        arrayList = new ArrayList<>();
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
        if (provider.getNumberOfPots() <= 0) return "У поставщика нет горшков";
        seller.setMoney(-provider.getPotPrice());
        seller.plusNumberOfPots();
        provider.minusNumberOfPots();
        arrayList.add("Дебет  || № счета 60 | Сумма " + provider.getPotPrice() + " | Мы оплатили горшки, остаток = " + seller.getMoney() + " у.е.");
        arrayList.add("Кредит || № счета 50 | Сумма " + provider.getPotPrice() + " | Нам привезли горшки");
        return Main.space() + "Мы купили горшок у поставщика" + Main.space();
    }

    public String buyPotForBuyer() {
        if (getPotPriceSeller() > getMoneyBuyer()) return "У покупателя мало денег(" + getMoneyBuyer() + " у.е.)";
        if (seller.getNumberOfPots() <= 0) return "У продовца нет горшков";
        buyer.setMoney(-seller.getPotPrice());
        seller.setMoney(seller.getPotPrice());
        seller.minusNumberOfPots();
        buyer.plusNumberOfPots();
        arrayList.add("Дебет  || № счета 90 | Сумма " + seller.getPotPrice() + " | Мы списали горшки, остаток = " + seller.getMoney() + " у.е.");
        arrayList.add("Кредит || № счета 50 | Сумма " + seller.getPotPrice() + " | Нам привезли горшки");
        return Main.space() + "Первый покупатель купил горшок" + Main.space();
    }

    public String buyPotForBuyer2() {
        if (getPotPriceSeller() > getMoneyBuyer2()) return "У покупателя мало денег(" + getMoneyBuyer2() + " у.е.)";
        if (seller.getNumberOfPots() <= 0) return "У продовца нет горшков";
        buyer2.setMoney(-seller.getPotPrice());
        seller.setMoney(seller.getPotPrice());
        seller.minusNumberOfPots();
        buyer2.plusNumberOfPots();
        arrayList.add("Дебет  || № счета 90 | Сумма " + seller.getPotPrice() + " | Мы списали горшки, остаток = " + seller.getMoney() + " у.е.");
        arrayList.add("Кредит || № счета 50 | Сумма " + seller.getPotPrice() + " | Нам привезли горшки");
        return Main.space() + "Второй покупатель купил горшок" + Main.space();
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

    private int getMoneyBuyer2() {
        return buyer2.getMoney();
    }

    public String getArray() {
        StringBuilder temp = new StringBuilder("Выполненные операции:\n");
        for (String s : arrayList) {
            temp.append(s).append("\n");
        }
        return temp.toString();
    }
}
