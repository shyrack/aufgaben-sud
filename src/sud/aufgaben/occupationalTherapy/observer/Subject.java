package occupationalTherapy.observer;

import java.util.ArrayList;

public abstract class Subject<T> {
    protected ArrayList<Observer<T>> observers;

    public Subject() {
        observers = new ArrayList<Observer<T>>();
    }

    public void addObserver(Observer<T> ob) {
        observers.add(ob);
    }

    public void deleteObserver(Observer<T> ob) {
        observers.remove(ob);
    }

    public void notifyObservers(T info) {
        for (Observer<T> ob : observers) {
            ob.update(info);
        }
    }
}
