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
    JLabel blankLabel = new JLabel();
    JLabel secondBlankLabel = new JLabel();
    JSlider velocitySlider = new JSlider(0, 100, 65);
    JLabel velocityValue = new JLabel();
    JSlider angleSlider = new JSlider(0, 90, 31);
    JLabel angleValue = new JLabel();
    JTextField secondsField = new JTextField();
    JLabel resultsLabelX = new JLabel();
    JLabel resultsLabelY = new JLabel();
    JLabel peakYresults = new JLabel();
    JLabel interceptXresults = new JLabel();
    ProjectileGraph graph = new ProjectileGraph();


    public ProjectileFrame() {
        setSize(800, 600); //this sets the size of the window
        setTitle("Projectile Calculator"); //this sets the title which will be at the top of the GUI
        setDefaultCloseOperation(EXIT_ON_CLOSE); //this decides what will happen when you click the exit button.
        // This makes sure that it closes when you press x, otherwise it will not close when you click x

        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());
        //tells the JFrame to use this JPanel
        setContentPane(main);

        JPanel west = new JPanel();
        main.add(west, BorderLayout.WEST);

        west.setLayout(new GridLayout(10, 2));
        JLabel velocityLabel = new JLabel("Velocity");
        west.add(velocityLabel);

        velocitySlider.setPaintLabels(true);
        velocitySlider.setPaintTicks(true);
        velocitySlider.setPaintTicks(true);
        west.add(velocitySlider);

        west.add(blankLabel);
        west.add(velocityValue);


        JLabel angleLabel = new JLabel("Angle");
        west.add(angleLabel);

        angleSlider.setPaintLabels(true);
        angleSlider.setPaintTicks(true);
        angleSlider.setPaintTrack(true);
        west.add(angleSlider);

        west.add(secondBlankLabel);
        west.add(angleValue);


        JLabel secondsLabel = new JLabel("Seconds");
        west.add(secondsLabel);
        west.add(secondsField);

        JLabel labelX = new JLabel("X");
        west.add(labelX);
        west.add(resultsLabelX);

        JLabel labelY = new JLabel("Y");
        west.add(labelY);
        west.add(resultsLabelY);

        JLabel peakYlabel = new JLabel("Peak Y");
        west.add(peakYlabel);
        west.add(peakYresults);

        JLabel interceptXlabel = new JLabel("Intercept X");
        west.add(interceptXlabel);
        west.add(interceptXresults);

        JLabel emptySpace = new JLabel();
        west.add(emptySpace);

        JButton calculateButton = new JButton("Calculate");
        west.add(calculateButton);

        velocitySlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                velocityValue.setText(Integer.toString(velocitySlider.getValue()));
                updateInfo(); // Update other info when velocity changes
            }
        });
        angleSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                angleValue.setText(Integer.toString(angleSlider.getValue()));
                updateInfo(); // Update other info when velocity changes
            }
        });


        secondsField.getDocument().addDocumentListener((SimpleDocumentListener) actionEvent -> updateInfo());


        //an action listener does something when the button is clicked
        calculateButton.addActionListener(actionEvent -> updateInfo());

        main.add(graph, BorderLayout.CENTER);

    }

    private void updateInfo() {
        try {
            Projectile projectile = new Projectile(angleSlider.getValue(),
                    velocitySlider.getValue());
            projectile.setSeconds(Double.parseDouble(secondsField.getText()));

            resultsLabelX.setText(Double.toString(projectile.getX()));
            resultsLabelY.setText(Double.toString(projectile.getY()));
            peakYresults.setText(Double.toString(projectile.getPeakY()));
            interceptXresults.setText(Double.toString(projectile.getInterceptX()));
            graph.setProjectile(projectile);
        } catch (NumberFormatException exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ProjectileFrame frame = new ProjectileFrame();
        frame.setVisible(true); //that means that you can see it
    }



}