<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Cadastrar Forncedor</title>
	</head>
	<body>	
		<main>
			<h2>		       	
			<a href="/artPan/">Cancelar</a>
		   </h2>		
		   <div align="center">
			<c:if test="${fornecedor != null}">
				<form action="editarFornecedor" method="post">
	        </c:if>
	        <c:if test="${fornecedor == null}">
				<form action="novoFornecedor" method="post">
	        </c:if>
		    <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${fornecedor != null}">
            			Altere as informações do Fornecedor
            		</c:if>
            		<c:if test="${fornecedor == null}">
            			Adicione as informações do Fornecedor
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${fornecedor != null}">
        			<input type="hidden" name="id" value="<c:out value='${fornecedor.id}' />" />
        		</c:if>            
            <tr>
                <th>Nome Fantasia: </th>
                <td>
                	<input type="text" name="nomeFantasia"  value="<c:out value='${fornecedor.nomeFantasia}'/>"/>
                </td>
            </tr>
            <tr>
                <th>Cnpj: </th>
                <td>
                	<input type="text" name="cnpj" value="<c:out value='${fornecedor.cnpj}' />"/>
                </td>
            </tr>
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value=<c:if test="${fornecedor == null}">Salvar</c:if><c:if test="${fornecedor != null}">Editar</c:if>>
            	</td>
            </tr>
        </table>
        </form>
	</div>
		</main>
		<footer>
		</footer>
	</body>
</html>	