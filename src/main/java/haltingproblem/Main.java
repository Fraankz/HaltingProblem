package haltingproblem;

import haltingproblem.programs.CountDown;
import haltingproblem.programs.CountUp;
import haltingproblem.logic.Reverser;
import haltingproblem.programs.Program;
import haltingproblem.ui.MainUI;

public class Main {
    public static void main(String[] args) {
        // Ejecutar interfaz Swing
        javax.swing.SwingUtilities.invokeLater(() -> new MainUI());
    }
}
