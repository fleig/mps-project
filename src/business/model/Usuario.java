package business.model;

import business.control.FacadeCRUD;
import business.control.InvalidReceitaException;
import business.control.InvalidUsuarioException;
import utils.StringUtils;

import java.util.ArrayList;

public class Usuario {
	private String login;
	private String senha;
	private ArrayList<String> novas_receitas = new ArrayList<>();



	public Usuario(String login) {
		this.login = login;
	}

	public Usuario(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}


	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void update(String titulo) {
		// envia notificação
		novas_receitas.add(titulo);
		System.out.println(this.getLogin()+", nova receita adicionada");
	}

	public void visualizarNovasReceitas() throws InvalidReceitaException{

		for(String titulo: novas_receitas){
			try {
				FacadeCRUD.getInstance().getReceita(titulo);
				System.out.println("receita :"+ titulo);
			} catch (InvalidReceitaException e) {
				System.out.println("a receita "+titulo+" nao está mais disponivel");

				throw new InvalidReceitaException(StringUtils.ERRO_RECEITA_INEXISTENTE);
			}

		}

	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Usuario)){
			return false;
		}
		if(((Usuario) obj).getLogin() == this.login){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = login.hashCode();
		hashCode = 31 * hashCode + senha.hashCode();
		return hashCode;
	}
}
