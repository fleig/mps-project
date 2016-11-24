package test;


import business.control.FacadeCRUD;
import business.control.InvalidReceitaException;
import business.control.InvalidUsuarioException;
import business.model.Receita;
import business.model.Usuario;
import org.junit.Before;
import org.junit.Test;
import utils.StringUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by UFPB-CIA-03 on 24/11/2016.
 */
public class ObserverTest {
    private FacadeCRUD facadeCRUD;
    Receita receita;
    @Before
    public void setUp() throws Exception {
        facadeCRUD = FacadeCRUD.getInstance();
    }

    @Test
    public void checkObserver() throws Exception {
        Usuario usuario;
        //valido
        try {
            usuario = new Usuario("loginA", "senha123");
            facadeCRUD.addUsuario(usuario);
            facadeCRUD.addObserver(usuario);
            assertNotNull(usuario);
        } catch (InvalidUsuarioException e){
        }
        try {
            usuario = new Usuario("loginB", "senha123");
            facadeCRUD.addUsuario(usuario);
            facadeCRUD.addObserver(usuario);
            assertNotNull(usuario);
        } catch (InvalidUsuarioException e){
        }


        //receita existente
        try {
            facadeCRUD.addReceita(new Receita("Receita1"));
            usuario=facadeCRUD.getUsuario("loginA");

            usuario.visualizarNovasReceitas();

        } catch (InvalidReceitaException e){

        }

        //receita inexistente
        try {
            facadeCRUD.removeReceita(new Receita("receita1"));
            usuario=facadeCRUD.getUsuario("loginB");
            receita=facadeCRUD.getReceita("receita1");
            usuario.visualizarNovasReceitas();

        } catch (InvalidReceitaException e){

            assertEquals(e.getMessage(), StringUtils.ERRO_RECEITA_INEXISTENTE);
        }



    }
}
