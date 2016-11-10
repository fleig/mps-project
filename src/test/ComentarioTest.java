package test;

import business.model.Comentario;
import business.model.ComentarioCareTaker;
import business.model.ComentarioMemento;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lucas on 09/11/16.
 */
public class ComentarioTest {
    @Test
    public void checkMemento() throws Exception {
        String[] texto = {"Teste", "Teste2", "Teste3"};
        Comentario comentario =new Comentario(texto[0]);
        ComentarioCareTaker careTaker = new ComentarioCareTaker();
        //salvo 1
        careTaker.addMemento(comentario.saveMemento());
        comentario.setTexto(texto[1]);
        //salvo 2
        careTaker.addMemento(comentario.saveMemento());
        comentario.setTexto(texto[2]);
        //salvo 3
        careTaker.addMemento(comentario.saveMemento());

        //restore 1
        comentario.restoreFromMemento(careTaker.getMemento(0));
        assertEquals(comentario.getTexto(), texto[0]);

        //restore 2
        comentario.restoreFromMemento(careTaker.getMemento(1));
        assertEquals(comentario.getTexto(), texto[1]);

        //restore 3
        comentario.restoreFromMemento(careTaker.getMemento(2));
        assertEquals(comentario.getTexto(), texto[2]);

        //test historico
        for(int i = 0; i < careTaker.getHistorico().size(); i++){
            assertEquals(careTaker.getHistorico().get(i).getSavedTexto(), texto[i]);
        }
    }
}