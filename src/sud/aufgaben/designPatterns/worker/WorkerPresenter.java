package sud.aufgaben.designPatterns.worker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkerPresenter implements IPresenter {
    private final IView workerView;
    private final WorkerModel workerModel;

    public WorkerPresenter(IView workerView) {
        this.workerView = workerView;
        this.workerView.getAddWorkerButton().addActionListener(new AddButtonActionListener());
        this.workerView.getRemoveWorkerButton().addActionListener(new RemoveButtonActionListener());

        this.workerModel = new WorkerModel();
    }

    private class AddButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO
        }
    }

    private class RemoveButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = WorkerPresenter.this.workerView.getWorkerTable().getSelectedRow();
            if (selectedRow >= 0) {
                WorkerPresenter.this.workerModel.removeWorker(selectedRow);
                WorkerPresenter.this.workerView.getDefaultTableModel().removeRow(selectedRow);
            }
        }
    }

    public class Input {
    }

    public enum WorkerTypes {
        OFFICE(), DRIVER(), MANAGER(), SHIFT_WORKER();

        private final Input[] inputs;

        private WorkerTypes(Input... inputs) {
            this.inputs = inputs;
        }
    }
}
