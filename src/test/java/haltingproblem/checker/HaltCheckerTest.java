package haltingproblem.checker;

import haltingproblem.programs.CountDown;
import haltingproblem.programs.CountUp;
import haltingproblem.programs.Program;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HaltCheckerTest {

    @Test
    void testWillHaltWithCountDown() {
        Program cd = new CountDown(5);
        // Según la implementación, se debe detener para CountDown
        assertTrue(HaltChecker.willHalt(cd, cd), "CountDown debería detenerse");
    }

    @Test
    void testWillHaltWithCountUp() {
        Program cu = new CountUp(0);
        // Para CountUp, la función retorna false
        assertFalse(HaltChecker.willHalt(cu, cu), "CountUp no debería detenerse");
    }
}
