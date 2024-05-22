import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static final String host = "localhost";
    private static final int part =  9090;

    public Client() {

    }

    public static void main(String[] args) throws IOException {
        System.out.println("attempting to connect to" + host + "");
        Socket client  = new Socket(host, part);
        System.out.println("Conected!!");


        InputStream inputStream =  client.getInputStream();
        OutputStream outputStream = client.getOutputStream();

        DataInputStream input = new DataInputStream(inputStream);
        DataOutputStream output = new DataOutputStream(outputStream);

        Scanner scanner =  new Scanner(System.in);
        String line;
        while(true){
            line = scanner.nextLine();
            output.writeUTF(line);
            output.flush();

        }

    }
}