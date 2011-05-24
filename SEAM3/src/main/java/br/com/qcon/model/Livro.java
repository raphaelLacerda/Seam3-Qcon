package br.com.qcon.model;


//@Entity
//@Cacheable(value = false)
public class Livro {

//	@Id
//	@GeneratedValue
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

	@Override
	public String toString() {

		if (this.nome != null) {
			return "Livro: " + this.nome;
		} else {
			return "Livro ainda n‹o foi criado";
		}
	}
}
