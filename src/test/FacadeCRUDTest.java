package test;

import business.control.FacadeCRUD;
import business.control.InvalidUsuarioException;
import business.model.Usuario;
import org.junit.Before;
import org.junit.Test;
import utils.StringUtils;

import static org.junit.Assert.*;

/**
 * Created by lucas on 17/10/16.
 */
public class FacadeCRUDTest {
    private FacadeCRUD facadeCRUD;
    @Before
    public void setUp() throws Exception {
        facadeCRUD = FacadeCRUD.getInstance();
    }

    @Test
    public void addUsuario() throws Exception {
        Usuario usuario;

        //erro senha sem numero
        try {
            usuario = new Usuario("login", "senhaaaaa");
            facadeCRUD.addUsuario(usuario);
        } catch (InvalidUsuarioException e){
            assertEquals(e.getMessage(), StringUtils.ERRO_SENHA);
        }

        //erro senha curta
        try {
            usuario = new Usuario("login", "sea");
            facadeCRUD.addUsuario(usuario);
        } catch (InvalidUsuarioException e){
            assertEquals(e.getMessage(), StringUtils.ERRO_SENHA);
        }

        //erro senha longa
        try {
            usuario = new Usuario("login", "seaaaaaaaa123aaa54a65aa");
            facadeCRUD.addUsuario(usuario);
        } catch (InvalidUsuarioException e){
            assertEquals(e.getMessage(), StringUtils.ERRO_SENHA);
        }

        //erro login curto
        try {
            usuario = new Usuario("l", "senha123");
            facadeCRUD.addUsuario(usuario);
        } catch (InvalidUsuarioException e) {
            assertEquals(e.getMessage(), StringUtils.ERRO_LOGIN);
        }

        //erro login longo
        try {
            usuario = new Usuario("looooooooooooooooooooooooogin", "senha123");
            facadeCRUD.addUsuario(usuario);
        } catch (InvalidUsuarioException e){
            assertEquals(e.getMessage(), StringUtils.ERRO_LOGIN);
        }

        //valido
        try {
            usuario = new Usuario("login", "senha123");
            facadeCRUD.addUsuario(usuario);
            assertNotNull(usuario);
        } catch (InvalidUsuarioException e){
        }

        //erro login duplicado
        try {
            usuario = new Usuario("login", "senha1234");
            facadeCRUD.addUsuario(usuario);
        } catch (InvalidUsuarioException e){
            assertEquals(e.getMessage(), StringUtils.ERRO_LOGIN_EXISTENTE);
        }
    }

    @Test
    public void updateUsuario() throws Exception {
        Usuario u = new Usuario("usuario", "senha123");
        facadeCRUD.addUsuario(u);

        //erro senha curta
        try {
            Usuario usuario = new Usuario("usuario", "senha123");
            String novaSenha = "se";
            facadeCRUD.updateUsuario(usuario, novaSenha);
        } catch (InvalidUsuarioException e){
            assertEquals(e.getMessage(), StringUtils.ERRO_SENHA);
        }

        //erro senha sem numero
        try {
            Usuario usuario = new Usuario("usuario", "senha123");
            String novaSenha = "senhaaaaaa";
            facadeCRUD.updateUsuario(usuario, novaSenha);
        } catch (InvalidUsuarioException e){
            assertEquals(e.getMessage(), StringUtils.ERRO_SENHA);
        }

        //erro senha sem longa
        try {
            Usuario usuario = new Usuario("usuario", "senha123");
            String novaSenha = "senhaaaa1231312123231asdasdaa";
            facadeCRUD.updateUsuario(usuario, novaSenha);
        } catch (InvalidUsuarioException e){
            assertEquals(e.getMessage(), StringUtils.ERRO_SENHA);
        }

        //erro login inexistente
        try {
            Usuario usuario = new Usuario("usuario1", "senha123");
            String novaSenha = "senha1234";
            facadeCRUD.updateUsuario(usuario, novaSenha);
        } catch (InvalidUsuarioException e){
            assertEquals(e.getMessage(), StringUtils.ERRO_LOGIN_INEXISTENTE);
        }

        //valido
        Usuario usuario = new Usuario("usuario", "senha123");
        String novaSenha = "senha1234";
        facadeCRUD.updateUsuario(usuario, novaSenha);
        assertEquals(usuario.getSenha(), "senha1234");
    }

    @Test
    public void removeUsuario() throws Exception {
        Usuario u = new Usuario("teste", "senha123");
        facadeCRUD.addUsuario(u);

        //erro login inexistente
        try {
            Usuario usuario = new Usuario("usuario1", "senha123");
            facadeCRUD.removeUsuario(usuario);
        } catch (InvalidUsuarioException e){
            assertEquals(e.getMessage(), StringUtils.ERRO_LOGIN_INEXISTENTE);
        }

        //valido
        Usuario usuario = new Usuario("teste", "senha123");
        facadeCRUD.removeUsuario(usuario);
    }

    @Test
    public void getUsuario() throws Exception {
        Usuario u = new Usuario("testando", "senha123");
        facadeCRUD.addUsuario(u);

        //erro login inexistente
        try {
            Usuario usuario = facadeCRUD.getUsuario("user");
        } catch (InvalidUsuarioException e){
            assertEquals(e.getMessage(), StringUtils.ERRO_LOGIN_INEXISTENTE);
        }

        //valido
        Usuario usuario = facadeCRUD.getUsuario("testando");
        assertNotNull(usuario);
    }

}