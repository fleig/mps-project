package business.observer;

/**
 * Created by UFPB-CIA-03 on 22/11/2016.
 */
import business.model.Receita;

import java.util.ArrayList;

public class DadosSubject {

    protected ArrayList<DadosObserver> observers;
    protected Receita dados;

    public DadosSubject() {
        observers = new ArrayList<DadosObserver>();
    }

    public void attach(DadosObserver observer) {
        observers.add(observer);
    }

    public void detach(int indice) {
        observers.remove(indice);
    }

    public void setState(Receita dados) {
        this.dados = dados;
        notifyObservers();
    }

    private void notifyObservers() {
        for (DadosObserver observer : observers) {
            observer.update();
        }
    }

    public Receita getState() {
        return dados;
    }

}
