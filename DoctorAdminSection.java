import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

class Shift {
    private String shiftType;
    private Date startTime;
    private Date endTime;
    private String[] days;

    public Shift(String shiftType, Date startTime, Date endTime, String[] days) {
        this.shiftType = shiftType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.days = days;
    }

    public String getShiftType() {
        return shiftType;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public String[] getDays() {
        return days;
    }
}

public class DoctorAdminSection extends JFrame {

    private Map<String, String> doctorCredentials;
    private Map<String, Shift> doctorShifts;
    private JPanel loginPanel;
    private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

    public DoctorAdminSection() {
        setTitle("Hospital Management System - Doctor Admin Section");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 450);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        doctorCredentials = new HashMap<>();
        doctorShifts = new HashMap<>();

        addDoctor("Dr. Lamin", "password1", "Day Shift", "08:00:00", "16:00:00", new String[]{"Sunday", "Monday"});
        addDoctor("Dr. Nazia", "password2", "Night Shift", "20:00:00", "04:00:00", new String[]{"Tuesday", "Wednesday"});
        addDoctor("Dr. Bushra", "password3", "Day Shift", "08:00:00", "16:00:00", new String[]{"Thursday", "Sunday"});
        addDoctor("Dr. Asif", "password4", "Night Shift", "20:00:00", "04:00:00", new String[]{"Monday", "Tuesday"});
        addDoctor("Dr. Emon", "password5", "Day Shift", "08:00:00", "16:00:00", new String[]{"Wednesday", "Thursday"});
        addDoctor("Dr. Joy", "password6", "Night Shift", "20:00:00", "04:00:00", new String[]{"Sunday", "Tuesday"});
        addDoctor("Dr. Radi", "password7", "Day Shift", "08:00:00", "16:00:00", new String[]{"Monday", "Wednesday"});
        addDoctor("Dr. Sanjida", "password8", "Night Shift", "20:00:00", "04:00:00", new String[]{"Tuesday", "Thursday"});
        addDoctor("Dr. Rahman", "password9", "Day Shift", "08:00:00", "16:00:00", new String[]{"Wednesday", "Sunday"});
        addDoctor("Dr. Hedayet", "password10", "Night Shift", "20:00:00", "04:00:00", new String[]{"Thursday", "Monday"});
        addDoctor("Dr. Mehedi", "password11", "Day Shift", "08:00:00", "16:00:00", new String[]{"Sunday", "Tuesday"});
        addDoctor("Dr. Sizan", "password12", "Night Shift", "20:00:00", "04:00:00", new String[]{"Wednesday", "Thursday"});
        addDoctor("Dr. Faiyaz", "password13", "Day Shift", "08:00:00", "16:00:00", new String[]{"Monday", "Thursday"});
        addDoctor("Dr. Farhan", "password14", "Night Shift", "20:00:00", "04:00:00", new String[]{"Tuesday", "Sunday"});
        addDoctor("Dr. Mifty", "password15", "Day Shift", "08:00:00", "16:00:00", new String[]{"Wednesday", "Monday"});
        addDoctor("Dr. Hasan", "password16", "Night Shift", "20:00:00", "04:00:00", new String[]{"Thursday", "Tuesday"});
        addDoctor("Dr. Jafrin", "password17", "Day Shift", "08:00:00", "16:00:00", new String[]{"Sunday", "Wednesday"});
        addDoctor("Dr. Joy", "password18", "Night Shift", "20:00:00", "04:00:00", new String[]{"Monday", "Thursday"});
        addDoctor("Dr. Tasneem", "password19", "Day Shift", "08:00:00", "16:00:00", new String[]{"Tuesday", "Wednesday"});
        addDoctor("Dr. Asifa", "password20", "Night Shift", "20:00:00", "04:00:00", new String[]{"Thursday", "Sunday"});

        loginPanel = createLoginPanel();
        add(loginPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void addDoctor(String name, String password, String shiftType, String startTime, String endTime, String[] days) {
        doctorCredentials.put(name, password);
        try {
            Date startTimeDate = timeFormat.parse(startTime);
            Date endTimeDate = timeFormat.parse(endTime);

            if (endTimeDate.before(startTimeDate)) {
                endTimeDate = new Date(endTimeDate.getTime() + 24 * 60 * 60 * 1000);
            }

            doctorShifts.put(name, new Shift(shiftType, startTimeDate, endTimeDate, days));
        } catch (ParseException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error parsing time for " + name + ". Using default times.");
            doctorShifts.put(name, new Shift(shiftType, null, null, new String[]{}));
        }
    }

    private JPanel createLoginPanel() {
        JPanel loginPanel = new JPanel(new GridBagLayout());
        loginPanel.setBackground(new Color(240, 248, 255));
        loginPanel.setBorder(BorderFactory.createTitledBorder("Doctor Login"));
        loginPanel.setFont(new Font("Arial", Font.PLAIN, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        loginPanel.add(usernameLabel, gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField usernameField = new JTextField(15);
        usernameField.setFont(new Font("Arial", Font.PLAIN, 25));
        loginPanel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        loginPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JPasswordField passwordField = new JPasswordField(15);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 25));
        loginPanel.add(passwordField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.PLAIN, 25));
        loginButton.setBackground(new Color(34, 139, 34));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setBorderPainted(false);
        loginPanel.add(loginButton, gbc);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (doctorCredentials.containsKey(username) && doctorCredentials.get(username).equals(password)) {
                showDoctorDashboard(username);
            } else {
                JOptionPane.showMessageDialog(DoctorAdminSection.this, "Invalid username or password.");
            }
        });
        return loginPanel;
    }

    private void showDoctorDashboard(String username) {
        getContentPane().removeAll();
        JPanel dashboardPanel = new JPanel(new BorderLayout());
        dashboardPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel welcomeLabel = new JLabel("Welcome, " + username + "!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        welcomeLabel.setForeground(new Color(0, 128, 128));
        topPanel.add(welcomeLabel);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setFont(new Font("Arial", Font.PLAIN, 25));
        logoutButton.setBackground(new Color(255, 99, 71));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setFocusPainted(false);
        logoutButton.setBorderPainted(false);
        logoutButton.addActionListener(e -> {
            getContentPane().removeAll();
            add(loginPanel, BorderLayout.CENTER);
            revalidate();
            repaint();
        });
        topPanel.add(logoutButton);
        dashboardPanel.add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(2, 1));
        centerPanel.setBorder(BorderFactory.createTitledBorder("Doctor's Panel"));
        Shift shift = doctorShifts.get(username);
        JLabel shiftLabel;

        if (shift != null && shift.getStartTime() != null && shift.getEndTime() != null) {
            String days = String.join(", ", shift.getDays());
            shiftLabel = new JLabel("Your Shift: " + shift.getShiftType() + " (" +
                    timeFormat.format(shift.getStartTime()) + " - " +
                    timeFormat.format(shift.getEndTime()) + ") on " + days);
        } else {
            shiftLabel = new JLabel("Shift information not available.");
        }
        shiftLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        shiftLabel.setForeground(new Color(0, 0, 128));
        centerPanel.add(shiftLabel);

        dashboardPanel.add(centerPanel, BorderLayout.CENTER);

        add(dashboardPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DoctorAdminSection());
    }
}
