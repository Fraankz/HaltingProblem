package haltingproblem.programs;

public class CountDown implements Program {
    private int start;

    public CountDown(int start) {
        this.start = start;
    }

    @Override
    public void run() {
        while (start > 0) {
            System.out.println("CountDown: " + start--);
        }
    }

    @Override
    public String getName() {
        return "CountDown";
    }
}
