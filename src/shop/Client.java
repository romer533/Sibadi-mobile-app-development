package shop;

public class Client implements Buyer {

    private final String name;
    private int money;
    private int discount;

    private int numberOfOrders;

    public Client(String name) {
        this.name = name;
    }

    public Client(String name, int money) {
        this.name = name;
        this.money = money;
    }

    private int endedPrice(Product product) {
        return product.getPrice() - product.getPrice() * discount / 100;
    }

    @Override
    public void buy(Product product) {

        getDiscount();

        if (money < endedPrice(product)) {
            System.out.println("Не хватает денег для покупки " + product.getProductName() + ".\n" +
                    "Денег на счете: " + money + ", для покупки не хватает " + (endedPrice(product) - money));
        } else {

            System.out.println(name + " купил " + product.getProductName() + " по цене " + endedPrice(product));

            this.money -= endedPrice(product);
            this.numberOfOrders++;
        }
    }

    public int getMoney() {
        return money;
    }

    private void getDiscount() {
        switch (numberOfOrders) {
            case 0: discount = 0;
                break;
            case 2:
            case 1: discount = 10;
                break;
            case 4:
            case 3: discount = 20;
                break;
            default:
            case 5: discount = 30;
                break;
        }
    }

    @Override
    public void enter(int money) {
        this.money = money;
        System.out.println(name + " зашел в магазин, у него в кармане " + this.money);
    }

    @Override
    public void enter() {
        System.out.println(name + " зашел в магазин, у него в кармане " + this.money);
    }


    @Override
    public void exit(int money) {
        System.out.println(name + " ушел из магазина, у него осталось " + money);
    }
}
