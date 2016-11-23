package business.model;

/**
 * Created by lucas on 22/11/16.
 */
public interface ComentarioComposite {
    String getTexto();
    void setTexto(String texto);
    ComentarioMemento saveMemento();
    void restoreFromMemento(ComentarioMemento memento);
}
