package business.control;

import business.model.Usuario;
import business.model.Receita;
import business.state.State;

/**
 * Created by lucas on 17/10/16.
 */
public class FacadeCRUD {
    private static FacadeCRUD myInstance;
    private UsuarioControl usuarioControl = new UsuarioControl();
    private ReceitaControl receitaControl = new ReceitaControl();
    private RelatorioControl relatorioControl = new RelatorioControl();

    private FacadeCRUD() {}

    public static FacadeCRUD getInstance() {
        if(myInstance == null) {
            synchronized (FacadeCRUD.class){
                if(myInstance == null)
                    myInstance = new FacadeCRUD();
            }
        }

        return myInstance;
    }

    public void addUsuario(Usuario usuario) throws InvalidUsuarioException {
        this.usuarioControl.addUsuario(usuario);
    }

    public void updateUsuario(Usuario usuario, String novaSenha) throws InvalidUsuarioException {
        this.usuarioControl.updateUsuario(usuario, novaSenha);
    }

    public void removeUsuario(Usuario usuario) throws InvalidUsuarioException {
        this.usuarioControl.removeUsuario(usuario);
    }

    public Usuario getUsuario(String login) throws InvalidUsuarioException {
        return this.usuarioControl.getUsuario(login);
    }


    public void addReceita(Receita receita) throws InvalidReceitaException {
        this.receitaControl.addReceita(receita);
    }

    public void updateReceita(Receita receita,State state) throws InvalidReceitaException {
        this.receitaControl.updateReceita(receita, state);
    }

    public void removeReceita(Receita receita) throws InvalidReceitaException {
        this.receitaControl.removeReceita(receita);
    }

    public Receita getReceita(String titulo) throws InvalidReceitaException {
        return this.receitaControl.getReceita(titulo);
    }

    public void addObserver(Usuario usuario){
        receitaControl.attach(usuario);
    }

    public void removeObserver(Usuario usuario){
        receitaControl.detach(usuario);
    }

}
