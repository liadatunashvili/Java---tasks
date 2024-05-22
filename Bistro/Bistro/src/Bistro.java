public class Bistro {
    private int seats, capacity;
    private Thread order, meal, waiter;
    private final Object s, o, m;

    public Bistro(int n) {
        this.seats = n;
        this.capacity = n;
        this.s = new Object();
        this.o = new Object();
        this.m = new Object();
    }

    public void dine(int n) throws InterruptedException {
        synchronized (s) {
            while (seats <= 0) {
                s.wait();
            }
            seats--;
        }

        synchronized (o) {
            while(order != null) {
                o.wait();
            }
            order = Thread.currentThread();
            o.notifyAll();
        }
        System.out.println("Guest " + Thread.currentThread().getId() + "orders for " + n + " lari");

        synchronized (m) {
            while (meal != Thread.currentThread()){
                m.wait();
            }
            meal = null;
            m.notifyAll();
        }
        System.out.println("Guest " + Thread.currentThread().getId() + "eats...");

        synchronized (s) {
            seats++;
            notifyAll();
        }
    }

    private Runnable waiterTask = new Runnable() {
        @Override
        public void run() {
            while (!(seats == capacity) && Thread.interrupted()) {
                try {
                    serve();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        void serve() throws InterruptedException {
            Thread cur = null;
            synchronized (o) {
                while (order == null) {
                    o.wait();
                }
            }
            cur = order;
            order = null;
            o.notifyAll();

            synchronized (m) {
                while (meal != null) {
                    m.wait();
                }
                meal = cur;
                m.notifyAll();
            }
            System.out.println("enjoy!");
        }
    }
}