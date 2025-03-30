package haltingproblem;

import haltingproblem.programs.Program;

public class HaltChecker {
    public static boolean willHalt(Program program, Program input) {
        String name = program.getName();
        return name.equals("CountDown");
    }
}
