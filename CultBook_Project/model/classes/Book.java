package classes;
import java.io.Serializable;

public class Book implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ISBN;
	private String Titulo;
	private int ano;
	private int edicao;
	private String editora;
	private String autor;

	public Book(int ISBN, String Titulo, int ano, int edicao, String editora, String autor) {
		this.ano = ano;
		this.edicao = edicao;
		this.editora = editora;
		this.Titulo = Titulo;
		this.ISBN = ISBN;
		this.autor = autor;
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "ISBN: " +  this.ISBN + "<br>Título: " + this.Titulo + "<br>Autor: " + this.autor + "<br>Editora: " + this.editora
				+ "<br>Edicao: " + this.edicao + "<br>Ano:" + this.ano + "<br>";
	}
	
	
}
