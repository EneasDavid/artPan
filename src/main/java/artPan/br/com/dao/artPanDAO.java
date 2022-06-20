package artPan.br.com.dao;

import java.sql.*;
import java.util.*;

import artPan.br.com.modelo.*;
import artPan.br.com.factory.FabricaConexao;

@SuppressWarnings("unused")

public class artPanDAO {
	//Cartão
	public void cadastrarPadaria(Padaria padaria) throws SQLException{
		// Isso é uma sql comum, os ? são os parametros que nás vamos adicionar na base de dados

		String comandoSQL = "INSERT INTO padaria (nome,endereco) VALUES (?,?);" ;
		Connection rede=null;
		PreparedStatement pstm=null;
		try {
			//Cria uma conexão com o banco de dados
			rede=FabricaConexao.criaConexaoComMySQL();
			
			//Cria uma declaração preparada (PreparedStatment), classe usada para executar a query
			pstm=rede.prepareStatement(comandoSQL);
			
			//Adiciona o valor do primeiro parametro da sql
			pstm.setString(1, padaria.getNome());
			
			//Adicionar o valor do segundo parametro da sql
			pstm.setString(2, padaria.getEndereco());
			
			//Executa a sql para inserção dos dados
			 pstm.executeUpdate();
			 
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			//Pra fechar as conexões
			try{
				 if(pstm != null){
					 pstm.close();
				 }
				 if(rede != null){
					 rede.close();
				 }
			 }catch(Exception e){
				 e.printStackTrace();
			}
		}
	}
	public void removerPadariaPorId(int id) {
		String comandoSQL = "DELETE FROM padaria WHERE id = ?;" ;
		Connection rede=null;
		PreparedStatement pstm=null;
		try {
			//Cria uma conexão com o banco de dados
			rede=FabricaConexao.criaConexaoComMySQL();
			//Cria uma declaração preparada (PreparedStatment), classe usada para executar a query
			pstm = rede.prepareStatement(comandoSQL);
			pstm.setInt(1, id);
			 pstm.execute();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			//Pra fechar as conexões
			try{
				 if(pstm != null){
					 pstm.close();
				 }
				 if(rede != null){
					 rede.close();
				 }
			 }catch(Exception e){
				 e.printStackTrace();
			}
		}
	}
	public void atualizarPadaria(Padaria padaria) {
		String comandoSQL = "UPDATE padaria SET nome= ?, endereco= ? WHERE id = ?";
		Connection rede=null;
		PreparedStatement pstm=null;
		try {
			//Cria uma conexão com o banco de dados
			rede=FabricaConexao.criaConexaoComMySQL();
			
			//Cria uma declaração preparada (PreparedStatment), classe usada para executar a query
			pstm=rede.prepareStatement(comandoSQL);
			
			//Adiciona o valor do primeiro parametro da sql
			pstm.setInt(4, padaria.getId());
			
			//Adiciona o valor do primeiro parametro da sql
			pstm.setString(1, padaria.getNome());
			
			//Adicionar o valor do segundo parametro da sql
			pstm.setString(2, padaria.getEndereco());
			
			//Executa a sql para inserção dos dados
			pstm.execute();
					
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			//Pra fechar as conexões
			try{
				 if(pstm != null){
					 pstm.close();
				 }
				 if(rede != null){
					 rede.close();
				 }
			 }catch(Exception e){
				 e.printStackTrace();
			}
		}
	}
	public List<Padaria> getFiliais(){
		String comandoSQL = "SELECT*FROM padaria;" ;
		List<Padaria> padarias = new ArrayList<>();
		Connection rede=null;
		PreparedStatement pstm=null;
		//Classe que vai recuperar os dados do banco de dados
		ResultSet filiais=null;
		try {
			//Cria uma conexão com o banco de dados
			rede=FabricaConexao.criaConexaoComMySQL();
			
			//Cria uma declaração preparada (PreparedStatment), classe usada para executar a query
			pstm=rede.prepareStatement(comandoSQL);
			
			//Classe que vai recuperar os dados do banco de dados
			filiais=pstm.executeQuery();
			
			//Enquanto existir dados no banco de dados, faça
			 while(filiais.next()){
				 Padaria padaria= new Padaria(0,null,null);
				 
				 //Recupera o id do banco e atribui ele ao objeto
				 padaria.setId(filiais.getInt("id"));
				 
				 //Recupera o número do cartão do banco e atribui ele ao objeto
				 padaria.setNome(filiais.getString("nome"));
				 
				 //Recupera o CVC do banco e atribui ele ao objeto
				 padaria.setEndereco(filiais.getString("endereco"));
				 
				 //Adiciono o contato recuperado, a lista de contatos
				 padarias.add(padaria);
			 }				 
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			//Pra fechar as conexões
			try{
				 if(pstm != null){
					 pstm.close();
				 }
				 if(rede != null){
					 rede.close();
				 }
			 }catch(Exception e){
				 e.printStackTrace();
			}
		}
		return padarias;
	}
	public Padaria selecionarTodasPadaria(int id) {
		Padaria padaria= null;
		Connection rede=null;
		PreparedStatement pstm=null;
		String comandoSQL = "SELECT nome, endereco FROM padaria WHERE ID =?";
		ResultSet buscaCartao=null;
		try {
			//Cria uma conexeção com o banco
			rede= FabricaConexao.criaConexaoComMySQL();
			
			//Cria uma declaração preparada (PreparedStatment), classe usada para executar a query
			pstm=rede.prepareStatement(comandoSQL);
			
			//Passa o id pro comando SQL
			pstm.setInt(1, id);	
			
			//Classe que vai recuperar os dados do banco de dados
			buscaCartao=pstm.executeQuery();
			while (buscaCartao.next()) {
				String nomeP = buscaCartao.getString("nome");
				String endereco = buscaCartao.getString("endereco");
				padaria = new Padaria (id, nomeP, endereco);
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			//Pra fechar as conexões
			try{
				 if(pstm != null){
					 pstm.close();
				 }
				 if(rede != null){
					 rede.close();
				 }
			 }catch(Exception e){
				 e.printStackTrace();
			}
		}
		return padaria;
	}
	
	//Produto
	public void cadastrarProduto(Produto produto) {
		String comandoSQL = "INSERT INTO produto (referencia,preco) VALUES (?,?);" ;
		Connection rede=null;
		PreparedStatement pstm=null;
		try {
			 //Cria uma conexeção com o banco
			 rede= FabricaConexao.criaConexaoComMySQL();
			 
			 //Cria um PreparedStatment, classe usada para executar a query
			 pstm = rede.prepareStatement(comandoSQL);
			 
			 //Adiciona o valor do primeiro parametro da sql
			 pstm.setString(1, produto.getReferencia());
			 
			 //Adicionar o valor do terceiro parametro da sql
			 pstm.setFloat(2, produto.getPreco());
			
			 //Executa a sql para inserção dos dados
			 pstm.execute();
			 
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			//Pra fechar as conexões
			try{
				 if(pstm != null){
					 pstm.close();
				 }
				 if(rede != null){
					 rede.close();
				 }
			 }catch(Exception e){
				 e.printStackTrace();
			}
		}
	}
	public void removerProdutoPorId(int id) {
		String comandoSQL = "DELETE FROM produto WHERE id = ?;" ;
		String comandoSQLZerar="truncate table produto;";
		Connection rede=null;
		PreparedStatement pstm=null;
		try {
			//Cria uma conexão com o banco de dados
			rede=FabricaConexao.criaConexaoComMySQL();
			//Cria uma declaração preparada (PreparedStatment), classe usada para executar a query
			 pstm = rede.prepareStatement(comandoSQL);
			 pstm.setInt(1, id);
			 pstm.execute();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			//Pra fechar as conexões
			try{
				 if(pstm != null){
					 pstm.close();
				 }
				 if(rede != null){
					 rede.close();
				 }
			 }catch(Exception e){
				 e.printStackTrace();
			}
		}
	}
	public void atualizarProduto(Produto produto) {
		Connection rede=null;
		PreparedStatement pstm=null;
		String comandoSQL = "UPDATE produto SET referencia = ?, preco = ? WHERE id = ?";
		try {
			 //Cria uma conexeção com o banco
			 rede= FabricaConexao.criaConexaoComMySQL();
			 
			 //Cria um PreparedStatment, classe usada para executar a query
			 pstm = rede.prepareStatement(comandoSQL);
			 
			 //Adiciona o valor do primeiro parametro da sql
			 pstm.setInt(3, produto.getId());
			 
			 //Adiciona o valor do primeiro parametro da sql
			 pstm.setString(1, produto.getReferencia());
			 
			 //Adicionar o valor do terceiro parametro da sql
			 pstm.setFloat(2, produto.getPreco());
			
			 //Executa a sql para inserção dos dados
			 pstm.execute();
			 
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			//Pra fechar as conexões
			try{
				 if(pstm != null){
					 pstm.close();
				 }
				 if(rede != null){
					 rede.close();
				 }
			 }catch(Exception e){
				 e.printStackTrace();
			}
		}
	}
	public List<Produto> getEstoque(){
	
		String comandoSQL = "SELECT*FROM produto;" ;
		List<Produto> estoque = new ArrayList<>();
		Connection rede=null;
		PreparedStatement pstm=null;
		
		//Classe que vai recuperar os dados do banco de dados
		ResultSet ConferirEstoque=null;
				try {
					//Cria uma conexão com o banco de dados
					rede=FabricaConexao.criaConexaoComMySQL();
					
					//Cria uma declaração preparada (PreparedStatment), classe usada para executar a query
					pstm=rede.prepareStatement(comandoSQL);
					
					//Classe que vai recuperar os dados do banco de dados
					ConferirEstoque=pstm.executeQuery();
					
					//Enquanto existir dados no banco de dados, faça
					 while(ConferirEstoque.next()){
						 Produto produtos= new Produto(0,null,0);
						 
						 //recupera o número do cartão do banco e atribui ele ao objeto
						 produtos.setId(ConferirEstoque.getInt("id"));
						 
						 //recupera o número do cartão do banco e atribui ele ao objeto
						 produtos.setReferencia(ConferirEstoque.getString("referencia"));						 

						 //Recupera o CVC do banco e atribui ele ao objeto
						 produtos.setPreco(ConferirEstoque.getFloat("preco"));
						 
						 //Adiciono o contato recuperado, a lista de contatos
						 estoque.add(produtos);
					 }				 
				}catch (Exception e){
					e.printStackTrace();
				}finally {
					//Pra fechar as conexões
					try{
						 if(pstm != null){
							 pstm.close();
						 }
						 if(rede != null){
							 rede.close();
						 }
					 }catch(Exception e){
						 e.printStackTrace();
					}
				}
		return estoque;
		}
	public Produto selecionarTodosProdutos(int id) {
		Produto produto= null;
		Connection rede=null;
		PreparedStatement pstm=null;
		String comandoSQL = "SELECT referencia,preco FROM PRODUTO WHERE ID =?";
		ResultSet buscaProduto=null;
		try {
			//Cria uma conexeção com o banco
			rede= FabricaConexao.criaConexaoComMySQL();
			
			//Cria uma declaração preparada (PreparedStatment), classe usada para executar a query
			pstm=rede.prepareStatement(comandoSQL);
			
			//Passa o id pro comando SQL
			pstm.setInt(1, id);	
			
			//Classe que vai recuperar os dados do banco de dados
			buscaProduto=pstm.executeQuery();
			while (buscaProduto.next()) {
				String referencia = buscaProduto.getString("referencia");
				float preco = buscaProduto.getFloat("preco");
				produto = new Produto(id, referencia, preco);
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			//Pra fechar as conexões
			try{
				 if(pstm != null){
					 pstm.close();
				 }
				 if(rede != null){
					 rede.close();
				 }
			 }catch(Exception e){
				 e.printStackTrace();
			}
		}
		return produto;
	}
	
	//Fornecedor
	public void cadastrarFornecedor(Fornecedor fornecedor) {
		String comandoSQL = "INSERT INTO fornecedor (nomeFantasia,cnpj) VALUES (?,?) ;" ;
		Connection rede=null;
		PreparedStatement pstm=null;
		try {
			 //Cria uma conexeção com o banco
			 rede= FabricaConexao.criaConexaoComMySQL();
			 
			 //Cria um PreparedStatment, classe usada para executar a query
			 pstm = rede.prepareStatement(comandoSQL);
			 
			//Adiciona o valor do primeiro parametro da sql
			 pstm.setString(1, fornecedor.getNomeFantasia());
			 
			 //Adicionar o valor do segundo parametro da sql
			 pstm.setString(2, fornecedor.getCnpj());
			
			 //Executa a sql para inserção dos dados
			 pstm.execute();
		
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			//Pra fechar as conexões
			try{
				 if(pstm != null){
					 pstm.close();
				 }
				 if(rede != null){
					 rede.close();
				 }
			 }catch(Exception e){
				 e.printStackTrace();
			}
		}
	}
	public void removerFornecedorPorId(int id) {
		String comandoSQL = "DELETE FROM fornecedor WHERE id = ?;" ;
		String comandoSQLZerar="truncate table pedido;";
		Connection rede=null;
		PreparedStatement pstm=null;
		try {
			//Cria uma conexão com o banco de dados
			rede=FabricaConexao.criaConexaoComMySQL();
			//Cria uma declaração preparada (PreparedStatment), classe usada para executar a query
			 pstm = rede.prepareStatement(comandoSQL);
			 pstm.setInt(1, id);
			 pstm.execute();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			//Pra fechar as conexões
			try{
				 if(pstm != null){
					 pstm.close();
				 }
				 if(rede != null){
					 rede.close();
				 }
			 }catch(Exception e){
				 e.printStackTrace();
			}
		}
	}
	public void atualizarFornecedor(Fornecedor fornecedor) {
		Connection rede=null;
		PreparedStatement pstm=null;
		String comandoSQL = "UPDATE fornecedor SET nomeFantasia = ?, cnpj = ? WHERE id = ?";
		try {
			 //Cria uma conexeção com o banco
			 rede= FabricaConexao.criaConexaoComMySQL();
			 
			 //Cria um PreparedStatment, classe usada para executar a query
			 pstm = rede.prepareStatement(comandoSQL);
			 
			//Adiciona o valor do primeiro parametro da sql
			 pstm.setInt(3, fornecedor.getId());
			 
			 //Adiciona o valor do primeiro parametro da sql
			 pstm.setString(1, fornecedor.getNomeFantasia());
			 
			 //Adicionar o valor do segundo parametro da sql
			 pstm.setString(2, fornecedor.getCnpj());

			 //Executa a sql para inserção dos dados
			 pstm.execute();
			 
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			//Pra fechar as conexões
			try{
				 if(pstm != null){
					 pstm.close();
				 }
				 if(rede != null){
					 rede.close();
				 }
			 }catch(Exception e){
				 e.printStackTrace();
			}
		}
	}
	public List<Fornecedor> getOrdens(){	
		String comandoSQL = "SELECT*FROM fornecedor;" ;
		List<Fornecedor> fornecedores= new ArrayList<>();
		Connection rede=null;
		PreparedStatement pstm=null;
		
		//Classe que vai recuperar os dados do banco de dados
		ResultSet fornecedor=null;
				try {
					//Cria uma conexão com o banco de dados
					rede=FabricaConexao.criaConexaoComMySQL();
					
					//Cria uma declaração preparada (PreparedStatment), classe usada para executar a query
					pstm=rede.prepareStatement(comandoSQL);
					
					//Classe que vai recuperar os dados do banco de dados
					fornecedor=pstm.executeQuery();
					
					//Enquanto existir dados no banco de dados, faça
					 while(fornecedor.next()){
						 Fornecedor empresa= new Fornecedor(0, null, null);
						//recupera o número do cartão do banco e atribui ele ao objeto
						 empresa.setId(fornecedor.getInt("id"));
						 //recupera a referencia do banco e atribui ele ao objeto
						 empresa.setNomeFantasia(fornecedor.getString("nomeFantasia"));
						 //Recupera o tamanho do banco e atribui ele ao objeto
						 empresa.setCnpj(fornecedor.getString("cnpj"));
						//Recupera o tamanho do banco e atribui ele ao objeto

						 //Adiciono o contato recuperado, a lista de contatos
						 fornecedores.add(empresa);
					 }				 
				}catch (Exception e){
					e.printStackTrace();
				}finally {
					//Pra fechar as conexões
					try{
						 if(pstm != null){
							 pstm.close();
						 }
						 if(rede != null){
							 rede.close();
						 }
					 }catch(Exception e){
						 e.printStackTrace();
					}
				}
		return fornecedores;
	}
	public Fornecedor selecionarTodosFornecedor(int id) {
		Fornecedor fornecedor= null;
		Connection rede=null;
		PreparedStatement pstm=null;
		String comandoSQL = "SELECT nomeFantasia,cnpj  FROM FORNECEDOR WHERE ID =?";
		ResultSet buscaPedidos=null;
		try {
			//Cria uma conexeção com o banco
			rede= FabricaConexao.criaConexaoComMySQL();
			
			//Cria uma declaração preparada (PreparedStatment), classe usada para executar a query
			pstm=rede.prepareStatement(comandoSQL);
			
			//Passa o id pro comando SQL
			pstm.setInt(1, id);	
			
			//Classe que vai recuperar os dados do banco de dados
			buscaPedidos=pstm.executeQuery();
			while (buscaPedidos.next()) {
				String nomeFantasia = buscaPedidos.getString("nomeFantasia");
				String cnpj= buscaPedidos.getString("cnpj");
				fornecedor = new Fornecedor(id, nomeFantasia,cnpj);
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			//Pra fechar as conexões
			try{
				 if(pstm != null){
					 pstm.close();
				 }
				 if(rede != null){
					 rede.close();
				 }
			 }catch(Exception e){
				 e.printStackTrace();
			}
		}
		return fornecedor;
	}
	
}