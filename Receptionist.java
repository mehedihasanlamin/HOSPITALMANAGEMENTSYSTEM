import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Receptionist {

    Receptionist() {
        JFrame frame = new JFrame("Admin Login");

        frame.setTitle("Admin Login");
        frame.setLayout(null);
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 150, 200, 40);
        userLabel.setFont(new Font("Arial", Font.PLAIN, 22));

        JTextField userField = new JTextField();
        userField.setBounds(250, 150, 250, 40);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 250, 200, 40);
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 22));

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(250, 250, 250, 40);

        JLabel Label1 = new JLabel("Receptionist Login");
        Label1.setBounds(150, 50, 500, 40);
        Label1.setFont(new Font("Arial", Font.BOLD, 30));
        frame.add(Label1);

        JButton backb1 = new JButton("Back");
        backb1.setBounds(100, 350, 100, 30);
        backb1.setFont(new Font("Arial", Font.BOLD, 20));
        backb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(400, 350, 100, 30);
        loginButton.setFont(new Font("Arial", Font.BOLD, 20));

        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(250, 350, 100, 30);
        clearButton.setFont(new Font("Arial", Font.BOLD, 20));

        frame.add(userLabel);
        frame.add(userField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(loginButton);
        frame.add(clearButton);
        frame.add(backb1);

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userField.setText("");
                passwordField.setText("");
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passwordField.getPassword());

                if (username.equals("admin") && password.equals("password")) {
                    frame.setVisible(false);
                    openMainPanel();
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid Username or Password!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }

    private void openMainPanel() {
        JFrame mainFrame = new JFrame("Admin Panel");

        mainFrame.setSize(600, 500);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(new FlowLayout());

        JButton managementButton = new JButton("Management");
        managementButton.setFont(new Font("Arial", Font.PLAIN, 25));
        managementButton.setFocusable(false);
        managementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReceptionistSystemSwing receptionistSystemSwing = new ReceptionistSystemSwing();
            }
        });

        JButton dataRecordButton = new JButton("Data Records");
        dataRecordButton.setFont(new Font("Arial", Font.PLAIN, 25));
        dataRecordButton.setFocusable(false);
        dataRecordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataRecords d = new DataRecords();
            }
        });

        mainFrame.add(managementButton);
        mainFrame.add(dataRecordButton);

        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new Receptionist();
    }
}
