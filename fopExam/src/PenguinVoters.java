import java.util.LinkedList;
import java.util.List;

public class PenguinVoters {
    private final List<Penguin> voterList = new LinkedList<>();

    public synchronized void register(Penguin p) {
        voterList.add(p);
        notifyAll();
    }

    public synchronized Penguin admit() throws InterruptedException {
        while (voterList.isEmpty()) {
            wait();
        }
        return voterList.remove(0);
    }
}