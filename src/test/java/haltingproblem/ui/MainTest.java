package haltingproblem.ui;

import haltingproblem.Main;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class MainTest {

    @Test
    void testMainExecution() {
        // Verifica que la ejecución de Main.main no lance excepciones.
        // Se incluye un pequeño sleep para permitir que se inicie el hilo de Swing.
        assertDoesNotThrow(() -> {
            Main.main(new String[0]);
            // Espera breve para que el hilo de Swing se inicialice
            Thread.sleep(100);
        });
    }
}
