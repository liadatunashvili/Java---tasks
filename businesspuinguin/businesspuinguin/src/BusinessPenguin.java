
public class BusinessPenguin {
    String name;
    int balance;
    BusinessPenguin partner;


    public BusinessPenguin(String name) {
        this.name = name;
        this.balance = balance;
    }

    public void setPartner(BusinessPenguin partner){
        this.partner = partner;
    }


    public String getName(){
        return  name;
    }

    public int getBalance(){
        return balance;
    }
    public void sellFish(int price) {
        int revenueFromSale = price / 2;
        addBalance(revenueFromSale);
        partner.addBalance(revenueFromSale);
    }

    public  synchronized void addBalance(int revenue){
        this.balance += revenue;
    }


}
