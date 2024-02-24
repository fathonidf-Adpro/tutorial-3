package id.ac.ui.cs.advprog.eshop.repository;
import id.ac.ui.cs.advprog.eshop.model.Car;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository
public class CarRepository {
    
    static int id = 0;
    private List<Car> carData = new ArrayList<>();

    public Car create(Car car) {
        UUID uuid = UUID.randomUUID();
        car.setCarId(uuid.toString());
        carData.add(car);
        return car;
    }

    public Iterator<Car> findAll() {
        return carData.iterator();
    }

    public Car findById(String id) {
        Car result = null;
        for (Car car : carData) {
            if (car.getCarId().equals(id)) {
                result = car;
            }
        }
        return result;
    }

    public Car update(String id, Car updatedCar) {
        Car result = null;
        for (int i = 0; i < carData.size(); i++) {
            Car car = carData.get(i);
            if (car.getCarId().equals(id)) {
                car.setCarName(updatedCar.getCarName());
                car.setCarColor(updatedCar.getCarColor());
                car.setCarQuantity(updatedCar.getCarQuantity());
                result = car;
            }
        }
        return result;
    }

    public Car delete(String id) {
        Car deletedCar = findById(id);
        carData.remove(deletedCar);
        return deletedCar;
        // Car result = null;
        // for (Iterator<Car> it = carData.iterator(); it.hasNext(); ) {
        //     Car car = it.next();
        //     if (car.getCarId().equals(id)) {
        //         it.remove();
        //         result = car;
        //     }
        // }
        // return result; // Car not found
    }
}

