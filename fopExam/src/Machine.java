public class Machine extends Thread {
    private final PenguinVoters penguinVoters;

    public Machine(PenguinVoters penguinVoters) {
        this.penguinVoters = penguinVoters;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Penguin penguin = penguinVoters.admit();
                penguin.vote();

            }
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
    }
}