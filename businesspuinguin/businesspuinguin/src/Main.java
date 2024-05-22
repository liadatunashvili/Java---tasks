public class Main {

public static void main(String[] args){
    BusinessPenguin peter =  new BusinessPenguin("peter");
    BusinessPenguin paul = new BusinessPenguin("Paul");

    peter.setPartner(paul);
    paul.setPartner(peter);

    Customer petersCustomer = new Customer(peter,5000,2);
    Customer paulsCustomer = new Customer(paul, 5000, 2);

    petersCustomer.start();
    paulsCustomer.start();

    try {
        petersCustomer.join();
        paulsCustomer.join();

    }catch (InterruptedException e){
        e.printStackTrace();
    }

    System.out.println("peters balance " + peter.getBalance());
    System.out.println("pauls balance " + paul.getBalance());




}



}