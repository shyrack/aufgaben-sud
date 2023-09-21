package sud.aufgaben.designPatterns.worker;

import java.util.ArrayList;
import java.util.List;

import sud.aufgaben.occupationalTherapy.container.mitarbeiter.Mitarbeiter;

public class WorkerModel {
    private final List<Mitarbeiter> workers;

    public WorkerModel() {
        this.workers = new ArrayList<>();
    }

    public void addWorker(Mitarbeiter worker) {
        this.workers.add(worker);
    }

    public void removeWorker(int index) {
        this.workers.remove(index);
    }
}
