package com.example.classes.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {
    public static void main(String[] args) {
        try(Socket client = new Socket("localhost", 3000);
            BufferedReader inFromServerStream = new BufferedReader(new InputStreamReader(client.getInputStream()));
            OutputStream outToServer = client.getOutputStream()
        ) {
            outToServer.write("hello server".getBytes(StandardCharsets.UTF_8));
            System.out.println("from server: " + inFromServerStream.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
