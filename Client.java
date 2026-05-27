package client;

import java.io.*;
import java.net.*;

public class Client {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public Client(String serverAddress, int port) throws IOException {
        socket = new Socket(serverAddress, port);

        in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        out = new PrintWriter(
                socket.getOutputStream(), true);
    }

    public void sendMessage(String msg) {
        out.println(msg);
    }

    public void receiveMessages() {
        new Thread(() -> {
            try {
                String msg;

                while ((msg = in.readLine()) != null) {
                    System.out.println(msg);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}