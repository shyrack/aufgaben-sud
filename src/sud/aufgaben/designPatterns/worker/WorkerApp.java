package sud.aufgaben.designPatterns.worker;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import sud.aufgaben.occupationalTherapy.container.mitarbeiter.Mitarbeiter;

public class WorkerApp extends JFrame {
    private final DefaultTableModel workerDefaultTableModel;
    private final JTable workerTable;
    private final JPanel buttonPanel;
    private final JButton addWorkerButton, removeWorkerButton;

    private final List<Mitarbeiter> workers;

    public WorkerApp() {
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.workerDefaultTableModel = new DefaultTableModel();
        this.workerTable = new JTable(this.workerDefaultTableModel);
        this.buttonPanel = new JPanel();
        this.addWorkerButton = new JButton("Add worker");
        this.removeWorkerButton = new JButton("Remove worker");

        this.workers = Collections.synchronizedList(new ArrayList<>());

        this.addWorkerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
        });
        this.removeWorkerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = WorkerApp.this.workerTable.getSelectedRow();
                if (selectedRow >= 0) {
                    WorkerApp.this.workerDefaultTableModel.removeRow(selectedRow);
                    WorkerApp.this.workers.remove(selectedRow);
                }
            }
        });

        this.buttonPanel.setLayout(new BoxLayout(this.buttonPanel, BoxLayout.Y_AXIS));
        this.buttonPanel.add(this.addWorkerButton);
        this.buttonPanel.add(this.removeWorkerButton);

        super.getContentPane().add(new JScrollPane(this.workerTable), BorderLayout.CENTER);
        super.getContentPane().add(this.buttonPanel, BorderLayout.EAST);

        super.pack();
        super.setVisible(true);
    }
}
