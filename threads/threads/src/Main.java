import java.util.Objects;

public class Main extends Thread {
    private static int counter = 0;
    private static Object monitor = new Object();

    @Override
    public void run() {
        for (int i = 0; i < 100000;i++) {
            synchronized (monitor) {
                counter++; // atomic step
//                try {
//                    monitor.wait();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                counter++;
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {

        Main t1 = new Main();
        Main t2 = new Main();

        t1.start();
        t2.start();

        t1.join();
        t2.join();


        System.out.println(counter);

//        Runnable task = () -> System.out.println("i am running");
//        Thread t1 = new Thread(task);
//        t1.start();
    }
    private  void  fun(){
        synchronized (this){

        }
    }
    private  synchronized  void fun1(){

    }


}