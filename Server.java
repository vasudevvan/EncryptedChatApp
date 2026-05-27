package server;

import java.net.*;
import java.io.*;
import java.util.*;

public class Server {

    public static Vector<ClientHandler> clients = new Vector<>();

    public static void main(String[] args) {

        try {

            ServerSocket serverSocket = new ServerSocket(5000);

            System.out.println("Server Started...");

            while (true) {

                Socket socket = serverSocket.accept();

                System.out.println("Client Connected");

                ClientHandler client = new ClientHandler(socket);

                clients.add(client);

                Thread thread = new Thread(client);

                thread.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}