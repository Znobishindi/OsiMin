import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        System.out.println("Сервер запущен");
        int port = 10254;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                System.out.printf("Новое соединение установлено. Порт: %d%n", clientSocket.getPort());

                final String name = in.readLine();

                out.println(String.format("Привет %s, твой порт %d", name, clientSocket.getPort()));
            }
        }
    }
}
