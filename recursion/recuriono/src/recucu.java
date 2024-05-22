public class recucu {


    public int iter(int[] arr){
        int[]  arru = new int[arr.length];
        int a  = arru.length;


        for (int i = 1; i <=arr.length ; i++) {
           arru = new int[arr.length-1];

            a =  a * iter(arru);


        }


        return a;
    }



    public int[][] permu(int[] arr){

        int row = iter(arr);


        int[][] arru =  new int[row][];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j <arr.length ; j++) {

                arru[i][j] = permu();

            }

        }




        return
    }
}
