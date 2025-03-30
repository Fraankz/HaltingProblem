package haltingproblem.programs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CountUpTest {

    @Test
    void testGetName() {
        CountUp countUp = new CountUp(0);
        assertEquals("CountUp", countUp.getName(), "El nombre del programa debe ser CountUp");
    }

    // Se evita llamar a run() ya que es un bucle infinito.
}
