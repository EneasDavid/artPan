package artPan.br.com.modelo;

public class Produto {
	
	private int id;
	private String referencia;
	private float preco;
	
	public Produto(String referencia, float preco) {
		this.referencia = referencia;
		this.preco = preco;
	}
	
	public Produto(int id, String referencia, float preco) {
		this.id = id;
		this.referencia = referencia;
		this.preco = preco;
	}
	
	public int getId() {
		return id;
	}
	public String getReferencia() {
		return referencia;
	}
	public float getPreco() {
		return preco;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	public void setReferencia(String referencia) {
		this.referencia=referencia;
	}
	public void setPreco(float preco) {
		this.preco=preco;
	}
	
}
