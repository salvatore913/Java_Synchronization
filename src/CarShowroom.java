import java.util.ArrayList;
import java.util.List;

public class CarShowroom {
    private final int PRODUCTION_TIME = 1500;
    private final int SELL_TIME = 1500;
    private final List<Car> cars = new ArrayList<>();

    public synchronized void sellCar() {
        try {
            System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
            while (getCars().isEmpty()) {
                System.out.println("Машин нет");
                wait();
            }
            Thread.sleep(SELL_TIME);
            System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");
            getCars().remove(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void receiveCar() {
        try {
            Thread.sleep(PRODUCTION_TIME);
            getCars().add(new Car());
            System.out.println("Производитель " + Thread.currentThread().getName() + " выпустил 1 авто");
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    List<Car> getCars() {
        return cars;
    }
}