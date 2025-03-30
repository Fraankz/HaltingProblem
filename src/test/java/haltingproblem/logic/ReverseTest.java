package haltingproblem.logic;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class ReverserTest {

    @Test
    void testReverserRun() {
        Reverser reverser = new Reverser();

        // Capturar salida estándar
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(baos));

        reverser.run();

        System.setOut(originalOut);
        String output = baos.toString();

        assertTrue(output.contains("Terminando porque HaltChecker dijo que no me detengo."),
                "Reverser debe terminar si HaltChecker retorna false");
    }
}
