package sud.aufgaben.designPatterns.worker;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public interface IView {
    JButton getAddWorkerButton();

    DefaultTableModel getDefaultTableModel();

    JButton getRemoveWorkerButton();

    JTable getWorkerTable();
}
