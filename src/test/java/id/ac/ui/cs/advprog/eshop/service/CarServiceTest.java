package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.repository.CarRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CarServiceTest {

    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarServiceImpl carService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createCar() {
        Car car = new Car();
        when(carRepository.create(car)).thenReturn(car);

        Car createdCar = carService.create(car);

        assertEquals(car, createdCar);
        verify(carRepository, times(1)).create(createdCar);
    }

    @Test
    void findAllCars() {
        Car car = new Car();
        when(carRepository.create(car)).thenReturn(car);
        carService.create(car);

        when(carRepository.findAll()).thenReturn(List.of(car).iterator());
        Iterator<Car> foundCars = carService.findAll().iterator();

        assertTrue(foundCars.hasNext());
        Car savedCar = foundCars.next();

        assertEquals(car, savedCar);
        verify(carRepository, times(1)).findAll();
    }

    @Test
    void findCarById() {
        Car car = new Car();
        car.setCarId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        String carId = car.getCarId();
        when(carRepository.findById(carId)).thenReturn(car);

        Car foundCar = carService.findById(carId);

        assertEquals(car, foundCar);
        verify(carRepository, times(1)).findById(carId);
    }

    @Test
    void editCar() {
        String carId = "testCarId";
        Car existingCar = new Car();
        existingCar.setCarId(carId);

        when(carRepository.update(carId, existingCar)).thenReturn(existingCar);
        carService.update(carId, existingCar);

        verify(carRepository, times(1)).update(carId, existingCar);
    }

    @Test
    void deleteCar() {
        Car car = new Car();
        car.setCarId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        String carId = car.getCarId();
        when(carRepository.delete(carId)).thenReturn(car);

        carService.deleteCarById(carId);

        verify(carRepository, times(1)).delete(carId);
    }
}
