package car;

public class Car {

    private boolean engineRunning;
    private final double tankCapacity;
    private final double fuelConsumption;
    private double fuel;
    private double speed;
    private final double vMax;
    private String driver;

    public Car(double tankCapacity, double fuel, double fuelConsumption, double vMax) {
        this.tankCapacity = tankCapacity;
        this.fuel = fuel;
        this.vMax = vMax;
        this.fuelConsumption = fuelConsumption;
    }

    public Car(Car car) {
        this.engineRunning = car.engineRunning;
        this.tankCapacity = car.tankCapacity;
        this.fuelConsumption = car.fuelConsumption;
        this.fuel = car.fuel;
        this.speed = car.speed;
        this.vMax = car.vMax;
        this.driver = car.driver;
    }

    public void brake(double duration, double force) {
        final double speedDelta = duration * force;
        if (this.speed - speedDelta >= 0) {
            this.speed -= speedDelta;
        } else {
            this.speed = 0;
        }
    }

    public void accelerate(double duration, double force) {
        final double speedDelta = duration * force;
        if (this.speed + speedDelta >= this.vMax) {
            this.speed = this.vMax;
        } else {
            this.speed += speedDelta;
        }
    }

    public void drive(double km) throws Exception {
        double consumedFuel = km / 100 * this.fuelConsumption;
        if (consumedFuel > this.fuel) {
            throw new Exception("The car is out of fuel!");
        } else {
            this.fuel -= consumedFuel;
        }
    }

    public boolean getIn(String driver) throws Exception {
        if (driver == null || driver.length() == 0) {
            throw new Exception("The driver should not be null or an empty string!");
        }
        boolean hijacked = this.driver != null && this.driver.length() != 0;
        this.driver = driver;
        return hijacked;
    }

    public void refuel() {
        this.fuel = this.tankCapacity;
    }

    public String movementInformation() {

        return String.format("", this.driver, this.fuel, this.fuelConsumption, this.speed, this.vMax);
    }

}
