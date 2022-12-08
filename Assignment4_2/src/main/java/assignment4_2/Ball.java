package assignment4_2;

/**
 *
 * @author Shamarcus Dillon
 */

public class Ball {
    
    private double hDist;
    private double vDist;
    private double hSpeed;
    private double vSpeed;
    
    public Ball() {
        this.hDist = 0;
        this.vDist = 0;
        this.hDist = 0;
        this.vSpeed = 0;
    }
    
    public void initialize(double angle, double velocity, double height) {
        this.hDist = 0;
        this.vDist = height;
        
        this.hSpeed = velocity * Math.cos(Math.toRadians(angle));
        this.vSpeed = velocity * Math.sin(Math.toRadians(angle));
    }
    
    public void update(double time) {
        this.hDist += (time * hSpeed);
        double vSpeedUpdate = this.vSpeed - (9.8 * time);
        
        this.vDist = vDist + ((this.vSpeed + vSpeedUpdate) * time/2.0);
        this.vSpeed = vSpeedUpdate;
    }
    
    public double getHDist() {
        return hDist;
    }
    
    public double getVDist() {
        return vDist;
    }
}
