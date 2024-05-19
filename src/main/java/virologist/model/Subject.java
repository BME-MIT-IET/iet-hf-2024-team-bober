package virologist.model;

import virologist.view.Observer;
import java.util.ArrayList;
import java.util.List;

/**
 * Egy megfigyelt osztály, melynek változásaira fel lehet iratkozniuk Observereknek
 */
public class Subject {
    /**
     * Observerek - megfigyelők listája
     */
    List<Observer> observers;

    public Subject() {
        observers = new ArrayList<>();
    }

    public Subject(List<Observer> observers) {
        this.observers = observers;
    }

    /**
     * Egy megfigyelő regisztrálása
     * @param observer a hozzáadandó megfigyelő
     */
    public void attach(Observer observer){
        if (!observers.contains(observer)){
            observers.add(observer);
        }
    }

    /**
     * Egy megfigyelő leválasztása
     * @param observer az eltávolítandó megfigyelő
     */
    public void detach(Observer observer){
        observers.remove(observer);
    }

    /**
     * Az összes regisztrált megfigyelő értesítése
     */
    public void notifyAllObservers(){
        for (Observer o : observers) {
            o.update();
        }
    }
}
