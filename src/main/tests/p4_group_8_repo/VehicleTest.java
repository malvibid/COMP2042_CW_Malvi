package p4_group_8_repo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static p4_group_8_repo.ImageLoader.TRUCK;

class VehicleTest {

    @BeforeEach
    void setUp() {
    }

    /**
     * If object was created, it would be set at the right position.
     */
    @Test void testObjectCreation(){
        Vehicle truck = new Vehicle(TRUCK, 500, 450, -5);
        assertEquals(500, truck.getX());
        assertEquals(450, truck.getY());

    }

}