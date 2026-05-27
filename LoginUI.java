package client;

import javax.swing.*;

public class LoginUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Login");

        JLabel label = new JLabel("Username:");
        JTextField textField = new JTextField();

        JButton button = new JButton("Login");

        label.setBounds(20, 20, 100, 30);
        textField.setBounds(120, 20, 150, 30);
        button.setBounds(120, 70, 100, 30);

        frame.add(label);
        frame.add(textField);
        frame.add(button);

        frame.setSize(350, 180);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button.addActionListener(e -> {
            String username = textField.getText();

            new ChatUI(username);
            frame.dispose();
        });
    }
}