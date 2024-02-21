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
    JSlider angleSlider = new JSlider(0, 90, 45);
    JTextField velocityField = new JTextField();
    JTextField secondsField = new JTextField();
    JLabel resultsLabelX = new JLabel();
    JLabel resultsLabelY = new JLabel();
    JLabel peakYresults = new JLabel();
    JLabel interceptXresults = new JLabel();


    public ProjectileFrame() {
        setSize(400, 600); //this sets the size of the window
        setTitle("Projectile Calculator"); //this sets the title which will be at the top of the GUI
        setDefaultCloseOperation(EXIT_ON_CLOSE); //this decides what will happen when you click the exit button.
        // This makes sure that it closes when you press x, otherwise it will not close when you click x

        setLayout(new GridLayout(8, 2));
        JLabel velocityLabel = new JLabel("Velocity");
        add(velocityLabel);

        add(velocityField);

        JLabel angleLabel = new JLabel("Angle");
        add(angleLabel);

        angleSlider.setPaintLabels(true);
        angleSlider.setPaintTicks(true);
        angleSlider.setPaintTrack(true);
        angleSlider.setMinorTickSpacing(1);
        angleSlider.setMajorTickSpacing(10);
        add(angleSlider);

        JLabel secondsLabel = new JLabel("Seconds");
        add(secondsLabel);
        add(secondsField);

        JLabel labelX = new JLabel("X");
        add(labelX);
        add(resultsLabelX);

        JLabel labelY = new JLabel("Y");
        add(labelY);
        add(resultsLabelY);

        JLabel peakYlabel = new JLabel("Peak Y");
        add(peakYlabel);
        add(peakYresults);

        JLabel interceptXlabel = new JLabel("Intercept X");
        add(interceptXlabel);
        add(interceptXresults);

        JLabel emptySpace = new JLabel();
        add(emptySpace);

        JButton calculateButton = new JButton("Calculate");
        add(calculateButton);


        angleSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateInfo();
            }
        });

        secondsField.getDocument().addDocumentListener(new SimpleDocumentListener() {
            public void update(DocumentEvent e) {
                updateInfo();
            }
        });

        velocityField.getDocument().addDocumentListener(new SimpleDocumentListener() {
            @Override
            public void update(DocumentEvent e) {
                updateInfo();
            }
        });


        //an action listener does something when the button is clicked
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Projectile projectile = new Projectile(angleSlider.getValue(),
                        Double.parseDouble(velocityField.getText()));
                projectile.setSeconds(Double.parseDouble(secondsField.getText()));

                resultsLabelX.setText(Double.toString(projectile.getX()));
                resultsLabelY.setText(Double.toString(projectile.getY()));
                peakYresults.setText(Double.toString(projectile.getPeakY()));
                interceptXresults.setText(Double.toString(projectile.getInterceptX()));
            }
        });

    }

    private void updateInfo() {
        try {
            Projectile projectile = new Projectile(angleSlider.getValue(),
                    Double.parseDouble(velocityField.getText()));
            projectile.setSeconds(Double.parseDouble(secondsField.getText()));

            resultsLabelX.setText(Double.toString(projectile.getX()));
            resultsLabelY.setText(Double.toString(projectile.getY()));
            peakYresults.setText(Double.toString(projectile.getPeakY()));
            interceptXresults.setText(Double.toString(projectile.getInterceptX()));
        } catch (NumberFormatException exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ProjectileFrame frame = new ProjectileFrame();
        frame.setVisible(true); //that means that you can see it
    }


}