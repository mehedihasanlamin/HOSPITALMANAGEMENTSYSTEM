import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorHierarchy extends JFrame {

    private JPanel mainPanel;
    private JLabel headDoctorLabel;
    private JPanel doctorsPanel;

    private List<Doctor> doctors;

    public DoctorHierarchy() {
        setTitle("Doctor Hierarchy");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Fullscreen mode
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        doctors = new ArrayList<>();
        doctors.add(new Doctor("Dr. Radi", "Cardiology", "222-333-4444", "radi.jpg", "MBBS, MD", "12", "Heart Hospital"));
        doctors.add(new Doctor("Dr. Asif", "Orthopedics", "555-444-3333", "asif.png", "MBBS, MS", "10", "Bone Care Clinic"));
        doctors.add(new Doctor("Dr. Emon", "General Surgeon", "111-888-9999", "emon.jpeg", "MBBS, FRCS", "15", "Surgical Hospital"));
        doctors.add(new Doctor("Dr. Joy", "Neurology", "777-666-5555", "joy.jpg", "MBBS, MD", "10", "Neurology Clinic"));
        doctors.add(new Doctor("Dr. Sanjida", "Pediatrics", "888-777-6666", "sanjida.jpg", "MBBS", "8", "Children's Care"));
        doctors.add(new Doctor("Dr. Rahman", "Orthopedics", "999-888-7777", "rahman.jpg", "MBBS, MS", "12", "Joint Hospital"));
        doctors.add(new Doctor("Dr. Hedayet", "Orthopedics", "111-222-5555", "hedayet.jpg", "MBBS, MS", "8", "Bone & Joint Clinic"));
        doctors.add(new Doctor("Dr. Mehedi", "Gastroenterology", "222-111-5555", "mehedi.jpg", "MBBS, MD", "10", "Digestive Care"));
        doctors.add(new Doctor("Dr. Sizan", "Gastroenterology", "333-222-1111", "sizan.jpg", "MBBS, MD", "9", "Gastro Clinic"));
        doctors.add(new Doctor("Dr. Faiyaz", "Endocrinology", "444-333-2222", "faiyaz.jpg", "MBBS, MD", "12", "Hormone Clinic"));
        doctors.add(new Doctor("Dr. Farhan", "Endocrinology", "555-444-1111", "farhan.jpg", "MBBS, MD", "8", "Diabetes Care"));
        doctors.add(new Doctor("Dr. Mifty", "Ophthalmology", "666-555-3333", "mifty.jpg", "MBBS, MS", "10", "Eye Specialist"));
        doctors.add(new Doctor("Dr. Hasan", "Ophthalmology", "777-666-4444", "hasan.jpg", "MBBS, MS", "9", "Vision Clinic"));
        doctors.add(new Doctor("Dr. Jafrin", "Psychiatry", "888-777-5555", "jafrin.jpg", "MBBS, MD", "15", "Mental Health Clinic"));
        doctors.add(new Doctor("Dr. Joy", "Psychiatry", "999-888-6666", "joy2.jpg", "MBBS, MD", "12", "Mind Care Clinic"));
        doctors.add(new Doctor("Dr. Tasneem", "General Medicine", "111-999-8888", "tasneem.jpg", "MBBS", "10", "General Clinic"));
        doctors.add(new Doctor("Dr. Asifa", "General Medicine", "222-111-8888", "asifa.jpg", "MBBS", "8", "Family Clinic"));
        doctors.add(new Doctor("Dr. Lamin", "Cardiology", "123-456-7890", "lamin.jpeg", "MBBS, DLO", "6", "ENT Hospital"));
        doctors.add(new Doctor("Dr. Nazia", "Gynecologist", "000-111-2222", "nazia.png", "MBBS, MD", "14", "Women’s Hospital"));


        JPanel headDoctorPanel = createHeadDoctorPanel();
        add(headDoctorPanel, BorderLayout.NORTH);  // Add head doctor panel to the top of the frame


        int numRows = (doctors.size() + 2) / 3;
        doctorsPanel = new JPanel(new GridLayout(numRows, 3, 10, 10));
        doctorsPanel.setBackground(new Color(240, 240, 240));
        for (Doctor doctor : doctors) {
            doctorsPanel.add(createDoctorPanel(doctor));
        }
        JScrollPane scrollPane = new JScrollPane(doctorsPanel);
        add(scrollPane, BorderLayout.CENTER);


        getContentPane().setBackground(new Color(240, 240, 240)); // Light background color for the whole frame

        setVisible(true);
    }

    private JPanel createHeadDoctorPanel() {
        JPanel headDoctorPanel = new JPanel();
        headDoctorPanel.setLayout(new BoxLayout(headDoctorPanel, BoxLayout.Y_AXIS));
        headDoctorPanel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 255), 3)); // Blue border for Head Doctor box
        headDoctorPanel.setPreferredSize(new Dimension(350, 240));  // Set the height to 240 pixels, width 350
        headDoctorPanel.setMaximumSize(new Dimension(350, 240));  // Maximum height for consistency
        headDoctorPanel.setAlignmentX(Component.CENTER_ALIGNMENT);  // Center alignment for the box
        headDoctorPanel.setBackground(new Color(240, 240, 240));  // Light background for Head Doctor box
        headDoctorPanel.setOpaque(true); // Ensure panel background color is visible


        ImageIcon imageIcon = new ImageIcon("headdoctor.jpg");  // Add your head doctor image path here
        JLabel imageLabel;
        if (imageIcon.getImageLoadStatus() == MediaTracker.COMPLETE) {
            Image scaledImage = imageIcon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);  // Resize image
            imageLabel = new JLabel(new ImageIcon(scaledImage));
        } else {
            imageLabel = new JLabel("No Image Found");
            imageLabel.setFont(new Font("Arial", Font.BOLD, 16));
        }


        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        JLabel nameLabel = new JLabel("Dr. Raihan Mahmud");
        JLabel positionLabel = new JLabel("Chief Surgeon");
        JLabel phoneLabel = new JLabel("Phone: 555-555-5555");
        JLabel emailLabel = new JLabel("Email: raimahmud@hospital.com");
        JLabel experienceLabel = new JLabel("Experience: 25 Years");
        JLabel hospitalLabel = new JLabel("Hospital: General Hospital");
        JLabel qualificationsLabel = new JLabel("Qualifications: MBBS, MD, FACS");

        // Set font size to 22 for all labels
        Font font = new Font("Arial", Font.PLAIN, 22);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 24));
        positionLabel.setFont(font);
        phoneLabel.setFont(font);
        emailLabel.setFont(font);
        experienceLabel.setFont(font);
        hospitalLabel.setFont(font);
        qualificationsLabel.setFont(font);


        infoPanel.add(nameLabel);
        infoPanel.add(positionLabel);
        infoPanel.add(phoneLabel);
        infoPanel.add(emailLabel);
        infoPanel.add(experienceLabel);
        infoPanel.add(hospitalLabel);
        infoPanel.add(qualificationsLabel);

        headDoctorPanel.add(imageLabel);
        headDoctorPanel.add(Box.createVerticalStrut(15));
        headDoctorPanel.add(infoPanel);

        return headDoctorPanel;
    }

    private JPanel createDoctorPanel(Doctor doctor) {
        JPanel doctorPanel = new JPanel();
        doctorPanel.setLayout(new BoxLayout(doctorPanel, BoxLayout.Y_AXIS));
        doctorPanel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 1));
        doctorPanel.setBackground(Color.WHITE);
        doctorPanel.setPreferredSize(new Dimension(300, 250));

        ImageIcon imageIcon = new ImageIcon(doctor.getImagePath());
        JLabel imageLabel;
        if (imageIcon.getImageLoadStatus() == MediaTracker.COMPLETE) {
            Image scaledImage = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            imageLabel = new JLabel(new ImageIcon(scaledImage));
        } else {
            imageLabel = new JLabel("No Image Found");
            imageLabel.setFont(new Font("Arial", Font.BOLD, 20));
        }
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the image


        JLabel nameLabel = new JLabel(doctor.getName());
        JLabel specializationLabel = new JLabel(doctor.getSpecialization());
        JLabel phoneLabel = new JLabel("Phone: " + doctor.getPhone());
        JLabel experienceLabel = new JLabel("Experience: " + doctor.getExperience() + " Years");
        JLabel hospitalLabel = new JLabel("Hospital: " + doctor.getHospital());


        Font font = new Font("Arial", Font.PLAIN, 25);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 27));
        specializationLabel.setFont(font);
        phoneLabel.setFont(font);
        experienceLabel.setFont(font);
        hospitalLabel.setFont(font);


        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        specializationLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        phoneLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        experienceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        hospitalLabel.setAlignmentX(Component.CENTER_ALIGNMENT);


        doctorPanel.add(Box.createVerticalStrut(10)); // Add some space at the top
        doctorPanel.add(imageLabel);
        doctorPanel.add(Box.createVerticalStrut(10)); // Space between image and name
        doctorPanel.add(nameLabel);
        doctorPanel.add(specializationLabel);
        doctorPanel.add(phoneLabel);
        doctorPanel.add(experienceLabel);
        doctorPanel.add(hospitalLabel);

        return doctorPanel;
    }

    public static void main(String[] args) {
        new DoctorHierarchy();
    }
}

class Doctor {
    private String name;
    private String specialization;
    private String phone;
    private String imagePath;
    private String qualifications;
    private String experience;
    private String hospital;

    public Doctor(String name, String specialization, String phone, String imagePath, String qualifications, String experience, String hospital) {
        this.name = name;
        this.specialization = specialization;
        this.phone = phone;
        this.imagePath = imagePath;
        this.qualifications = qualifications;
        this.experience = experience;
        this.hospital = hospital;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getPhone() {
        return phone;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getQualifications() {
        return qualifications;
    }

    public String getExperience() {
        return experience;
    }

    public String getHospital() {
        return hospital;
    }
}