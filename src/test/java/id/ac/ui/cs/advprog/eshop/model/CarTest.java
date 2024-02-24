package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CarTest {
    Car car;
    @BeforeEach
    void setUp(){
        this.car = new Car();
        this.car.setCarId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        this.car.setCarName("Pajero");
        this.car.setCarQuantity(1);
        this.car.setCarColor("White");
    }

    @Test
    void testGetCarId(){
        assertEquals("eb558e9f-1c39-460e-8860-71af6af63bd6", this.car.getCarId());
    }

    @Test
    void testGetCarName(){
        assertEquals("Pajero", this.car.getCarName());
    }
    
    @Test
    void testGetCarQuantity(){
        assertEquals(1, this.car.getCarQuantity());
    }

    @Test
    void testGetCarColor(){
        assertEquals("White", this.car.getCarColor());
    }

    @Test
    void testUpdateCar(){
        Car newCar = new Car();
        newCar.setCarName("Dakar");
        newCar.setCarQuantity(2);
        newCar.setCarColor("Black");

        this.car.update(newCar);

        assertEquals("eb558e9f-1c39-460e-8860-71af6af63bd6", this.car.getCarId());
        assertNotEquals("Pajero", this.car.getCarName());
        assertNotEquals(1, this.car.getCarQuantity());
        assertNotEquals("White", this.car.getCarColor());
    }
}
