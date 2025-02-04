import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataRecords extends JFrame implements ActionListener {

    private JTextField xrayField, ctScanField, mriField, bandageField, injectionField, roomNumberField;
    private JButton addButton, viewButton, exitButton;
    private JTextArea displayArea;
    private List<String> records = new ArrayList<>();

    public DataRecords() {
        setTitle("Hospital Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setLayout(null);
        getContentPane().setBackground(new Color(248, 249, 250));

        Font labelFont = new Font("Arial", Font.BOLD, 40);
        Font fieldFont = new Font("Arial", Font.PLAIN, 40);
        Font buttonFont = new Font("Arial", Font.BOLD, 40);

        JLabel roomNumberLabel = new JLabel("Room Number:");
        roomNumberLabel.setFont(labelFont);
        roomNumberField = new JTextField(10);
        roomNumberField.setFont(fieldFont);
        roomNumberField.setPreferredSize(new Dimension(200, 50));
        roomNumberField.setBorder(BorderFactory.createLineBorder(new Color(189, 155, 91), 2));

        JLabel xrayLabel = new JLabel("X-Ray Count:");
        xrayLabel.setFont(labelFont);
        xrayField = new JTextField(10);
        xrayField.setFont(fieldFont);
        xrayField.setPreferredSize(new Dimension(200, 50));
        xrayField.setBorder(BorderFactory.createLineBorder(new Color(189, 155, 91), 2));

        JLabel ctScanLabel = new JLabel("CT Scan Count:");
        ctScanLabel.setFont(labelFont);
        ctScanField = new JTextField(10);
        ctScanField.setFont(fieldFont);
        ctScanField.setPreferredSize(new Dimension(200, 50));
        ctScanField.setBorder(BorderFactory.createLineBorder(new Color(189, 155, 91), 2));

        JLabel mriLabel = new JLabel("MRI Count:");
        mriLabel.setFont(labelFont);
        mriField = new JTextField(10);
        mriField.setFont(fieldFont);
        mriField.setPreferredSize(new Dimension(200, 50));
        mriField.setBorder(BorderFactory.createLineBorder(new Color(189, 155, 91), 2));

        JLabel bandageLabel = new JLabel("Bandage Count:");
        bandageLabel.setFont(labelFont);
        bandageField = new JTextField(10);
        bandageField.setFont(fieldFont);
        bandageField.setPreferredSize(new Dimension(200, 50));
        bandageField.setBorder(BorderFactory.createLineBorder(new Color(189, 155, 91), 2));

        JLabel injectionLabel = new JLabel("Injection Count:");
        injectionLabel.setFont(labelFont);
        injectionField = new JTextField(10);
        injectionField.setFont(fieldFont);
        injectionField.setPreferredSize(new Dimension(200, 50));
        injectionField.setBorder(BorderFactory.createLineBorder(new Color(189, 155, 91), 2));

        addButton = new JButton("Add Record");
        addButton.setFont(buttonFont);
        addButton.setBackground(new Color(34, 177, 76));
        addButton.setForeground(Color.WHITE);
        addButton.addActionListener(this);
        addButton.setFocusPainted(false);

        viewButton = new JButton("View Records");
        viewButton.setFont(buttonFont);
        viewButton.setBackground(new Color(0, 102, 204));
        viewButton.setForeground(Color.WHITE);
        viewButton.addActionListener(this);
        viewButton.setFocusPainted(false);

        exitButton = new JButton("Exit");
        exitButton.setFont(buttonFont);
        exitButton.setBackground(new Color(255, 0, 0));
        exitButton.setForeground(Color.WHITE);
        exitButton.addActionListener(this);
        exitButton.setFocusPainted(false);

        roomNumberLabel.setBounds(100, 100, 400, 50);
        roomNumberField.setBounds(500, 100, 200, 50);

        xrayLabel.setBounds(100, 200, 400, 50);
        xrayField.setBounds(500, 200, 200, 50);

        ctScanLabel.setBounds(100, 300, 400, 50);
        ctScanField.setBounds(500, 300, 200, 50);

        mriLabel.setBounds(100, 400, 400, 50);
        mriField.setBounds(500, 400, 200, 50);

        bandageLabel.setBounds(100, 500, 400, 50);
        bandageField.setBounds(500, 500, 200, 50);

        injectionLabel.setBounds(100, 600, 400, 50);
        injectionField.setBounds(500, 600, 200, 50);

        addButton.setBounds(100, 700, 600, 50);
        viewButton.setBounds(100, 800, 600, 50);
        exitButton.setBounds(100, 900, 600, 50);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Arial", Font.PLAIN, 40));
        displayArea.setBackground(new Color(255, 255, 255));
        displayArea.setBorder(BorderFactory.createLineBorder(new Color(189, 155, 91), 2));

        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBounds(800, 100, 1200, 600);

        add(roomNumberLabel);
        add(roomNumberField);
        add(xrayLabel);
        add(xrayField);
        add(ctScanLabel);
        add(ctScanField);
        add(mriLabel);
        add(mriField);
        add(bandageLabel);
        add(bandageField);
        add(injectionLabel);
        add(injectionField);
        add(addButton);
        add(viewButton);
        add(exitButton);
        add(scrollPane);

        loadRecordsFromFile();

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String roomNumber = roomNumberField.getText();
            String xray = xrayField.getText();
            String ctScan = ctScanField.getText();
            String mri = mriField.getText();
            String bandage = bandageField.getText();
            String injection = injectionField.getText();

            if (!roomNumber.isEmpty() && !xray.isEmpty() && !ctScan.isEmpty() && !mri.isEmpty() && !bandage.isEmpty() && !injection.isEmpty()) {
                String record = String.format("Room: %-10s X-Ray: %-10s CT Scan: %-10s MRI: %-10s Bandage: %-10s Injection: %-10s",
                        roomNumber, xray, ctScan, mri, bandage, injection);
                records.add(record);
                saveRecordsToFile();
                clearFields();
                displayArea.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Please enter all values.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == viewButton) {
            displayArea.setText("");
            if (records.isEmpty()) {
                displayArea.append("No records available.\n");
            } else {
                displayArea.append("----------------------------------------------------------------------------------------\n");
                displayArea.append(String.format("%-15s %-15s %-15s %-15s %-15s %-15s\n", "Room", "X-Ray", "CT Scan", "MRI", "Bandage", "Injection"));
                displayArea.append("----------------------------------------------------------------------------------------\n");
                for (String record : records) {
                    displayArea.append(record + "\n");
                }
                displayArea.append("----------------------------------------------------------------------------------------\n");
            }
        } else if (e.getSource() == exitButton) {
            dispose();
        }
    }

    private void saveRecordsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("hospital_records.txt"))) {
            for (String record : records) {
                writer.write(record + "\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving records to file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadRecordsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("hospital_records.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                records.add(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading records from file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        roomNumberField.setText("");
        xrayField.setText("");
        ctScanField.setText("");
        mriField.setText("");
        bandageField.setText("");
        injectionField.setText("");
    }

    public static void main(String[] args) {
        new DataRecords();
    }
}
