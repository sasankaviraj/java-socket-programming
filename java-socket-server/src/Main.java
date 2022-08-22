import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket = serverSocket.accept();

        System.out.println("Client Connected");

        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String str = bufferedReader.readLine();
        System.out.println("Client : "+str);

        twoWayCommunication(socket);

        inputStreamReader.close();
        bufferedReader.close();
    }

    static void twoWayCommunication(Socket socket) throws IOException {
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.println("Yes. It is working!");
        printWriter.flush();
        printWriter.close();
    }
}
