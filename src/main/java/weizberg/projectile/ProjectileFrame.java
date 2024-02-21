package weizberg.projectile;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectileFrame extends JFrame {

    public ProjectileFrame() {
        setSize(400, 600); //this sets the size of the window
        setTitle("Projectile Calculator"); //this sets the title which will be at the top of the GUI
        setDefaultCloseOperation(EXIT_ON_CLOSE); //this decides what will happen when you click the exit button.
        // This makes sure that it closes when you press x, otherwise it will not close when you click x

        setLayout(new GridLayout(8, 2));
        JLabel velocityLabel = new JLabel("Velocity");
        JLabel angleLabel = new JLabel("Angle");
        JLabel secondsLabel = new JLabel("Seconds");
        JLabel xLabel = new JLabel("X");
        JLabel yLabel = new JLabel("Y");
        JLabel peakYLabel = new JLabel("Peak Y");
        JLabel xInterceptLabel = new JLabel("Intercept X");

        JSlider angleSlider = new JSlider(0, 90, 45);
        angleSlider.setPaintLabels(true);
        angleSlider.setPaintTicks(true);
        angleSlider.setPaintTrack(true);
        angleSlider.setMinorTickSpacing(1);
        angleSlider.setMajorTickSpacing(10);


        JTextField velocityField = new JTextField();

        JTextField secondsField = new JTextField();
        JLabel xResultsLabel = new JLabel();
        JLabel yResultsLabel = new JLabel();
        JLabel peakYResults = new JLabel();
        JLabel xInterceptResults = new JLabel();
        JLabel emptySpace = new JLabel();

        JButton calculateButton = new JButton("Calculate");


        angleSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                try {
                    Projectile projectile = new Projectile(angleSlider.getValue(),
                            Double.parseDouble(velocityField.getText()));
                    projectile.setSeconds(Double.parseDouble(secondsField.getText()));

                    xResultsLabel.setText(Double.toString(projectile.getX()));
                    yResultsLabel.setText(Double.toString(projectile.getY()));
                    peakYResults.setText(Double.toString(projectile.getPeakY()));
                    xInterceptResults.setText(Double.toString(projectile.getInterceptX()));
                } catch (NumberFormatException exception) {
                    System.out.println(exception.getMessage());
                }
            }
        });

        secondsField.getDocument().addDocumentListener(new SimpleDocumentListener() {
            public void update(DocumentEvent e) {
                try {
                    Projectile projectile = new Projectile(angleSlider.getValue(),
                            Double.parseDouble(velocityField.getText()));
                    projectile.setSeconds(Double.parseDouble(secondsField.getText()));

                    xResultsLabel.setText(Double.toString(projectile.getX()));
                    yResultsLabel.setText(Double.toString(projectile.getY()));
                    peakYResults.setText(Double.toString(projectile.getPeakY()));
                    xInterceptResults.setText(Double.toString(projectile.getInterceptX()));
                } catch (NumberFormatException exception) {
                    System.out.println(exception.getMessage());
                }
            }
        });

        velocityField.getDocument().addDocumentListener(new SimpleDocumentListener() {
            @Override
            public void update(DocumentEvent e) {
                try {
                    Projectile projectile = new Projectile(angleSlider.getValue(),
                            Double.parseDouble(velocityField.getText()));
                    projectile.setSeconds(Double.parseDouble(secondsField.getText()));

                    xResultsLabel.setText(Double.toString(projectile.getX()));
                    yResultsLabel.setText(Double.toString(projectile.getY()));
                    peakYResults.setText(Double.toString(projectile.getPeakY()));
                    xInterceptResults.setText(Double.toString(projectile.getInterceptX()));
                } catch (NumberFormatException exception) {
                    System.out.println(exception.getMessage());
                }
            }
        });




        //in order for the labels to appear on your screen you have to add them
        add(velocityLabel);
        add(velocityField);

        add(angleLabel);
        add(angleSlider);
        //add(angleField);

        add(secondsLabel);
        add(secondsField);

        add(xLabel);
        add(xResultsLabel);

        add(yLabel);
        add(yResultsLabel);

        add(peakYLabel);
        add(peakYResults);

        add(xInterceptLabel);
        add(xInterceptResults);

        add(emptySpace);
        add(calculateButton);

        //an action listener does something when the button is clicked
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Projectile projectile = new Projectile(angleSlider.getValue(),
                        Double.parseDouble(velocityField.getText()));
                projectile.setSeconds(Double.parseDouble(secondsField.getText()));

                xResultsLabel.setText(Double.toString(projectile.getX()));
                yResultsLabel.setText(Double.toString(projectile.getY()));
                peakYResults.setText(Double.toString(projectile.getPeakY()));
                xInterceptResults.setText(Double.toString(projectile.getInterceptX()));
            }
        });

    }

    public static void main(String[] args) {
        ProjectileFrame frame = new ProjectileFrame();
        frame.setVisible(true); //that means that you can see it
    }


}