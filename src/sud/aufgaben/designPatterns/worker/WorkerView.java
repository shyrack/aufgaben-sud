package sud.aufgaben.designPatterns.worker;

import java.awt.BorderLayout;
import java.awt.Dialog.ModalityType;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class WorkerView extends JFrame implements IView {
    private final IPresenter workerPresenter;

    private final DefaultTableModel workerDefaultTableModel;
    private final JTable workerTable;
    private final JPanel buttonPanel;
    private final JButton addWorkerButton, removeWorkerButton;

    public WorkerView() {
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.workerPresenter = new WorkerPresenter(this);

        this.workerDefaultTableModel = new DefaultTableModel();
        this.workerTable = new JTable(this.workerDefaultTableModel);
        this.buttonPanel = new JPanel();
        this.addWorkerButton = new JButton("Add worker");
        this.removeWorkerButton = new JButton("Remove worker");

        this.buttonPanel.setLayout(new BoxLayout(this.buttonPanel, BoxLayout.Y_AXIS));
        this.buttonPanel.add(this.addWorkerButton);
        this.buttonPanel.add(this.removeWorkerButton);

        super.getContentPane().add(new JScrollPane(this.workerTable), BorderLayout.CENTER);
        super.getContentPane().add(this.buttonPanel, BorderLayout.EAST);

        super.pack();
        super.setVisible(true);
    }

    public JButton getAddWorkerButton() {
        return this.addWorkerButton;
    }

    public DefaultTableModel getDefaultTableModel() {
        return this.workerDefaultTableModel;
    }

    public JButton getRemoveWorkerButton() {
        return this.removeWorkerButton;
    }

    public JTable getWorkerTable() {
        return this.workerTable;
    }

    public JDialog showAddWorkerDialog() {
        JDialog dialog = new JDialog();

        dialog.setModalityType(ModalityType.APPLICATION_MODAL);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        dialog.setVisible(true);

        return dialog;
    }
}
