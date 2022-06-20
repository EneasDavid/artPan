package artPan.br.com.modelo;
public class Padaria {
	
	private int id;
	private String nome;
	private String endereco;
	
	public Padaria(int id, String nome, String endereco) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
	}
	
	public Padaria(String nome, String endereco) {
		this.nome = nome;
		this.endereco = endereco;
	}
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getEndereco() {
		return endereco;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	public void setNome(String nome) {
		this.nome=nome;
	}
	public void setEndereco(String endereco) {
		this.endereco=endereco;
	}

}
