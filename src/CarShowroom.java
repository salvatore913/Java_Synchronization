import java.util.ArrayList;
import java.util.List;

public class CarShowroom {
    private final int PRODUCTION_TIME = 3000;
    private final int SELL_TIME = 1500;
    private final int BUYERS = 3;
    private final int CARS = 10;
    private final List<Car> cars = new ArrayList<>();

    public synchronized void sellCar() {
        try {
            System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
            while (cars.size() == 0) {
                System.out.println("Машин нет");
                wait();
            }
            Thread.sleep(SELL_TIME);
            System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");
            cars.remove(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void receiveCar() {
        for (int i = 0; i < CARS; i++) {
            try {
                Thread.sleep(PRODUCTION_TIME);
                cars.add(new Car());
                System.out.println("Производитель " + Thread.currentThread().getName() + " выпустил 1 авто");
                synchronized (this) {
                    notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void buy() {
        for (int i = 0; i <= BUYERS; i++) {
            this.sellCar();
        }
    }
}