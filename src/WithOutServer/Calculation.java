
package WithOutServer;

public class Calculation {
    private String fuel;
    private double MPG;
    private double distance;
    private double priceOfFuel;

    public Calculation(String fuel, double MPG, double distance, double priceOfFuel) {
        this.fuel = fuel;
        this.MPG = MPG;
        this.distance = distance;
        this.priceOfFuel = priceOfFuel;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public double getMPG() {
        return MPG;
    }

    public void setMPG(double MPG) {
        this.MPG = MPG;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getPriceOfFuel() {
        return priceOfFuel;
    }

    public void setPriceOfFuel(double priceOfFuel) {
        this.priceOfFuel = priceOfFuel;
    }
    
    public double quickMaths(){
        return Math.round(((this.distance/this.MPG)*4.546)*this.priceOfFuel*100.0)/100.0;
    } 
}

