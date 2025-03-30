package haltingproblem.logic;

import haltingproblem.checker.HaltChecker;
import haltingproblem.programs.Program;

public class Reverser implements Program {

    @Override
    public void run() {
        boolean result = HaltChecker.willHalt(this, this);
        if (result) {
            while (true) {
                System.out.println("Reverser: Bucle infinito porque HaltChecker dijo que me detengo.");
            }
        } else {
            System.out.println("Reverser: Terminando porque HaltChecker dijo que no me detengo.");
        }
    }

    @Override
    public String getName() {
        return "Reverser";
    }
}
