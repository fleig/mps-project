package business.model;

/**
 * Created by lucas on 09/11/16.
 */
public class Comentario {
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
}
