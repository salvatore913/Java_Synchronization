public class Main {
    private static final int CARS = 10;

    public static void main(String[] args) {
        final CarShowroom carShowroom = new CarShowroom();
        for (int i = 0; i < CARS; i++) {
            new Thread(null, carShowroom::sellCar, "Покупатель 1").start();
            new Thread(null, carShowroom::sellCar, "Покупатель 2").start();
            new Thread(null, carShowroom::sellCar, "Покупатель 3").start();
            new Thread(null, carShowroom::receiveCar, "Kia").start();
        }
    }
}