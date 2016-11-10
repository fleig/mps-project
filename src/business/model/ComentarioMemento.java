package business.model;

/**
 * Created by lucas on 09/11/16.
 */
public class ComentarioMemento {
    private String texto;

    public ComentarioMemento(String texto){
        this.texto = texto;
    }

    public String getSavedTexto(){
        return this.texto;
    }

}
