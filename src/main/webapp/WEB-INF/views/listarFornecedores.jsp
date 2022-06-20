<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ArtPan - Padaria</title>
	</head>
	<body>	
		<main>
			<h2>
		      	<a href="novoFormularioPadaria">Adicione uma nova Padaria</a>
		       	&nbsp;&nbsp;&nbsp;
				<a href="ListarPadaria">liste todas as Padarias</a>
		       	&nbsp;&nbsp;&nbsp;
		        <a href="novoFormularioFornecedor">Adicione um novo Fornecedor</a>
				&nbsp;&nbsp;&nbsp;
		        <a href="/artPan/">Estoque</a>
		        &nbsp;&nbsp;&nbsp;
		        <a href="novoFormularioProduto">Adicione um novo produto</a>
		   </h2>
			<div align="center">
	        <table border="1" cellpadding="5">
	            <caption><h2>Lista de Fornecedores</h2></caption>
	            <tr>
	                <th>ID</th>
	                <th>Nome Fantasia</th>
	                <th>CNPJ</th>
	                <th>Ação</th>
	                
	            </tr>
	            <c:forEach var="fornecedor" items="${fornecedor}">
	                <tr>
	                    <td><c:out value="${fornecedor.id}"/></td>
	                    <td><c:out value="${fornecedor.nomeFantasia}" /></td>
	                    <td><c:out value="${fornecedor.cnpj}" /></td>
	                    <td>
	                    	<a href="FormularioEditarFornecedor?id=<c:out value='${fornecedor.id}' />">Editar</a>
	                    	&nbsp;&nbsp;&nbsp;&nbsp;
	                    	<a href="excluirFornecedor?id=<c:out value='${fornecedor.id}' />">Deletar</a>                    	
	                    </td>
	                </tr>
	            </c:forEach>
	        </table>
	    </div>			
		</main>
		<footer>
		</footer>
	</body>
</html>	