import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin {

    Admin() {
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

        JLabel Label1 = new JLabel("Admin Login");
        Label1.setBounds(200, 50, 200, 40);
        Label1.setFont(new Font("Arial", Font.BOLD, 30));
        frame.add(Label1);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 250, 200, 40);
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 22));

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(250, 250, 250, 40);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(400, 350, 100, 30);
        loginButton.setFont(new Font("Arial", Font.BOLD, 20));

        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(250, 350, 100, 30);
        clearButton.setFont(new Font("Arial", Font.BOLD, 20));

        JButton backb = new JButton("Back");
        backb.setBounds(100, 350, 100, 30);
        backb.setFont(new Font("Arial", Font.BOLD, 20));

        backb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        frame.add(userLabel);
        frame.add(userField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(loginButton);
        frame.add(clearButton);
        frame.add(backb);

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
                    JOptionPane.showMessageDialog(frame, "Login Successful!");
                    frame.dispose();

                    JFrame doctorFrame = new JFrame("Doctor Schedule");
                    doctorFrame.setSize(400, 300);
                    doctorFrame.setLayout(null);
                    doctorFrame.setLocationRelativeTo(null);

                    JLabel doctorLabel = new JLabel("Doctor Schedule Login");
                    doctorLabel.setBounds(90, 50, 300, 40);
                    doctorLabel.setFont(new Font("Arial", Font.BOLD, 20));

                    JButton scheduleButton = new JButton("Doctor Schedule");
                    scheduleButton.setBounds(100, 150, 200, 30);
                    scheduleButton.setFont(new Font("Arial", Font.PLAIN, 18));
                    scheduleButton.setFocusable(false);

                    scheduleButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JOptionPane.showMessageDialog(doctorFrame, "Doctor Schedule Login clicked!");
                            DoctorAdminSection d = new DoctorAdminSection();

                        }
                    });

                    doctorFrame.add(doctorLabel);
                    doctorFrame.add(scheduleButton);

                    doctorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    doctorFrame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid Username or Password!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Admin();
    }
}
