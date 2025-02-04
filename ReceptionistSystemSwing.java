import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.HashMap;

public class ReceptionistSystemSwing {

    private static HashMap<Integer, Patient> roomAssignments = new HashMap<>();
    private static HashMap<String, Appointment> appointments = new HashMap<>();

    public static void main(String[] args) {
        ReceptionistSystemSwing system = new ReceptionistSystemSwing();
        system.runSystem();
    }

    private void runSystem() {
        loadRoomData();
        loadAppointmentData();
        showManagementMenu();
    }

    private void loadRoomData() {
        try (BufferedReader reader = new BufferedReader(new FileReader("rooms.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int roomNumber = Integer.parseInt(parts[0]);
                int bedNumber = Integer.parseInt(parts[1]);
                String name = parts[2];
                String disease = parts[3];
                String complications = parts[4];
                Patient patient = new Patient(roomNumber, bedNumber, name, disease, complications);
                roomAssignments.put(roomNumber, patient);
            }
        } catch (IOException e) {
            System.out.println("No room data found. Starting fresh.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid data format in rooms.txt. Starting fresh.");
        }
    }

    private void loadAppointmentData() {
        try (BufferedReader reader = new BufferedReader(new FileReader("appointments.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String patientName = parts[0];
                String date = parts[1];
                String time = parts[2];
                String doctor = parts[3];
                String reason = parts[4];
                Appointment appointment = new Appointment(patientName, date, time, doctor, reason);
                appointments.put(patientName, appointment);
            }
        } catch (IOException e) {
            System.out.println("No appointment data found. Starting fresh.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid data format in appointments.txt. Starting fresh.");
        }
    }

    private void saveRoomData() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("rooms.txt"))) {
            for (Patient patient : roomAssignments.values()) {
                writer.println(patient.toFileFormat());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveAppointmentData() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("appointments.txt"))) {
            for (Appointment appointment : appointments.values()) {
                writer.println(appointment.toFileFormat());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showManagementMenu() {
        JFrame frame = new JFrame("Receptionist Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
        panel.setBackground(new Color(245, 245, 245));

        JButton assignRoomButton = createStyledButton("Assign a Room");
        JButton scheduleAppointmentButton = createStyledButton("Schedule an Appointment");
        JButton viewDataButton = createStyledButton("View Data");
        JButton exitButton = createStyledButton("Exit");

        assignRoomButton.addActionListener(e -> showAssignRoomScreen());
        scheduleAppointmentButton.addActionListener(e -> showScheduleAppointmentScreen());
        viewDataButton.addActionListener(e -> showViewDataScreen());
        exitButton.addActionListener(e -> {
            saveRoomData();
            saveAppointmentData();
            JOptionPane.showMessageDialog(frame, "Data saved. Goodbye!");
            frame.dispose();
        });

        panel.add(assignRoomButton);
        panel.add(scheduleAppointmentButton);
        panel.add(viewDataButton);
        panel.add(exitButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 25));
        button.setBackground(new Color(70, 130, 180));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(200, 50));
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return button;
    }

    private void showAssignRoomScreen() {
        JFrame frame = new JFrame("Assign a Room");
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10));
        panel.setBackground(new Color(245, 245, 245));

        JLabel roomLabel = new JLabel("Room Number:");
        JTextField roomField = new JTextField();
        JLabel bedLabel = new JLabel("Bed Number:");
        JTextField bedField = new JTextField();
        JLabel nameLabel = new JLabel("Patient Name:");
        JTextField nameField = new JTextField();
        JLabel diseaseLabel = new JLabel("Disease:");
        JTextField diseaseField = new JTextField();
        JLabel complicationsLabel = new JLabel("Complications:");
        JTextField complicationsField = new JTextField();
        JButton assignButton = new JButton("Assign");

        Font font = new Font("Arial", Font.PLAIN, 25);
        roomLabel.setFont(font);
        bedLabel.setFont(font);
        nameLabel.setFont(font);
        diseaseLabel.setFont(font);
        complicationsLabel.setFont(font);
        roomField.setFont(font);
        bedField.setFont(font);
        nameField.setFont(font);
        diseaseField.setFont(font);
        complicationsField.setFont(font);
        assignButton.setFont(font);

        panel.add(roomLabel);
        panel.add(roomField);
        panel.add(bedLabel);
        panel.add(bedField);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(diseaseLabel);
        panel.add(diseaseField);
        panel.add(complicationsLabel);
        panel.add(complicationsField);
        panel.add(new JLabel());
        panel.add(assignButton);

