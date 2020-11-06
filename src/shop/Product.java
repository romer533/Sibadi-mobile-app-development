package shop;

import java.util.Arrays;

public enum Product {

    BOOK ("Книга", 100),
    FOOD ("Еда", 54),
    WATER ("Вода", 29),
    TEA ("Чай", 43);

    private final String productName;
    private final int price;

    Product(String productName, int price) {
        this.productName = productName;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public String toString() {
        return productName + " по цене " + price + ".\n";
    }

}
