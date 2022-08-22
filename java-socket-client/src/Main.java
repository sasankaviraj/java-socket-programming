import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",8080);

        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.println("Is it working?");
        printWriter.flush();

        twoWayCommunication(socket);

        printWriter.close();
    }

    static void twoWayCommunication(Socket socket) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String str = bufferedReader.readLine();
        System.out.println("Server : "+str);

        bufferedReader.close();
        inputStreamReader.close();

    }
}
