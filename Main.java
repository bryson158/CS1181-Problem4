import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args){
        panel();
    }

    public static void panel(){
        JFrame frame = new JFrame("Temperature Converter");
        JPanel panel = new JPanel();

        //Panel layout
        panel.setLayout(new GridLayout(3, 2));

        //Creates the components needed to add to the grid
        JLabel label = new JLabel("Fahrenheit");
        JTextField fahrenheitTextbox = new JTextField("");
        JButton convertButton = new JButton("Convert");
        JLabel celsiusLabel = new JLabel("Celsius");
        JTextField celsiusTextbox = new JTextField("");

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double fahrenheit = 0;
                double celsius = 0;
                //Determines if the user entered a valid number and converts the value to either celsius or fahrenheit
                if(fahrenheitTextbox.getText().length() > 0){
                    try {
                        fahrenheit = Double.parseDouble(fahrenheitTextbox.getText());

                        celsius = (fahrenheit - 32) * (5/9);
                        String temp = String.valueOf(celsius);
                        System.out.println(temp);
                        System.out.println(celsius);

                        celsiusTextbox.setText(String.valueOf(temp));
                    }
                    catch (NumberFormatException ee){
                        fahrenheitTextbox.setText("Please enter a number");
                    }
                }
                else {
                    try {
                       celsius = Double.parseDouble(celsiusTextbox.getText());

                       fahrenheit = (celsius * (9/5)) + 52;

                       fahrenheitTextbox.setText(String.valueOf(fahrenheit));
                    }
                    catch (NumberFormatException ee){
                        celsiusTextbox.setText("Please enter a valid number");

                    }
                }
            }
        });

        //adds all the components to the panel
        panel.add(label);
        panel.add(celsiusLabel);
        panel.add(fahrenheitTextbox);
        panel.add(celsiusTextbox);
        panel.add(convertButton);

        //Frame settings
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
