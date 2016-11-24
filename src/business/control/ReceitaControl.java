package business.control;

import business.model.Receita;
import business.model.Usuario;
import business.state.State;
import utils.StringUtils;

import java.util.HashSet;

/**
 * Created by UFPB-CIA-03 on 09/11/2016.
 */
public class ReceitaControl {

    HashSet<Receita> receitaList = new HashSet<>();
    HashSet<Usuario> usuarioObserverList = new HashSet<>();

    public void attach(Usuario observer) {
        usuarioObserverList.add(observer);
    }

    public void detach(Usuario usuario) {

        usuarioObserverList.remove(usuario);

    }

    private void notifyObservers(String titulo) {
        for (Usuario observer : usuarioObserverList) {
            observer.update(titulo);
        }
    }

    public void addReceita(Receita receita) throws InvalidReceitaException {


        for(Receita u : receitaList){
            if(u.getTitulo() == receita.getTitulo())
                throw new InvalidReceitaException(StringUtils.ERRO_RECEITA_EXISTENTE);
        }

//		if(usuarioList.contains(usuario)){
//			throw new InvalidUsuarioException(StringUtils.ERRO_LOGIN_EXISTENTE);
//		}

        //chamar persistencia

        receitaList.add(receita);
        notifyObservers(receita.getTitulo());
    }

    public void updateReceita(Receita receita, State state) throws InvalidReceitaException{
        if(validaExistente(receita)) {

            receita.setState(state);
        }
    }

    public void removeReceita(Receita receita) throws InvalidReceitaException{
        if(validaExistente(receita)){
            receitaList.remove(receita);
        }
    }

    public Receita getReceita(String titulo) throws InvalidReceitaException {
        Receita receita = new Receita(titulo);
        for(Receita u : receitaList){
            if(u.equals(receita))
                return u;
        }
        throw new InvalidReceitaException(StringUtils.ERRO_RECEITA_INEXISTENTE);
    }



    private boolean validaExistente(Receita receita) throws InvalidReceitaException{
        if(receitaList.contains(receita))
            return true;
        throw new InvalidReceitaException(StringUtils.ERRO_RECEITA_INEXISTENTE);
    }
    // gerencia as receitas
}
