package haltingproblem.ui;

import javax.swing.*;
import java.awt.*;
import haltingproblem.programs.CountDown;
import haltingproblem.programs.CountUp;
import haltingproblem.logic.Reverser;
import haltingproblem.programs.Program;

public class MainUI extends JFrame {

    public MainUI() {
        setTitle("Halting Problem Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new FlowLayout());

        JButton btnCountDown = new JButton("Run CountDown");
        JButton btnCountUp = new JButton("Run CountUp");
        JButton btnReverser = new JButton("Run Reverser");

        btnCountDown.addActionListener(e -> {
            Program p = new CountDown(5);
            p.run();
        });

        btnCountUp.addActionListener(e -> {
            Program p = new CountUp(1);
            p.run();
        });

        btnReverser.addActionListener(e -> {
            Program p = new Reverser();
            p.run();
        });

        add(btnCountDown);
        add(btnCountUp);
        add(btnReverser);

        setVisible(true);
    }
}
