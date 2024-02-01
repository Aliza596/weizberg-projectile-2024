package weizberg.projectile;

public class Projectile {
    private final double angle;
    private final double radians;
    private final double velocity;
    private double seconds;

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
        return Math.sin(radians) * velocity * seconds -
                .5 * 9.8 * seconds * seconds;
    }

    public double getApexTime() {
        //starting velocity in the y direction divided by gravity
        //velocity = velocity * sin(degress)
        double velocityOriginal = velocity * Math.sin(radians);
        return velocityOriginal / 9.8;
    }


}

