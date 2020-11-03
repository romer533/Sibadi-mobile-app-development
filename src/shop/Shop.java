package shop;

import java.util.Arrays;

public enum Shop {

    BOOK ("Книга", 100),
    FOOD ("Еда", 54),
    WATER ("Вода", 29),
    TEA ("Чай", 43);

    private final String productName;
    private final int price;

    Shop(String productName, int price) {
        this.productName = productName;
        this.price = price;
    }

    static String getProducts() {
        return Arrays.toString(Shop.values());
    }

    int getPrice() {
        return price;
    }

    String getProductName() {
        return productName;
    }

    @Override
    public String toString() {
        return productName + " по цене " + price + ".\n";
    }

}
