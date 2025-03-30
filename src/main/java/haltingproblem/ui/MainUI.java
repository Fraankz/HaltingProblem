package haltingproblem.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import haltingproblem.programs.CountDown;
import haltingproblem.programs.CountUp;
import haltingproblem.logic.Reverser;
import haltingproblem.programs.Program;

public class MainUI extends JFrame {
    private JTextArea logArea;

    public MainUI() {
        setTitle("Halting Problem Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel superior: Botones para ejecutar los programas
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton btnCountDown = new JButton("Run CountDown");
        JButton btnCountUp = new JButton("Run CountUp");
        JButton btnReverser = new JButton("Run Reverser");

        // Agregar ActionListeners que ejecutan los programas en hilos separados
        btnCountDown.addActionListener((ActionEvent e) -> runProgram(new CountDown(5)));
        btnCountUp.addActionListener((ActionEvent e) -> runProgram(new CountUp(1)));
        btnReverser.addActionListener((ActionEvent e) -> runProgram(new Reverser()));

        buttonPanel.add(btnCountDown);
        buttonPanel.add(btnCountUp);
        buttonPanel.add(btnReverser);

        // Área central: JTextArea para mostrar la salida de los programas
        logArea = new JTextArea();
        logArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logArea);

        // Menú: Añadir un menú de ayuda con un "About"
        JMenuBar menuBar = new JMenuBar();
        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Halting Problem Simulator\nVersion 1.0", "About", JOptionPane.INFORMATION_MESSAGE);
        });
        helpMenu.add(aboutItem);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);

        add(buttonPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    /**
     * Ejecuta un programa en un SwingWorker para mantener la UI responsiva.
     * La salida del programa se captura y se muestra en el logArea.
     *
     * @param program El programa a ejecutar.
     */
    private void runProgram(Program program) {
        SwingWorker<Void, String> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                // Redirigir la salida estándar para capturar el log
                PrintStream oldOut = System.out;
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                PrintStream ps = new PrintStream(baos);
                System.setOut(ps);

                // Ejecutar el programa (esto se hace en un hilo separado)
                program.run();

                // Restaurar System.out y publicar la salida capturada
                System.out.flush();
                System.setOut(oldOut);
                publish(baos.toString());
                return null;
            }

            @Override
            protected void process(java.util.List<String> chunks) {
                // Actualizar el área de log con la salida del programa
                for (String output : chunks) {
                    logArea.append(output);
                }
            }
        };
        worker.execute();
    }
}
