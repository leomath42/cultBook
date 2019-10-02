package classes;

import java.io.Serializable;

public class Usuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String login;
	private String nome;
	private String email;
	private String telefone;
	private String endereco;
	private String senha;
	
	public Usuario(String login, String nome, String email, String telefone,  String endereco, String senha ) {
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	
	public String toString() {
		return "<br> "+ login + "<br> " + nome;
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
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}


	public boolean equals(Object usuario) {
		if(usuario == null)
			return false;
		if(!(usuario instanceof Usuario))
			return false;
		if(this.getClass() != usuario.getClass())
			return false;
		Usuario user = (Usuario)usuario;
		if(user.login == null)
			return false;
		
		return this.login.equals(user.login);
		
	}
	public int compareTo(Usuario usuario) {
		return this.login.compareTo(usuario.login);
		
	}
}
