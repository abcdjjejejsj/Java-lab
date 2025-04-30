import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class HospitalManagement extends JFrame {

    JTextField tfId, tfName, tfAge, tfGender, tfDiagnosis;
    JTextArea taDisplay;

    public HospitalManagement() {
        setTitle("Hospital Management System");
        setSize(600, 600);
        setLayout(new FlowLayout());

        tfId = new JTextField(5);
        tfName = new JTextField(15);
        tfAge = new JTextField(3);
        tfGender = new JTextField(10);
        tfDiagnosis = new JTextField(20);
        taDisplay = new JTextArea(20, 50);

        add(new JLabel("ID:")); add(tfId);
        add(new JLabel("Name:")); add(tfName);
        add(new JLabel("Age:")); add(tfAge);
        add(new JLabel("Gender:")); add(tfGender);
        add(new JLabel("Diagnosis:")); add(tfDiagnosis);

        JButton btnAdd = new JButton("Add");
        JButton btnView = new JButton("View All");
        JButton btnUpdate = new JButton("Update");
        JButton btnDelete = new JButton("Delete");

        add(btnAdd); add(btnView); add(btnUpdate); add(btnDelete);
        add(new JScrollPane(taDisplay));

        btnAdd.addActionListener(e -> addPatient());
        btnView.addActionListener(e -> viewPatients());
        btnUpdate.addActionListener(e -> updatePatient());
        btnDelete.addActionListener(e -> deletePatient());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    void addPatient() {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO patients (name, age, gender, diagnosis) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tfName.getText());
            ps.setInt(2, Integer.parseInt(tfAge.getText()));
            ps.setString(3, tfGender.getText());
            ps.setString(4, tfDiagnosis.getText());

            // Debugging: print the query being executed
            System.out.println("Executing query: " + ps);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Patient Added!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void viewPatients() {
        taDisplay.setText("");
        try (Connection conn = DBConnection.getConnection()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM patients");

            // Debugging: print the query being executed
            System.out.println("Executing query: SELECT * FROM patients");

            while (rs.next()) {
                taDisplay.append("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Age: " + rs.getInt("age") +
                        ", Gender: " + rs.getString("gender") +
                        ", Diagnosis: " + rs.getString("diagnosis") + "\n");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void updatePatient() {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE patients SET name=?, age=?, gender=?, diagnosis=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tfName.getText());
            ps.setInt(2, Integer.parseInt(tfAge.getText()));
            ps.setString(3, tfGender.getText());
            ps.setString(4, tfDiagnosis.getText());
            ps.setInt(5, Integer.parseInt(tfId.getText()));

            // Debugging: print the query being executed
            System.out.println("Executing query: " + ps);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Patient Updated!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void deletePatient() {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM patients WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(tfId.getText()));

            // Debugging: print the query being executed
            System.out.println("Executing query: " + ps);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Patient Deleted!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Create and display the form
        new HospitalManagement();
    }
}
