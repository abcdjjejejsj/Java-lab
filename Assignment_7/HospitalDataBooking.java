import java.applet.Applet;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class HospitalDataBooking extends Applet implements ActionListener, ItemListener {
   TextField nameField;
   TextField ageField;
   TextField phoneField;
   TextField symptomsField;
   Choice departmentChoice;
   Choice appointmentTimeChoice;
   Button submitButton;
   Button clearButton;
   String selectedDepartment = "";
   String selectedAppointmentTime = "";
   Image backgroundImage;

   public HospitalDataBooking() {
   }

   public void init() {
      this.setLayout((LayoutManager)null);
      this.setBackground(new Color(204, 255, 204));
      this.backgroundImage = this.getImage(this.getCodeBase(), "hospital.jpg");
      
      // Labels
      Label nameLabel = new Label("Name:");
      Label ageLabel = new Label("Age:");
      Label phoneLabel = new Label("Phone:");
      Label departmentLabel = new Label("Department:");
      Label appointmentTimeLabel = new Label("Appointment Time:");
      Label symptomsLabel = new Label("Symptoms:");

      // Text Fields
      this.nameField = new TextField(20);
      this.ageField = new TextField(20);
      this.phoneField = new TextField(20);
      this.symptomsField = new TextField(20);

      // Choices for department and appointment time
      this.departmentChoice = new Choice();
      this.departmentChoice.add("Select Department");
      this.departmentChoice.add("Cardiology");
      this.departmentChoice.add("Neurology");
      this.departmentChoice.add("Orthopedics");
      this.departmentChoice.add("Pediatrics");
      
      this.appointmentTimeChoice = new Choice();
      this.appointmentTimeChoice.add("Select Time");
      this.appointmentTimeChoice.add("Morning");
      this.appointmentTimeChoice.add("Afternoon");
      this.appointmentTimeChoice.add("Evening");

      // Buttons
      this.submitButton = new Button("Book Appointment");
      this.clearButton = new Button("Clear");
      this.submitButton.setBackground(new Color(135, 206, 235));
      this.clearButton.setBackground(new Color(255, 165, 0));

      // Setting Layout and Positioning
      nameLabel.setBounds(100, 80, 120, 30);
      this.nameField.setBounds(240, 80, 200, 30);
      ageLabel.setBounds(100, 130, 120, 30);
      this.ageField.setBounds(240, 130, 200, 30);
      phoneLabel.setBounds(100, 180, 120, 30);
      this.phoneField.setBounds(240, 180, 200, 30);
      departmentLabel.setBounds(100, 230, 120, 30);
      this.departmentChoice.setBounds(240, 230, 200, 30);
      symptomsLabel.setBounds(100, 280, 120, 30);
      this.symptomsField.setBounds(240, 280, 200, 30);
      appointmentTimeLabel.setBounds(100, 330, 120, 30);
      this.appointmentTimeChoice.setBounds(240, 330, 200, 30);
      this.submitButton.setBounds(160, 400, 120, 40);
      this.clearButton.setBounds(300, 400, 100, 40);
      
      // Adding components
      this.add(nameLabel);
      this.add(this.nameField);
      this.add(ageLabel);
      this.add(this.ageField);
      this.add(phoneLabel);
      this.add(this.phoneField);
      this.add(departmentLabel);
      this.add(this.departmentChoice);
      this.add(symptomsLabel);
      this.add(this.symptomsField);
      this.add(appointmentTimeLabel);
      this.add(this.appointmentTimeChoice);
      this.add(this.submitButton);
      this.add(this.clearButton);

      // Listeners for buttons and choices
      this.submitButton.addActionListener(this);
      this.clearButton.addActionListener(this);
      this.departmentChoice.addItemListener(this);
      this.appointmentTimeChoice.addItemListener(this);
   }

   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == this.submitButton) {
         this.showDialog();
      } else if (e.getSource() == this.clearButton) {
         this.clearForm();
      }
   }

   public void itemStateChanged(ItemEvent e) {
      this.selectedDepartment = this.departmentChoice.getSelectedItem();
      this.selectedAppointmentTime = this.appointmentTimeChoice.getSelectedItem();
   }

   private void showDialog() {
      String name = this.nameField.getText();
      String age = this.ageField.getText();
      String phone = this.phoneField.getText();
      String symptoms = this.symptomsField.getText();

      if (name.isEmpty() || age.isEmpty() || phone.isEmpty() || symptoms.isEmpty() || 
          this.selectedDepartment.equals("Select Department") || this.selectedAppointmentTime.equals("Select Time")) {
         showErrorDialog("All fields are required. Please fill in all fields.");
         return;
      }

      Dialog dialog = new Dialog((Frame)null, "Appointment Details", true);
      dialog.setLayout(new GridLayout(7, 1));
      dialog.setSize(400, 300);
      dialog.add(new Label("Appointment Booked Successfully!"));
      dialog.add(new Label("Name: " + name));
      dialog.add(new Label("Age: " + age));
      dialog.add(new Label("Phone: " + phone));
      dialog.add(new Label("Department: " + this.selectedDepartment));
      dialog.add(new Label("Appointment Time: " + this.selectedAppointmentTime));
      dialog.add(new Label("Symptoms: " + symptoms));

      Button okButton = new Button("OK");
      okButton.addActionListener((e) -> dialog.setVisible(false));
      dialog.add(okButton);
      dialog.setLocation(300, 300);
      dialog.setVisible(true);
   }

   private void showErrorDialog(String message) {
      Dialog errorDialog = new Dialog((Frame)null, "Input Error", true);
      errorDialog.setLayout(new GridLayout(2, 1));
      errorDialog.setSize(300, 150);
      errorDialog.add(new Label(message));
      Button okButton = new Button("OK");
      okButton.addActionListener((e) -> errorDialog.setVisible(false));
      errorDialog.add(okButton);
      errorDialog.setLocation(350, 350);
      errorDialog.setVisible(true);
   }

   private void clearForm() {
      this.nameField.setText("");
      this.ageField.setText("");
      this.phoneField.setText("");
      this.symptomsField.setText("");
      this.departmentChoice.select(0);
      this.appointmentTimeChoice.select(0);
      this.repaint();
   }

   public void paint(Graphics g) {
      if (this.backgroundImage != null) {
         g.drawImage(this.backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
      }

      g.setColor(new Color(144, 238, 144));
      g.setFont(new Font("Serif", Font.BOLD, 18));
      g.drawString("Hospital Appointment Booking System", 180, 50);
   }
}
