package business.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucas on 09/11/16.
 */
public class Comentario implements ComentarioComposite{
    private ArrayList<ComentarioComposite> respostas = new ArrayList<>();
    private String texto;

    public Comentario(String texto) {
        this.texto = texto;
    }

    public String getTexto(){
        return this.texto;
    }

    public void setTexto(String texto){
        this.texto = texto;
    }

    public ComentarioMemento saveMemento(){
        return new ComentarioMemento(this.texto);
    }

    public void restoreFromMemento(ComentarioMemento memento){
        this.texto = memento.getSavedTexto();
    }

    public void addResposta(ComentarioComposite resposta){
        this.respostas.add(resposta);
    }

    public ArrayList<ComentarioComposite> getRespostas(){
        return this.respostas;
    }

    public ComentarioComposite getResposta(int index){
        return this.respostas.get(index);
    }
}
