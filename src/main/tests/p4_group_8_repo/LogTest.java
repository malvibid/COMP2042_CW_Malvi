package p4_group_8_repo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static p4_group_8_repo.ImageLoader.LOG_3;

class LogTest {

    /**
     * If object was created, it would be set at the right position and speed.
     */
    @Test void testObjectCreation(){
        Log log = new Log(LOG_3, 0, 150, 0.75);
        assertEquals(0, log.getX());
        assertEquals(150, log.getY());
        assertEquals(0.75, log.getSpeed());
    }
}