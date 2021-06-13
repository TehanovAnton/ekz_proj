package classes.sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(3000);
            Socket clientSocket = serverSocket.accept();
            BufferedReader inFromClientStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter outToClientStream = new PrintWriter(clientSocket.getOutputStream());
        ) {
            String msg = inFromClientStream.readLine();
            System.out.println("from client: " + msg);
            outToClientStream.println("hello body");
            outToClientStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
