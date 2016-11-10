package business.model;

import java.util.ArrayList;

/**
 * Created by lucas on 09/11/16.
 */
public class ComentarioCareTaker {
    private ArrayList<ComentarioMemento> historico = new ArrayList<>();

    public void addMemento(ComentarioMemento memento){
        this.historico.add(memento);
    }

    public ArrayList<ComentarioMemento> getHistorico(){
        return this.historico;
    }

    public ComentarioMemento getMemento(int index){
        return this.historico.get(index);
    }
}
