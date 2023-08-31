package sud.aufgaben.designPatterns.weather;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject<T> {
    protected List<Observer<T>> observers;

    public Subject() {
        this.observers = new ArrayList<>();
    }

    public void addObserver(Observer<T> observer) {
        this.observers.add(observer);
    }

    public void removeObserver(Observer<T> observer) {
        this.observers.remove(observer);
    }

    public List<Observer<T>> getObservers() {
        return this.observers;
    }

    public abstract void notifyObservers();
}
