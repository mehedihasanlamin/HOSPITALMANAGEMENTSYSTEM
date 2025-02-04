import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HospitalUI {
    public static void main(String[] args) {

        JFrame frame = new JFrame("AIUB Hospital");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);

        ImageIcon img = new ImageIcon(HospitalUI.class.getResource("NSBL.jpg"));
        JLabel backgroundlabel = new JLabel(img);
        backgroundlabel.setBounds(300,60, 1320, 950);
        frame.add(backgroundlabel);
        

        JPanel topPanel = new JPanel(null);
        topPanel.setBackground(new Color(0, 150, 255));
        topPanel.setBounds(0, 0, 1920, 60);
        frame.add(topPanel);

        JLabel contactLabel = new JLabel(" 10666  |  International: +880 2-2222-66666  |  WhatsApp: +880191-2222244 , +880171-2222244");
        contactLabel.setForeground(Color.WHITE);
        contactLabel.setFont(new Font("Arial", Font.BOLD, 25));
        contactLabel.setBounds(60, 10, 1200, 40);
        topPanel.add(contactLabel);


        JTextField searchField = new JTextField("Search for your doctor...");
        searchField.setFont(new Font("Arial", Font.PLAIN, 18));
        searchField.setBounds(1200, 80, 300, 40);
        topPanel.add(searchField);

        JButton searchButton = new JButton(" Search");
        searchButton.setBounds(1520, 80, 120, 40);
        searchButton.setFont(new Font("Arial", Font.BOLD, 18));
        topPanel.add(searchButton);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String doctorName = searchField.getText().trim();
                if (!doctorName.isEmpty()) {
                    searchField.setText("Showing results for: " + doctorName);
                } else {
                    searchField.setText("Please enter a doctor's name...");
                }
            }
        });

        JLabel clockLabel = new JLabel();
        clockLabel.setForeground(Color.WHITE);
        clockLabel.setFont(new Font("Arial", Font.BOLD, 25));
        clockLabel.setBounds(1700, 5, 300, 50);
        topPanel.add(clockLabel);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss a");
                String time = formatter.format(new Date());
                clockLabel.setText(time);
            }
        });
        timer.start();

        JPanel leftPanel = new JPanel(null);
        leftPanel.setBackground(new Color(240, 235, 221));
        leftPanel.setBounds(0, 60, 300, 1020);
        frame.add(leftPanel);

        JButton findDoctorButton = new JButton("Find Doctor");
        setButtonStyle(findDoctorButton);
        findDoctorButton.setBounds(25, 200, 250, 80);
        leftPanel.add(findDoctorButton);
        findDoctorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DoctorHierarchy d = new DoctorHierarchy();
            }
        });

        JButton bookAppointmentButton = new JButton("Book Appointment");
        setButtonStyle(bookAppointmentButton);
        bookAppointmentButton.setBounds(25, 300, 250, 80);
        leftPanel.add(bookAppointmentButton);
        bookAppointmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MakeAppointmentForm m = new MakeAppointmentForm();
            }
        });

        JButton adminButton = new JButton("Admin");
        setButtonStyle(adminButton);
        adminButton.setBounds(25, 400, 250, 80);
        leftPanel.add(adminButton);
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin a = new Admin();
            }
        });

        JButton receptionistButton = new JButton("Receptionist");
        setButtonStyle(receptionistButton);
        receptionistButton.setBounds(25, 500, 250, 80);
        leftPanel.add(receptionistButton);
        receptionistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Receptionist r = new Receptionist();;
            }
        });

        JPanel centerPanel = new JPanel(null);
        centerPanel.setBounds(300, 60, 1320, 1020);
        frame.add(centerPanel);

        JPanel rightPanel = new JPanel(null);
        rightPanel.setBackground(new Color(240, 235, 221));
        rightPanel.setBounds(1620, 60, 300, 1020);
        frame.add(rightPanel);

        JButton callButton = new JButton(" Emergency Call");
        setButtonStyle(callButton);
        callButton.setBackground(new Color(34, 177, 76));
        callButton.setBounds(25, 200, 250, 80);
        rightPanel.add(callButton);

        JButton departmentButton = new JButton("Departments");
        setButtonStyle(departmentButton);
        departmentButton.setBackground(new Color(0, 102, 204));
        departmentButton.setBounds(25, 600, 250, 80);

        departmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame departmentFrame = new JFrame("Departments");
                departmentFrame.setSize(1500,900);
                departmentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                ImageIcon img = new ImageIcon(HospitalUI.class.getResource("department.png"));
                JLabel backgroundlabel1 = new JLabel(img);
                backgroundlabel1.setBounds(300,60, 1320, 950);
                departmentFrame.add(backgroundlabel1);

                departmentFrame.setVisible(true);
                departmentFrame.setLocationRelativeTo(null);
            }
        });

        rightPanel.add(departmentButton);



        JButton alertButton = new JButton(" Ambulance");
        setButtonStyle(alertButton);
        alertButton.setBackground(new Color(204, 100, 0));
        alertButton.setBounds(25, 400, 250, 80);
        rightPanel.add(alertButton);
        alertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmergencyTransferForm t = new EmergencyTransferForm();
            }
        });

        frame.setVisible(true);
    }
    private static void setButtonStyle(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setBackground(new Color(189, 155, 91));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
    }
}
