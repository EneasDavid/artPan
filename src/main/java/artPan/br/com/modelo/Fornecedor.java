package artPan.br.com.modelo;
public class Fornecedor {
	 
	private int id;
	private String nomeFantasia;
	private String cnpj;

	public Fornecedor(String nomeFantasia, String cnpj) {
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
	}
	
	public Fornecedor(int id, String nomeFantasia, String cnpj) {
		this.id = id;
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
	}
	
	public int getId() {
		return id;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
		
}
