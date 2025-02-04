import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EmergencyTransferForm extends JFrame {
    private JTextField nameField, contactField, dobField, conditionField;
    private JRadioButton maleButton, femaleButton, yesButton, noButton;
    private JButton submitButton, backButton;
    private static final String FILE_NAME = "emergency.txt";

    public EmergencyTransferForm() {
        setTitle("Emergency Transfer Request Form");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);


        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        Font font = new Font("Arial", Font.BOLD, 28);

        JButton callButton = new JButton("CALL EMERGENCY LINE - 10666");
        callButton.setBackground(Color.RED);
        callButton.setForeground(Color.WHITE);
        callButton.setFont(font);
        callButton.setBounds(1200, 800, 500, 50);
        add(callButton);

        int labelX = width / 5;
        int fieldX = width / 2;
        int y = 150;
        int gap = 60;
        int labelWidth = 300;
        int fieldWidth = 400;
        int fieldHeight = 40;

        addLabel("Patient's Name:", font, labelX, y);
        nameField = addTextField(font, fieldX, y, fieldWidth, fieldHeight);

        addLabel("Emergency Contact Number:", font, labelX, y += gap);
        contactField = addTextField(font, fieldX, y, fieldWidth, fieldHeight);

        addLabel("Date of Birth (mm/dd/yyyy):", font, labelX, y += gap);
        dobField = addTextField(font, fieldX, y, fieldWidth, fieldHeight);

        addLabel("Gender:", font, labelX, y += gap);
        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");

        maleButton.setFont(font);
        femaleButton.setFont(font);
        maleButton.setBounds(fieldX, y, 100, 40);
        femaleButton.setBounds(fieldX + 150, y, 180, 40);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        add(maleButton);
        add(femaleButton);

        addLabel("Condition:", font, labelX, y += gap);
        conditionField = addTextField(font, fieldX, y, fieldWidth, fieldHeight);

        addLabel("Do you need an ambulance?", font, labelX, y += gap);
        yesButton = new JRadioButton("Yes");
        noButton = new JRadioButton("No");

        yesButton.setFont(font);
        noButton.setFont(font);
        yesButton.setBounds(fieldX, y, 100, 40);
        noButton.setBounds(fieldX + 150, y, 100, 40);

        ButtonGroup ambulanceGroup = new ButtonGroup();
        ambulanceGroup.add(yesButton);
        ambulanceGroup.add(noButton);

        add(yesButton);
        add(noButton);

        JLabel l = new JLabel("<html>" +
                "Ambulance Service<br>" +
                "The Cardiac Ambulance is always accompanied by:<br>" +
                "Specialist, Nurse, PCA<br>" +
                "The Normal Ambulance is always accompanied by:<br>" +
                "Nurse, PCA<br>" +
                "For any emergency need, please call:<br>" +
                "019******* or 019********" +
                "</html>");

        l.setFont(new Font("Arial", Font.PLAIN, 25));
        l.setForeground(Color.RED);
        l.setBounds(200, 600, 600, 300);
        add(l);


        backButton = new JButton("Back");
        backButton.setFont(font);
        backButton.setBounds(880, 550, 170, 40);
        backButton.addActionListener(e -> dispose()); // Close form on click
        add(backButton);

        submitButton = new JButton("SUBMIT");
        submitButton.setBackground(Color.BLUE);
        submitButton.setForeground(Color.WHITE);
        submitButton.setFont(font);
        submitButton.setBounds(1180, 550, 170, 40);
        submitButton.addActionListener(new SubmitAction());
        add(submitButton);

        setVisible(true);
    }

    private void addLabel(String text, Font font, int x, int y) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setBounds(x, y, 400, 40);
        add(label);
    }

    private JTextField addTextField(Font font, int x, int y, int width, int height) {
        JTextField textField = new JTextField();
        textField.setFont(font);
        textField.setBounds(x, y, width, height);
        add(textField);
        return textField;
    }

    private class SubmitAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText().trim();
            String contact = contactField.getText().trim();
            String dob = dobField.getText().trim();
            String condition = conditionField.getText().trim();
            String gender = maleButton.isSelected() ? "Male" : (femaleButton.isSelected() ? "Female" : "Not specified");
            String ambulance = yesButton.isSelected() ? "Yes" : (noButton.isSelected() ? "No" : "Not specified");

            // Input validation
            if (name.isEmpty() || contact.isEmpty() || dob.isEmpty() || condition.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all required fields.");
                return;
            }

            if (!contact.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Emergency contact must contain only numbers.");
                return;
            }

            if (!dob.matches("\\d{2}/\\d{2}/\\d{4}")) {
                JOptionPane.showMessageDialog(null, "Date of birth must be in MM/DD/YYYY format.");
                return;
            }

            String details = "Patient's Name: " + name + "\n"
                    + "Emergency Contact: " + contact + "\n"
                    + "Date of Birth: " + dob + "\n"
                    + "Gender: " + gender + "\n"
                    + "Condition: " + condition + "\n"
                    + "Needs Ambulance: " + ambulance + "\n"
                    + "----------------------------\n";

            saveToFile(details);
        }

        private void saveToFile(String data) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
                writer.write(data);
                JOptionPane.showMessageDialog(null, "Details saved successfully!");
                clearFields();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error saving data: " + e.getMessage());
            }
        }

        private void clearFields() {
            nameField.setText("");
            contactField.setText("");
            dobField.setText("");
            conditionField.setText("");
            maleButton.setSelected(false);
            femaleButton.setSelected(false);
            yesButton.setSelected(false);
            noButton.setSelected(false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EmergencyTransferForm::new);
    }
}
