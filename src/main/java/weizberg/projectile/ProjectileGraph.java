package weizberg.projectile;

import javax.swing.*;
import java.awt.*;

public class ProjectileGraph extends JComponent {
    private Projectile projectile = new Projectile(0, 0);

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //this moves the origin
        g.translate(0, getHeight());
        //to move the origin to the middle of the screen then do getWidth/2 and getHeight/2


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
        g.setColor(Color.red);
        g.fillOval((int)projectile.getInterceptX() / 2, (int) - projectile.getPeakY(), 10, 10);


    }

    public void setProjectile(Projectile projectile) {
        this.projectile = projectile;

        //this tells the operating system to call paintComponent again
        repaint();
    }
}
