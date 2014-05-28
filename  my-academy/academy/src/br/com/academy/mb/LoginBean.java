package br.com.academy.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import br.com.academy.dao.UsuarioDAO;
import br.com.academy.model.Usuario;

@SessionScoped
@ManagedBean
public class LoginBean {
	
	private Usuario usuario = new Usuario();
	
	public String efetuaLogin(){
		UsuarioDAO dao = new UsuarioDAO();
		boolean loginValido = dao.existe(this.usuario);
		//System.out.println("O login era valido? " +loginValido);
		if (loginValido) {
			return "menu?faces-redirect=true";
		}else{
			this.usuario = new Usuario();
			return "login";
		}
	}
	
	public boolean isLogado(){
		return usuario.getLogin() != null;
	}
	
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}

}
