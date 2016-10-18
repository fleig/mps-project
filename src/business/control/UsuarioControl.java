package business.control;

import java.util.HashSet;

import business.model.Usuario;
import utils.StringUtils;

public class UsuarioControl {
	
	HashSet<Usuario> usuarioList = new HashSet<>();

	public void addUsuario(Usuario usuario) throws InvalidUsuarioException {
		usuario.setLogin(usuario.getLogin().replaceAll(" ", ""));
		usuario.setSenha(usuario.getSenha().replaceAll(" ", ""));
		
		validaLogin(usuario.getLogin());
		validaSenha(usuario.getSenha());
		
		if(usuarioList.contains(usuario)){
			throw new InvalidUsuarioException(StringUtils.ERRO_LOGIN_EXISTENTE);
		}
		
		//chamar persistencia
		usuarioList.add(usuario);
	}

	public void updateUsuario(Usuario usuario, String novaSenha) throws InvalidUsuarioException{
		if(validaExistente(usuario)) {
			validaSenha(novaSenha);
			usuario.setSenha(novaSenha);
		}
	}

	public void removeUsuario(Usuario usuario) throws InvalidUsuarioException{
		if(validaExistente(usuario)){
			usuarioList.remove(usuario);
		} else {
			throw new InvalidUsuarioException(StringUtils.ERRO_LOGIN_INEXISTENTE);
		}
	}

	public Usuario getUsuario(String login) throws InvalidUsuarioException {
		Usuario usuario = new Usuario(login);
		for(Usuario u : usuarioList){
			if(u.equals(usuario))
				return u;
		}
		throw new InvalidUsuarioException(StringUtils.ERRO_LOGIN_INEXISTENTE);
	}

	private void validaLogin(String login) throws InvalidUsuarioException{
		if(login.isEmpty()
				|| login.length() >= 20
				|| login.matches(".*\\d.*")) {
			throw new InvalidUsuarioException(StringUtils.ERRO_LOGIN);
		}
	}

	private void validaSenha(String senha) throws InvalidUsuarioException{
		if(senha.length() < 8
				|| senha.length() > 12
				|| !possuiNumero(senha)) {
			throw new InvalidUsuarioException(StringUtils.ERRO_SENHA);
		}
	}

	private boolean validaExistente(Usuario usuario) throws InvalidUsuarioException{
		if(usuarioList.contains(usuario))
			return true;
		throw new InvalidUsuarioException(StringUtils.ERRO_LOGIN_INEXISTENTE);
	}

	private boolean possuiNumero(String s){
		int numbers = 0;

		for(char c : s.toCharArray())
		{
			if(Character.isDigit(c))
				++numbers;
		}

		if(numbers < 2)
			return false;

		return true;
	}
}
