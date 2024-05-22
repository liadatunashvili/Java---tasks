
public class Main extends fop.w3box.MiniJava {

    public static void outputBoxes(boolean[] boxes) {
        StringBuilder sb = new StringBuilder("Open boxes: 1:");
        sb.append(boxes[0]);
        for (int i = 1; i < boxes.length; i++) {
            sb.append(" ").append(i + 1).append(":").append(boxes[i]);
        }
        write(sb.toString());
    }

    public static void main(String[] args) throws IllegalAccessException {

        boolean[] arru ={true, true, true, true, true, true, true, true};
          int a = 0;
          int b = 0;
          int c = 0;
          int account1 = 0;
          int account2 = 0;


        for (int i = 0; i <arru.length ; i++) {
            a = dice();
            b = dice();
            c =  a + b;



            
        }
          
          
          
          
          
          
          
          
          
          if(account1> account2){
              
          }else if(account2>account1){
              
          }else {
              
              
          }


    }







}