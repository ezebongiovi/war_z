package observer;



import java.util.ArrayList;
import java.util.List;

/**
 * Created by epasquale on 4/2/17.
 */
public class Subject<T> {

    private List<Observer> observers = new ArrayList<>();
    private T state;

    public T getState() {
        return state;
    }

    public void setState(final T state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(final Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
