import java.util.Objects;

public class Customer extends Thread {
    BusinessPenguin salespenguin;

    int fishToBuy;
    int fishPrice;

    public static final Object monitor = new Object();

    public Customer(BusinessPenguin salesman, int fishToBuy, int fishPrice) {
        this.salespenguin = salesman;
        this.fishToBuy = fishToBuy;
        this.fishPrice = fishPrice;
    }

    public Customer(BusinessPenguin salesman) {
        this.salespenguin = salesman;

    }

    @Override
    public void run() {
        for (int i = 0; i <fishToBuy ; i++) {
            synchronized (monitor){
                salespenguin.sellFish(fishPrice);
            }

        }
    }

}
