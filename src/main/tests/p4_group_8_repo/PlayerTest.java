package p4_group_8_repo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerTest {

    /**
     * Checking whether the boolean logic is correct.
     */
    @Test
    void changeScore() {
        boolean changeScore = false;
        assertFalse(changeScore);
        assertTrue(!changeScore);

    }
}