package gui;

import io.InputFileContent;
import io.InputReader;
import logic.Formatter;
import logic.TripsCalculator;
import logic.TripsLogic;
import model.Drone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class DroneDeliverServiceInterface extends JFrame {

    private final JTextArea inputArea = new JTextArea(30, 50);
    private final JTextArea outputArea = new JTextArea(30, 50);

    private InputFileContent inputFileContent;

    public DroneDeliverServiceInterface() {
        setTitle("Drone Delivery Service");
        setLayout(new BorderLayout());

        inputArea.setEditable(false);
        outputArea.setEditable(false);

        // Input and output areas in a split pane in the center
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                new JScrollPane(inputArea), new JScrollPane(outputArea));
        add(splitPane, BorderLayout.CENTER);

        // Button panel in the south
        JPanel buttonPanel = new JPanel();
        JButton selectFileButton = new JButton("Select File");
        buttonPanel.add(selectFileButton);
        JButton calculateTripsButton = new JButton("Calculate trips");
        buttonPanel.add(calculateTripsButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Event listeners
        selectFileButton.addActionListener(new SelectFileListener());
        calculateTripsButton.addActionListener(new CalculateTripsButtonListener());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();

        setLocationRelativeTo(null);
        setVisible(true);

    }

    private class SelectFileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(DroneDeliverServiceInterface.this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();

                try {
                    inputFileContent = InputReader.readInputFile(selectedFile.getPath());
                    inputArea.setText(inputFileContent.getContent());
                    outputArea.setText("");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(DroneDeliverServiceInterface.this, "Error reading file: " + ex.getMessage());
                }
            }
        }
    }

    private class CalculateTripsButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (inputFileContent == null) {
                JOptionPane.showMessageDialog(DroneDeliverServiceInterface.this, "No input file has been selected");
                return;
            }
            outputArea.setText("");
            String output = calculateTrips();
            outputArea.setText(output);
        }
    }

    private String calculateTrips() {
        TripsCalculator approach1 = new TripsLogic();
        List<Drone> dronesWithTrips = approach1.calculateTrips(inputFileContent.getDrones(), inputFileContent.getLocations());
        return Formatter.formatTripsFromDrones(dronesWithTrips);
    }
}
