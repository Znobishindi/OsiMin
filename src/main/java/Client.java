import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 10254;
        try (Socket clientSocket = new Socket(host,port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))){
            out.println("Денис");
            String answer = in.readLine();
            System.out.println(answer);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

