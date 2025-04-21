import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

/*
<applet code="TemperatureConverter.class" width=300 height=200>
</applet>
*/

public class TemperatureConverter extends Applet implements ActionListener {
    TextField celsiusField;
    Button convertButton;
    Label resultLabel;

    public void init() {
        celsiusField = new TextField(5);
        convertButton = new Button("Convert to Fahrenheit");
        resultLabel = new Label("Result will appear here");

        add(new Label("Enter Celsius:"));
        add(celsiusField);
        add(convertButton);
        add(resultLabel);

        convertButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double celsius = Double.parseDouble(celsiusField.getText());
            double fahrenheit = (celsius * 9 / 5) + 32;
            resultLabel.setText("Fahrenheit: " + fahrenheit);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input!");
        }
    }
}
