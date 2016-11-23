package business.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lucas on 22/11/16.
 */
public class ReceitaTest {
    Receita receita;
    @Before
    public void setUp() throws Exception {
        receita = new Receita();
    }

    @Test
    public void addComentario() throws Exception {
        Comentario c = new Comentario("Gostei");
        receita.addComentario(c);

        assertEquals("Gostei", receita.getComentarios().get(0).getTexto());
    }

    @Test
    public void responderComentario() throws Exception {
        Comentario c = new Comentario("Muito boa");
        receita.addComentario(c);

        assertEquals("Muito boa", receita.getComentarios().get(0).getTexto());

        Comentario c2 = new Comentario("Concordo!");
        c.addResposta(c2);

        assertEquals("Concordo!", receita.getComentarios().get(0).getResposta(0).getTexto());
    }

    @Test
    public void addMultimidia() throws Exception {
        String file = "foto1.png";
        //print terminal
        Multimidia multimidia = new MultimidiaProxy(file);

        //print terminal
        multimidia.display();
    }

}