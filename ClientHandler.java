package server;

import java.io.*;
import java.net.*;

public class ClientHandler implements Runnable {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ClientHandler(Socket socket) {

        this.socket = socket;

        try {

            in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            out = new PrintWriter(
                    socket.getOutputStream(), true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        String message;

        try {

            while ((message = in.readLine()) != null) {

                System.out.println(message);

                for (ClientHandler client : Server.clients) {

                    if (client != this) {
                        client.out.println(message);
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Client Disconnected");
        }
    }
}