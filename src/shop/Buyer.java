package shop;

public interface Buyer {

    void buy(Product product);

    void enter();
    void enter(int money);

    void exit(int money);

}
