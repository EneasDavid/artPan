package artPan.br.com.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import artPan.br.com.modelo.*;
import artPan.br.com.dao.artPanDAO;

/**
 * Servlet implementation class hipertrofiaServlet
 */
@WebServlet("/")
public class artPanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private artPanDAO dao;
	
	public void init () {
		dao= new artPanDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String acao = request.getServletPath();

		try {
			System.out.println(acao);
			switch (acao) {
			/*Cadastro
			 * redirecionamento pro Formularios
			 * */
			//Produto
			case "/ListarProduto":
				listarProduto(request, response);
				break;
			case "/novoFormularioProduto":
				novoFormularioProduto(request, response);
				break;
			case "/novoProduto":
				adicionarProduto(request, response);
				break;
			case "/editarProduto":
				editarProduto(request, response);
				break;
			case "/excluirProduto":
				excluirProduto(request, response);
				break;
			case "/FormularioEditarProduto":
				formularioEditarProduto(request, response);
				break;
			//Padaria
			case "/ListarPadaria":
				listarPadaria(request, response);
				break;
			case "/novoFormularioPadaria":
				novoFormularioPadaria(request, response);
				break;
			case "/novaPadaria":
				adicionarPadaria(request, response);
				break;
			case "/editarPadaria":
				editarPadaria(request, response);
				break;
			case "/excluirPadaria":
				excluirPadaria(request, response);
				break;
			case "/FormularioEditarPadaria":
				formularioEditarPadaria(request, response);
				break;
			//Fornecedor
			case "/ListarFornecedor":
				listarFornecedor(request, response);
				break;
			case "/novoFormularioFornecedor":
				novoFormularioFornecedor(request, response);
				break;
			case "/novoFornecedor":
				adicionarFornecedor(request, response);
				break;
			case "/editarFornecedor":
				editarFornecedor(request, response);
				break;
			case "/excluirFornecedor":
				excluirFornecedor(request, response);
				break;
			case "/FormularioEditarFornecedor":
				formularioEditarFornecedor(request, response);
				break;
			default:
				listarProduto(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	//Produto
	private void listarProduto(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		List<Produto> getEstoque = dao.getEstoque();
		request.setAttribute("estoque", getEstoque);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/index.jsp");
		dispatcher.forward(request, response);
	}
	private void novoFormularioProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/cadastroProduto.jsp");
		dispatcher.forward(request, response);
	}
	private void adicionarProduto(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		var referencia = request.getParameter("referencia");
		var preco = Float.parseFloat(request.getParameter("preco"));
		Produto cadastrarProduto= new Produto(referencia,preco);
		dao.cadastrarProduto(cadastrarProduto);
		response.sendRedirect("inicio");
	}
	private void formularioEditarProduto(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int index = Integer.parseInt(request.getParameter("id"));
		Produto existeProduto = dao.selecionarTodosProdutos(index);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/cadastroProduto.jsp");
		System.out.println(existeProduto.getReferencia());
		request.setAttribute("produto", existeProduto);
		dispatcher.forward(request, response);

	}
	private void editarProduto(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int index = Integer.parseInt(request.getParameter("id"));
		var referencia = request.getParameter("referencia");
		var tamanho = request.getParameter("tamanho");
		var preco = Float.parseFloat(request.getParameter("preco"));
		Produto atualizarProduto= new Produto(index,referencia,preco);
		dao.atualizarProduto(atualizarProduto);
		response.sendRedirect("ListarFornecedor");
	}
	private void excluirProduto(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		dao.removerProdutoPorId(id);
		response.sendRedirect("listarProduto");
	}
	//Padaria
	private void listarPadaria(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		List<Padaria> getEstoque = dao.getFiliais();
		request.setAttribute("padaria", getEstoque);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/listarPadaria.jsp");
		dispatcher.forward(request, response);
	}
	private void novoFormularioPadaria(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/cadastroPadaria.jsp");
		dispatcher.forward(request, response);
	}
	private void adicionarPadaria(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		var nome = request.getParameter("nome");
		var endereco = request.getParameter("endereco");
		Padaria cadastrarPadaria= new Padaria(nome,endereco);
		dao.cadastrarPadaria(cadastrarPadaria);
		response.sendRedirect("inicio");
	}
	private void formularioEditarPadaria(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int index = Integer.parseInt(request.getParameter("id"));
		Padaria existePadaria = dao.selecionarTodasPadaria(index);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/cadastroPadaria.jsp");
		request.setAttribute("padaria", existePadaria);
		dispatcher.forward(request, response);

	}
	private void editarPadaria(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int index = Integer.parseInt(request.getParameter("id"));
		var nome = request.getParameter("nome");
		var endereco = request.getParameter("endereco");
		Padaria atualizarPadaria= new Padaria(index,nome,endereco);
		dao.atualizarPadaria(atualizarPadaria);
		response.sendRedirect("listaPadaria");
	}
	private void excluirPadaria(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		dao.removerPadariaPorId(id);
		response.sendRedirect("listarPadaria");
	}
	//Fornecedor
		private void listarFornecedor(final HttpServletRequest request, final HttpServletResponse response)
				throws ServletException, IOException {
			List<Fornecedor> getFornecedores = dao.getOrdens();
			request.setAttribute("fornecedor", getFornecedores);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/listarFornecedores.jsp");
			dispatcher.forward(request, response);
		}
		private void novoFormularioFornecedor(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/cadastroFornecedor.jsp");
			dispatcher.forward(request, response);
		}
		private void adicionarFornecedor(HttpServletRequest request, HttpServletResponse response) 
				throws SQLException, IOException {
			var nomeFantasia = request.getParameter("nomeFantasia");
			var cnpj = request.getParameter("cnpj");
			Fornecedor cadastrarFornecedor= new Fornecedor(nomeFantasia,cnpj);
			dao.cadastrarFornecedor(cadastrarFornecedor);
			response.sendRedirect("ListarFornecedor");
		}
		private void formularioEditarFornecedor(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, ServletException, IOException {
			int index = Integer.parseInt(request.getParameter("id"));
			Fornecedor existeFornecedor = dao.selecionarTodosFornecedor(index);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/cadastroFornecedor.jsp");
			request.setAttribute("fornecedor", existeFornecedor);
			dispatcher.forward(request, response);

		}
		private void editarFornecedor(HttpServletRequest request, HttpServletResponse response) 
				throws SQLException, IOException {
			int index = Integer.parseInt(request.getParameter("id"));
			var nomeFantasia = request.getParameter("nomeFantasia");
			var cnpj = request.getParameter("cnpj");
			Fornecedor atualizarFornecedor= new Fornecedor(index,nomeFantasia,cnpj);
			dao.atualizarFornecedor(atualizarFornecedor);
			response.sendRedirect("listaFornecedor");
		}
		private void excluirFornecedor(HttpServletRequest request, HttpServletResponse response) 
				throws SQLException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			dao.removerFornecedorPorId(id);
			response.sendRedirect("ListarFornecedor");
		}
}
