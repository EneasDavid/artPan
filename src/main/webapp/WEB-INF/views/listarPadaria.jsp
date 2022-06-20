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
				<a href="/artPan/">Estoque</a>
		       	&nbsp;&nbsp;&nbsp;
		        <a href="novoFormularioFornecedor">Adicione um novo Fornecedor</a>
				&nbsp;&nbsp;&nbsp;
		        <a href="ListarFornecedor">liste todos os pedidos</a>
		        &nbsp;&nbsp;&nbsp;
		        <a href="novoFormularioProduto">Adicione um novo produto</a>
		   </h2>
			<div align="center">
	        <table border="1" cellpadding="5">
	            <caption><h2>Lista de Padarias</h2></caption>
	            <tr>
	                <th>ID</th>
	                <th>Nome</th>
	                <th>Endereço</th>
	                <th>Ação</th>
	                
	            </tr>
	            <c:forEach var="padaria" items="${padaria}">
	                <tr>
	                    <td><c:out value="${padaria.id}" /></td>
	                    <td><c:out value="${padaria.nome}" /></td>
	                    <td><c:out value="${padaria.endereco}" /></td>
	                    <td>
	                    	<a href="FormularioEditarCartao?id=<c:out value='${padaria.id}' />">Editar</a>
	                    	&nbsp;&nbsp;&nbsp;&nbsp;
	                    	<a href="excluirCartao?id=<c:out value='${padaria.id}' />">Deletar</a>                    	
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