        assignButton.addActionListener(e -> {
            try {
                int roomNumber = Integer.parseInt(roomField.getText());
                int bedNumber = Integer.parseInt(bedField.getText());
                String name = nameField.getText();
                String disease = diseaseField.getText();
                String complications = complicationsField.getText();

                Patient patient = new Patient(roomNumber, bedNumber, name, disease, complications);
                roomAssignments.put(roomNumber, patient);
                JOptionPane.showMessageDialog(frame, "Patient assigned successfully!");
                frame.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input. Please try again.");
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }

    private void showScheduleAppointmentScreen() {
        JFrame frame = new JFrame("Schedule an Appointment");
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10));
        panel.setBackground(new Color(245, 245, 245));

        JLabel nameLabel = new JLabel("Patient Name:");
        JTextField nameField = new JTextField();
        JLabel dateLabel = new JLabel("Appointment Date:");
        JTextField dateField = new JTextField();
        JLabel timeLabel = new JLabel("Appointment Time:");
        JTextField timeField = new JTextField();
        JLabel doctorLabel = new JLabel("Doctor's Name:");
        JTextField doctorField = new JTextField();
        JLabel reasonLabel = new JLabel("Reason:");
        JTextField reasonField = new JTextField();
        JButton scheduleButton = new JButton("Schedule");

        Font font = new Font("Arial", Font.PLAIN, 25);
        nameLabel.setFont(font);
        dateLabel.setFont(font);
        timeLabel.setFont(font);
        doctorLabel.setFont(font);
        reasonLabel.setFont(font);
        nameField.setFont(font);
        dateField.setFont(font);
        timeField.setFont(font);
        doctorField.setFont(font);
        reasonField.setFont(font);
        scheduleButton.setFont(font);

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(dateLabel);
        panel.add(dateField);
        panel.add(timeLabel);
        panel.add(timeField);
        panel.add(doctorLabel);
        panel.add(doctorField);
        panel.add(reasonLabel);
        panel.add(reasonField);
        panel.add(new JLabel());
        panel.add(scheduleButton);

        scheduleButton.addActionListener(e -> {
            String name = nameField.getText();
            String date = dateField.getText();
            String time = timeField.getText();
            String doctor = doctorField.getText();
            String reason = reasonField.getText();

            Appointment appointment = new Appointment(name, date, time, doctor, reason);
            appointments.put(name, appointment);
            JOptionPane.showMessageDialog(frame, "Appointment scheduled successfully!");
            frame.dispose();
        });

        frame.add(panel);
        frame.setVisible(true);
    }

    private void showViewDataScreen() {
        JFrame frame = new JFrame("View Data");
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Arial", Font.PLAIN, 20));

        StringBuilder data = new StringBuilder("Room Assignments:\n");
        for (Patient patient : roomAssignments.values()) {
            data.append(patient).append("\n");
        }

        data.append("\nAppointments:\n");
        for (Appointment appointment : appointments.values()) {
            data.append(appointment).append("\n");
        }

        textArea.setText(data.toString());
        frame.add(new JScrollPane(textArea));
        frame.setVisible(true);
    }
}

class Patient {
    private int roomNumber;
    private int bedNumber;
    private String name;
    private String disease;
    private String complications;

    public Patient(int roomNumber, int bedNumber, String name, String disease, String complications) {
        this.roomNumber = roomNumber;
        this.bedNumber = bedNumber;
        this.name = name;
        this.disease = disease;
        this.complications = complications;
    }

    @Override
    public String toString() {
        return String.format("Room %d, Bed %d: %s (Disease: %s, Complications: %s)",
                roomNumber, bedNumber, name, disease, complications);
    }

    public String toFileFormat() {
        return String.format("%d,%d,%s,%s,%s", roomNumber, bedNumber, name, disease, complications);
    }
}

class Appointment {
    private String patientName;
    private String date;
    private String time;
    private String doctor;
    private String reason;

    public Appointment(String patientName, String date, String time, String doctor, String reason) {
        this.patientName = patientName;
        this.date = date;
        this.time = time;
        this.doctor = doctor;
        this.reason = reason;
    }

    @Override
    public String toString() {
        return String.format("Patient: %s, Date: %s, Time: %s, Doctor: %s, Reason: %s",
                patientName, date, time, doctor, reason);
    }

    public String toFileFormat() {
        return String.format("%s,%s,%s,%s,%s", patientName, date, time, doctor, reason);
    }
}
