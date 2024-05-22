import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private final static  int  port = 9090;

    public static void main(String[] args) throws IOException {
        System.out.println("Starting server on port" + port);
        ServerSocket server =  new ServerSocket(port);
        System.out.println("waiting for connection....");
        Socket socket = new Socket();



        InputStream inputStream =  server.getInputStream();
        OutputStream outputStream = server.getOutputStream();
        DataInputStream input = new DataInputStream(inputStream);
        DataOutputStream output = new DataOutputStream(outputStream);

        Scanner scanner =  new Scanner(System.in);
        String line;
        while(true){
            System.out.println("server is conected now!");
            line = scanner.nextLine();
            output.writeUTF(line);
            output.flush();

        }


    }
}
