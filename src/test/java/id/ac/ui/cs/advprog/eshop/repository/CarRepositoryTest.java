package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CarRepositoryTest {

    @InjectMocks
    CarRepository carRepository;
    @BeforeEach
    void setUp(){
    }
    @Test
    void testCreateAndFind(){
        Car car = new Car();
        car.setCarId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        car.setCarName("Pajero");
        car.setCarQuantity(100);
        car.setCarColor("White");
        carRepository.create(car);

        Iterator<Car> carIterator = carRepository.findAll();
        assertTrue(carIterator.hasNext());
        Car savedCar = carIterator.next();
        assertEquals(car.getCarId(), savedCar.getCarId());
        assertEquals(car.getCarName(), savedCar.getCarName());
        assertEquals(car.getCarQuantity(), savedCar.getCarQuantity());
        assertEquals(car.getCarColor(), savedCar.getCarColor());
    }

    @Test
    void testFindAllIfEmpty(){
        Iterator<Car> CarIterator = carRepository.findAll();
        assertFalse(CarIterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneCar(){
        Car car1 = new Car();
        car1.setCarId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        car1.setCarName("Pajero");
        car1.setCarQuantity(1);
        car1.setCarColor("White");
        carRepository.create(car1);
        
        Car car2 = new Car();
        car2.setCarId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        car2.setCarName("Jazz");
        car2.setCarQuantity(2);
        car2.setCarColor("Grey");
        carRepository.create(car2);

        Iterator<Car> carIterator = carRepository.findAll();
        assertTrue(carIterator.hasNext());
        Car savedCar = carIterator.next();
        assertEquals(car1.getCarId(), savedCar.getCarId());
        savedCar = carIterator.next();
        assertEquals(car2.getCarId(), savedCar.getCarId());
        assertFalse(carIterator.hasNext());
    }

    @Test
    void testDeletedCar(){
        Car car1 = new Car();
        car1.setCarId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        car1.setCarName("Pajero");
        car1.setCarQuantity(1);
        car1.setCarColor("White");
        carRepository.create(car1);

        carRepository.delete(car1.getCarId());

        Iterator<Car> carIterator = carRepository.findAll();
        assertFalse(carIterator.hasNext());
        assertNull(carRepository.findById(car1.getCarId()));
    }

    @Test
    void testEditedCar(){
        Car car1 = new Car();
        car1.setCarId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        car1.setCarName("Pajero");
        car1.setCarQuantity(1);
        car1.setCarColor("White");
        carRepository.create(car1);

        Car car2 = new Car();
        car2.setCarId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        car2.setCarName("Jazz");
        car2.setCarQuantity(2);
        car2.setCarColor("Grey");
        carRepository.create(car2);

        Car getEditedCar = carRepository.findById(car1.getCarId());
        getEditedCar.setCarName("Pajero Dakar");
        getEditedCar.setCarQuantity(3);
        getEditedCar.setCarColor("Black");
        carRepository.update(car1.getCarId(), getEditedCar);

        Iterator<Car> CarIterator = carRepository.findAll();
        Car currentCar = CarIterator.next();

        assertEquals(getEditedCar.getCarName(), currentCar.getCarName());
    }
    

}


