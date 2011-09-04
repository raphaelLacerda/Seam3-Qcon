package br.com.qcon.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Livro {

	@Id
	@GeneratedValue
	private int		id;
	private String	nome;

	public Livro() {

	}

	public Livro(String nome) {

		this.nome = nome;
	}

	public int getId() {

		return id;
	}

	public void setId(int id) {

		this.id = id;
	}

	public String getNome() {

		return nome;
	}

	public void setNome(String nome) {

		this.nome = nome;
	}

	@Override
	public String toString() {

		if (this.nome != null) {
			return "Livro: " + this.nome;
		} else {
			return "Livro ainda não foi criado";
		}
	}
}
