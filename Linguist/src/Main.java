public class Main {
    public static void main(String[] args) {
        Dictionary<Meaning<Integer>> test = new Dictionary<>();

        for(int i = 0; i<args.length; i++){
            test.record(args[i],new IntMeaning(i));
        }

        for (int i = 0; i < args.length; i++) {
            int value = test.lookUp(args[i]).meaning();
            test.remove(args[i]);
            System.out.println(args[i] + " : " + value);
        }

    }


}
