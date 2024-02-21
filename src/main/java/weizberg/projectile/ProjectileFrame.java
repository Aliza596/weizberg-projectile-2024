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
        add(velocityLabel);

        JTextField velocityField = new JTextField();
        add(velocityField);

        JLabel angleLabel = new JLabel("Angle");
        add(angleLabel);

        JSlider angleSlider = new JSlider(0, 90, 45);
        angleSlider.setPaintLabels(true);
        angleSlider.setPaintTicks(true);
        angleSlider.setPaintTrack(true);
        angleSlider.setMinorTickSpacing(1);
        angleSlider.setMajorTickSpacing(10);
        add(angleSlider);

        JLabel secondsLabel = new JLabel("Seconds");
        add(secondsLabel);

        JTextField secondsField = new JTextField();
        add(secondsField);

        JLabel xLabel = new JLabel("X");
        add(xLabel);

        JLabel xResultsLabel = new JLabel();
        add(xResultsLabel);

        JLabel yLabel = new JLabel("Y");
        add(yLabel);

        JLabel yResultsLabel = new JLabel();
        add(yResultsLabel);

        JLabel peakYLabel = new JLabel("Peak Y");
        add(peakYLabel);

        JLabel peakYResults = new JLabel();
        add(peakYResults);

        JLabel xInterceptLabel = new JLabel("Intercept X");
        add(xInterceptLabel);

        JLabel xInterceptResults = new JLabel();
        add(xInterceptResults);

        JLabel emptySpace = new JLabel();
        add(emptySpace);

        JButton calculateButton = new JButton("Calculate");
        add(calculateButton);


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