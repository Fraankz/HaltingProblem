package haltingproblem.programs;

public class CountUp implements Program {
    private int start;

    public CountUp(int start) {
        this.start = start;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("CountUp: " + start++);
        }
    }

    @Override
    public String getName() {
        return "CountUp";
    }
}
