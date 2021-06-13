package com.example.classes.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(3000);
            Socket clientSocket = serverSocket.accept();
            BufferedReader inFromClientStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            OutputStream outToClientStream = clientSocket.getOutputStream();
        ) {
            String str = inFromClientStream.readLine();
            System.out.println("from client: " + str);
            outToClientStream.write("hello body".getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
