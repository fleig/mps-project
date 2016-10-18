package business.model;

public class Usuario {
	private String login;
	private String senha;
	
	public Usuario(){}

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
		hashCode = 89 * hashCode + senha.hashCode();
		return hashCode;
	}
}
