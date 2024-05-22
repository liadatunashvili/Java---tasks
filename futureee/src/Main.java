import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Main extends Thread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<Boolean> isEven = () -> {
            Thread.sleep(2000);
            return true;
        };


        //ReentrantLock

       ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Boolean> future = service.submit(isEven);
        boolean a =future.get();
        System.out.println(a);
    }
}