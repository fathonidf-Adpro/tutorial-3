package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.service.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CarControllerTest {

    @Mock
    private CarService carService;

    @Mock
    private Model model;

    @InjectMocks
    private CarController carController;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateCarPage(){
        String pageString = carController.createCarPage(model);
        assertEquals("createCar", pageString);
    }

    @Test
    void testCreateCarPost(){
        Car car = new Car();
        String pageString = carController.createCarPost(car, model);
        assertEquals("redirect:listCar", pageString);
        verify(carService, times(1)).create(car);
    }

    @Test
    void testEditCarPage(){
        Car car = new Car();
        String pageString = carController.editCarPage(car.getCarId(), model);
        assertEquals("editCar", pageString);
    }

    @Test
    void testUpdateCar(){
        Car car = new Car();
        car.setCarName("Pajero");
        car.setCarQuantity(1);
        car.setCarColor("White");

        carController.createCarPost(car, model);

        car.setCarColor("Black");

        String pageString = carController.editCarPost(car, model);
        assertEquals("redirect:listCar", pageString);
        verify(carService, times(1)).create(car);
        verify(carService, times(1)).update(car.getCarId(), car);

    }

    @Test
    void testDeleteCar(){
        Car car = new Car();
        car.setCarName("Pajero");
        car.setCarQuantity(1);
        car.setCarColor("White");

        carController.createCarPost(car, model);
        String pageString = carController.deleteCar(car.getCarId());
        
        assertEquals("redirect:listCar", pageString);
        verify(carService, times(1)).create(car);
        verify(carService, times(1)).deleteCarById(car.getCarId());
    }

    @Test
    void testCarListPage(){
        List<Car> carList = new ArrayList<>();
        when(carService.findAll()).thenReturn(carList);

        Car car1 = new Car();
        car1.setCarName("Pajero");
        car1.setCarQuantity(1);
        car1.setCarColor("White");
        carController.createCarPost(car1, model);
        
        Car car2 = new Car();
        car2.setCarName("Jazz");
        car2.setCarQuantity(2);
        car2.setCarColor("Grey");
        carController.createCarPost(car2, model);
        
        Car car3 = new Car();
        car3.setCarName("Outlander");
        car3.setCarQuantity(3);
        car3.setCarColor("White");
        carController.createCarPost(car3, model);
        verify(carService, times(3)).create(any(Car.class));

        String pageString = carController.carListPage(model);
        assertEquals("carList", pageString);
        verify(model, times(1)).addAttribute("cars", carList);
    }
}
