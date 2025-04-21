import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

/*
<applet code="TemperatureConverterGraphics.class" width=400 height=300>
</applet>
*/

public class TemperatureConverterGraphics extends Applet implements ActionListener {
    TextField celsiusField;
    Button convertButton, clearButton;
    Label resultLabel;

    double fahrenheit = 0;
    boolean drawThermometer = false;

    public void init() {
        setLayout(new FlowLayout());

        celsiusField = new TextField(5);
        convertButton = new Button("Convert to Fahrenheit");
        clearButton = new Button("Clear");
        resultLabel = new Label("Result will appear here");

        add(new Label("Enter Celsius:"));
        add(celsiusField);
        add(convertButton);
        add(clearButton);
        add(resultLabel);

        convertButton.addActionListener(this);
        clearButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == convertButton) {
            try {
                double celsius = Double.parseDouble(celsiusField.getText());
                fahrenheit = (celsius * 9 / 5) + 32;
                resultLabel.setText("Fahrenheit: " + fahrenheit);
                drawThermometer = true;
                repaint();
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input!");
                drawThermometer = false;
                repaint();
            }
        } else if (e.getSource() == clearButton) {
            celsiusField.setText("");
            resultLabel.setText("Result will appear here");
            drawThermometer = false;
            repaint();
        }
    }

    public void paint(Graphics g) {
        if (drawThermometer) {
            // Simple thermometer bar
            g.setColor(Color.GRAY);
            g.fillRect(150, 100, 30, 100);

            g.setColor(Color.RED);
            int height = (int)(fahrenheit / 2); // scale for visual
            if (height > 100) height = 100; // limit max height
            g.fillRect(150, 200 - height, 30, height);

            g.setColor(Color.BLACK);
            g.drawString("Thermometer", 140, 90);
        }
    }
}
