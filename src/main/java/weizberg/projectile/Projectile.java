package weizberg.projectile;

public class Projectile {
    private final double angle;
    private final double radians;
    private final double velocity;
    private double seconds;
    private double initialX;
    private double tSeconds;

    public Projectile(double angle, double velocity) {
        this.angle = angle;
        this.velocity = velocity;
        this.radians = Math.toRadians(angle);
    }

    public void setSeconds(double seconds) {
        this.seconds = seconds;
    }

    public double getX() {
        return Math.cos(radians) * velocity * seconds;
    }

    public double getY() {
        return Math.sin(radians) * velocity * seconds
                - .5 * 9.8 * seconds * seconds;
    }

    public double getApexTime() {
        //starting velocity in the y direction divided by gravity
        //velocity = velocity * sin(degress)
        return (velocity * Math.sin(radians)) / 9.8;
    }

    public double getPeakY() {
        //Link where I found the formula: https://www.quora.com/How-do-I-find-the-height-of-a-projectile-with-initial-velocity-and-angle
        return (velocity * Math.sin(radians)) * (velocity * Math.sin(radians)) / (2 * 9.8);
    }


    public double getInterceptX() {
        tSeconds = -velocity / (-.5 * 9.8);
        return 0 + velocity * tSeconds;
    }

}

