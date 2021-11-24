public class Main {

    public static void main(String[] args) {
        final CarShowroom carShowroom = new CarShowroom();
        new Thread(null, carShowroom::receiveCar, "Kia").start();
        new Thread(null, carShowroom::buy, "Покупатель 1").start();
        new Thread(null, carShowroom::buy, "Покупатель 2").start();
        new Thread(null, carShowroom::buy, "Покупатель 3").start();


    }
}