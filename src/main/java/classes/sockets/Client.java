package classes.sockets;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try(Socket client = new Socket("localhost", 3000);
            BufferedReader inFromServerStream = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter outToServer = new PrintWriter(client.getOutputStream());
        ) {
            outToServer.println("hello server");
            outToServer.flush();

            String msg = inFromServerStream.readLine();
            System.out.println("from server: " + msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
