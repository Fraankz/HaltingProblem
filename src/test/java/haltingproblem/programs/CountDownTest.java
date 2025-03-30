package haltingproblem.programs;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class CountDownTest {

    @Test
    void testCountDownOutput() {
        int start = 3;
        CountDown countDown = new CountDown(start);

        // Capturar la salida estándar
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(baos));

        countDown.run();

        System.setOut(originalOut);
        String output = baos.toString();

        assertTrue(output.contains("CountDown: 3"), "Debe contener el valor 3");
        assertTrue(output.contains("CountDown: 2"), "Debe contener el valor 2");
        assertTrue(output.contains("CountDown: 1"), "Debe contener el valor 1");
        assertFalse(output.contains("CountDown: 0"), "No debería imprimir el 0");
    }
}
