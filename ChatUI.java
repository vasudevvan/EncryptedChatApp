// ===========================
// FILE: client/ChatUI.java
// ===========================

package client;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ChatUI {

    private JTextArea chatArea;
    private JTextField messageField;

    public ChatUI(String username) {

        JFrame frame = new JFrame("Encrypted Chat");

        chatArea = new JTextArea();
        chatArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(chatArea);

        messageField = new JTextField();

        JButton sendButton = new JButton("Send");

        JPanel panel = new JPanel(new BorderLayout());

        panel.add(messageField, BorderLayout.CENTER);
        panel.add(sendButton, BorderLayout.EAST);

        frame.setLayout(new BorderLayout());

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);

        frame.setSize(500, 400);
        frame.setVisible(true);

        try {

            Client client = new Client("localhost", 5000);

            client.receiveMessages();

            sendButton.addActionListener(e -> {

                String msg = username + ": " + messageField.getText();

                client.sendMessage(msg);

                chatArea.append(msg + "\n");

                messageField.setText("");
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}