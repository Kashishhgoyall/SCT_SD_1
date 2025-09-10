import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// GUI-based Temperature Converter using Swing
public class TempConvertGUI extends JFrame {
    private JComboBox<String> fromBox, toBox; // Dropdowns for units
    private JTextField inputField;            // Text field for input
    private JLabel resultLabel;               // Label to show result

    // Constructor: sets up the GUI
    public TempConvertGUI() {
        setTitle("Temperature Converter");  // Window title
        setSize(400, 200);                  // Window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10)); // 4 rows, 2 cols, spacing = 10px

        // Units available for conversion
        String[] units = {"Celsius", "Fahrenheit", "Kelvin"};

        fromBox = new JComboBox<>(units); // "From" unit dropdown
        toBox = new JComboBox<>(units);   // "To" unit dropdown
        inputField = new JTextField();    // User input field
        resultLabel = new JLabel("Result: ", JLabel.CENTER); // Result display

        JButton convertBtn = new JButton("Convert"); // Button to perform conversion

        // Add components to window
        add(new JLabel("From:"));
        add(fromBox);
        add(new JLabel("To:"));
        add(toBox);
        add(new JLabel("Value:"));
        add(inputField);
        add(convertBtn);
        add(resultLabel);

        // Action when Convert button is clicked
        convertBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get user input
                    double input = Double.parseDouble(inputField.getText());
                    String from = (String) fromBox.getSelectedItem();
                    String to = (String) toBox.getSelectedItem();

                    // Perform conversion
                    double result = convertTemperature(input, from, to);

                    // Show result
                    resultLabel.setText("Result: " + result);
                } catch (Exception ex) {
                    // Handle invalid input
                    JOptionPane.showMessageDialog(null, "Invalid input!");
                }
            }
        });

        setVisible(true); // Show window
    }

    // Conversion logic
    private double convertTemperature(double value, String from, String to) {
        if (from.equals(to)) return value; // If same units → return same value

        switch (from + "->" + to) {
            case "Celsius->Fahrenheit": return (value * 9/5) + 32;
            case "Celsius->Kelvin": return value + 273.15;
            case "Fahrenheit->Celsius": return (value - 32) * 5/9;
            case "Fahrenheit->Kelvin": return (value - 32) * 5/9 + 273.15;
            case "Kelvin->Celsius": return value - 273.15;
            case "Kelvin->Fahrenheit": return (value - 273.15) * 9/5 + 32;
        }
        return value;
    }

    // Main method to launch the GUI
    public static void main(String[] args) {
        new TempConvertGUI();
    }
}
