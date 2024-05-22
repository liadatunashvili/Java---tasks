public class Election {
    private final PenguinVoters pv;
    private final Machine[] machines;

    public Election(int n) {
        pv = new PenguinVoters();
        machines = new Machine[n];

        for (int i = 0; i < n; i++) {
            machines[i] = new Machine(pv);
            machines[i].start();
        }
    }

    public void shutdown(){
      Thread.interrupted(); //
    }

}
