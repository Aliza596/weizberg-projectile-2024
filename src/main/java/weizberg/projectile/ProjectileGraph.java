package weizberg.projectile;

import javax.sound.sampled.Port;
import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class ProjectileGraph extends JComponent {
    private Projectile projectile = new Projectile(0, 0);


    private static final DecimalFormat FORMAT = new DecimalFormat("0.00");
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        Projectile copyProjectile = new Projectile(projectile);


        //this moves the origin
        g.translate(30, getHeight() - 30);

        g.setColor(Color.LIGHT_GRAY);


        //vertical grid lines
        for (int i = 0; i <= getWidth() - 30; i += 30) {
            g.drawLine(i, 0, i, -getHeight() + 30);
        }
        //horizontal grid lines
        for (int i = 0; i <= getHeight() - 30; i += 30) {
            g.drawLine(0, -i, getWidth() - 30, -i);
        }

        //draw black lines for x and y-axis
        g.setColor(Color.BLACK);
        g.drawLine(0, 0, getWidth() - 30, 0);
        g.drawLine(0, 0, 0, -getHeight() + 30);


        g.setColor(Color.black);
        projectile.setSeconds(0);
        int currX = (int) projectile.getX();
        int currY = (int) projectile.getY();

        for (int i = 1; i <= projectile.getApexTime() * 2 + 1; i++) {
            projectile.setSeconds(i);
            int nextX = (int) projectile.getX();
            int nextY = (int) projectile.getY();
            g.drawLine(currX, -currY, nextX, -nextY);

            currX = nextX;
            currY = nextY;
        }

        //peak
        g.setColor(Color.blue);
        g.fillOval((int) projectile.getInterceptX() / 2 - 5, (int) - projectile.getPeakY() - 5, 10, 10);
        String valueX = FORMAT.format(projectile.getInterceptX() / 2);
        String valueY = FORMAT.format(projectile.getPeakY());
        g.drawString("(" + valueX + "," + valueY + ")",
                (int) projectile.getInterceptX() / 2 - 5, (int) - projectile.getPeakY() - 5);

        //seconds
        g.setColor(Color.red);
        g.fillOval((int) copyProjectile.getX() - 5, (int) -copyProjectile.getY() - 5, 10, 10);
        String secondsX = FORMAT.format(copyProjectile.getX());
        String secondsY = FORMAT.format(copyProjectile.getY());
        g.drawString("(" + secondsX + "," + secondsY + ")",
                (int) copyProjectile.getX() - 5, (int) -copyProjectile.getY() - 5);
    }



    public void setProjectile(Projectile projectile) {
        this.projectile = projectile;

        //this tells the operating system to call paintComponent again
        repaint();
    }
}
