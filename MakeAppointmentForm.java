import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MakeAppointmentForm {

    private Map<String, String[]> doctorMap = new HashMap<>();

    public MakeAppointmentForm() {
        JFrame frame = new JFrame("Make Appointment");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 1000);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        Font font = new Font("Arial", Font.PLAIN, 25);
        Font titleFont = new Font("Arial", Font.BOLD, 30);

        JLabel titleLabel = new JLabel("Make Appointment");
        titleLabel.setFont(titleFont);
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setBounds(250, 10, 400, 50);
        frame.add(titleLabel);

        JLabel nameLabel = new JLabel("Patient's Full Name *:");
        nameLabel.setFont(font);
        nameLabel.setForeground(Color.BLACK);
        nameLabel.setBounds(30, 80, 300, 40);
        JTextField nameField = new JTextField();
        nameField.setFont(font);
        nameField.setBounds(350, 80, 400, 40);

        JLabel dobLabel = new JLabel("Date of Birth *:");
        dobLabel.setFont(font);
        dobLabel.setForeground(Color.BLACK);
        dobLabel.setBounds(30, 140, 300, 40);
        String[] months = {"Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        JComboBox<String> monthComboBox = new JComboBox<>(months);
        monthComboBox.setFont(font);
        monthComboBox.setBounds(350, 140, 130, 40);
        String[] days = {"Day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        JComboBox<String> dayComboBox = new JComboBox<>(days);
        dayComboBox.setFont(font);
        dayComboBox.setBounds(490, 140, 80, 40);
        String[] years = {"Year","1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989",
                "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999",
                "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009",
                "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019",
                "2020", "2021", "2022", "2023", "2024"};
        JComboBox<String> yearComboBox = new JComboBox<>(years);
        yearComboBox.setFont(font);
        yearComboBox.setBounds(580, 140, 100, 40);

        JLabel sexLabel = new JLabel("Sex *:");
        sexLabel.setFont(font);
        sexLabel.setForeground(Color.BLACK);
        sexLabel.setBounds(30, 200, 300, 40);
        JRadioButton maleButton = new JRadioButton("Male");
        maleButton.setFont(font);
        maleButton.setBounds(350, 200, 100, 40);
        JRadioButton femaleButton = new JRadioButton("Female");
        femaleButton.setFont(font);
        femaleButton.setBounds(460, 200, 120, 40);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        JLabel bloodGroupLabel = new JLabel("Blood Group *:");
        bloodGroupLabel.setFont(font);
        bloodGroupLabel.setForeground(Color.BLACK);
        bloodGroupLabel.setBounds(30, 260, 300, 40);
        String[] bloodGroups = {"Select", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
        JComboBox<String> bloodGroupComboBox = new JComboBox<>(bloodGroups);
        bloodGroupComboBox.setFont(font);
        bloodGroupComboBox.setBounds(350, 260, 400, 40);

        JLabel addressLabel = new JLabel("Address *:");
        addressLabel.setFont(font);
        addressLabel.setForeground(Color.BLACK);
        addressLabel.setBounds(30, 320, 300, 40);
        JTextField addressField = new JTextField();
        addressField.setFont(font);
        addressField.setBounds(350, 320, 400, 40);

        JLabel mobileLabel = new JLabel("Mobile *:");
        mobileLabel.setFont(font);
        mobileLabel.setForeground(Color.BLACK);
        mobileLabel.setBounds(30, 380, 300, 40);
        JTextField mobileField = new JTextField();
        mobileField.setFont(font);
        mobileField.setBounds(350, 380, 400, 40);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(font);
        emailLabel.setForeground(Color.BLACK);
        emailLabel.setBounds(30, 440, 300, 40);
        JTextField emailField = new JTextField();
        emailField.setFont(font);
        emailField.setBounds(350, 440, 400, 40);

        JLabel requestLabel = new JLabel("Request for *:");
        requestLabel.setFont(font);
        requestLabel.setForeground(Color.BLACK);
        requestLabel.setBounds(30, 500, 300, 40);
        String[] requests = {"Choose One", "New Appointment", "Follow-up"};
        JComboBox<String> requestComboBox = new JComboBox<>(requests);
        requestComboBox.setFont(font);
        requestComboBox.setBounds(350, 500, 400, 40);

        JLabel specialtyLabel = new JLabel("Specialty for consultation *:");
        specialtyLabel.setFont(font);
        specialtyLabel.setForeground(Color.BLACK);
        specialtyLabel.setBounds(30, 560, 400, 40);
        String[] specialties = {"Choose Specialty", "Cardiology", "Dermatology", "Neurology", "Pediatrics", "Orthopedics", "Gastroenterology", "Endocrinology", "Ophthalmology", "Psychiatry", "General Medicine"};
        JComboBox<String> specialtyComboBox = new JComboBox<>(specialties);
        specialtyComboBox.setFont(font);
        specialtyComboBox.setBounds(350, 560, 400, 40);

        JLabel doctorLabel = new JLabel("Doctor *:");
        doctorLabel.setFont(font);
        doctorLabel.setForeground(Color.BLACK);
        doctorLabel.setBounds(30, 620, 300, 40);
        JComboBox<String> doctorComboBox = new JComboBox<>();
        doctorComboBox.setFont(font);
        doctorComboBox.setBounds(350, 620, 400, 40);

        loadDoctorData();


        specialtyComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedSpecialty = (String) specialtyComboBox.getSelectedItem();
                updateDoctorComboBox(selectedSpecialty, doctorComboBox);
            }
        });

        JButton submitButton = new JButton("Submit");
        submitButton.setFont(font);
        submitButton.setBounds(550, 740, 200, 50);
        submitButton.setFocusable(false);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String patientName = nameField.getText();
                String dob = monthComboBox.getSelectedItem() + " " + dayComboBox.getSelectedItem() + ", " + yearComboBox.getSelectedItem();
                String gender = maleButton.isSelected() ? "Male" : "Female";
                String bloodGroup = (String) bloodGroupComboBox.getSelectedItem();
                String address = addressField.getText();
                String mobile = mobileField.getText();
                String email = emailField.getText();
                String requestType = (String) requestComboBox.getSelectedItem();
                String specialty = (String) specialtyComboBox.getSelectedItem();
                String doctor = (String) doctorComboBox.getSelectedItem();

                // Check if any required fields are empty
                if (patientName.isEmpty() || bloodGroup.equals("Select") || address.isEmpty() || mobile.isEmpty() || requestType.equals("Choose One") || specialty.equals("Choose Specialty") || doctor.equals("Select Doctor")) {
                    JOptionPane.showMessageDialog(frame, "Please fill out all the required fields.");
                    return;
                }


                String appointmentDetails = "Patient's Full Name: " + patientName + "\n" +
                        "Date of Birth: " + dob + "\n" +
                        "Gender: " + gender + "\n" +
                        "Blood Group: " + bloodGroup + "\n" +
                        "Address: " + address + "\n" +
                        "Mobile: " + mobile + "\n" +
                        "Email: " + email + "\n" +
                        "Request for: " + requestType + "\n" +
                        "Specialty: " + specialty + "\n" +
                        "Doctor: " + doctor + "\n\n";


                try (BufferedWriter writer = new BufferedWriter(new FileWriter("appointmentdetails.txt", true))) {
                    writer.write(appointmentDetails);
                    writer.flush();

                    showThankYouFrame();
                } catch (IOException ioException) {
                    JOptionPane.showMessageDialog(frame, "An error occurred while saving the appointment details.");
                    ioException.printStackTrace();
                }
            }
        });

        JButton backButton = new JButton("Back");
        backButton.setFont(font);
        backButton.setBounds(350, 740, 150, 50);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });


        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(dobLabel);
        frame.add(monthComboBox);
        frame.add(dayComboBox);
        frame.add(yearComboBox);
        frame.add(sexLabel);
        frame.add(maleButton);
        frame.add(femaleButton);
        frame.add(bloodGroupLabel);
        frame.add(bloodGroupComboBox);
        frame.add(addressLabel);
        frame.add(addressField);
        frame.add(mobileLabel);
        frame.add(mobileField);
        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(requestLabel);
        frame.add(requestComboBox);
        frame.add(specialtyLabel);
        frame.add(specialtyComboBox);
        frame.add(doctorLabel);
        frame.add(doctorComboBox);
        frame.add(submitButton);
        frame.add(backButton);

        frame.setVisible(true);
    }


    private void showThankYouFrame() {
        JFrame thankYouFrame = new JFrame("Thank You");
        thankYouFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        thankYouFrame.setSize(500, 150);
        thankYouFrame.setBackground(Color.white);
        thankYouFrame.setLocationRelativeTo(null);

        JLabel thankYouLabel = new JLabel("Thank You for your appointment!", JLabel.CENTER);
        thankYouLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        thankYouLabel.setForeground(Color.black);

        thankYouFrame.add(thankYouLabel);

        thankYouFrame.setVisible(true);
    }

    private void loadDoctorData() {

        try (BufferedReader reader = new BufferedReader(new FileReader("doctors.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String specialty = parts[0].trim();
                    String[] doctors = parts[1].split(",");
                    for (int i = 0; i < doctors.length; i++) {
                        doctors[i] = doctors[i].trim();
                    }
                    doctorMap.put(specialty, doctors);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateDoctorComboBox(String specialty, JComboBox<String> doctorComboBox) {
        doctorComboBox.removeAllItems();
        doctorComboBox.addItem("Select Doctor");

        if (doctorMap.containsKey(specialty)) {
            String[] doctors = doctorMap.get(specialty);
            for (String doctor : doctors) {
                doctorComboBox.addItem(doctor);
            }
        }
    }

    public static void main(String[] args) {
        new MakeAppointmentForm();
    }
}
