<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Cadastrar Padaria</title>
	</head>
	<body>	
		<main>
			<h2>		       	
			<a href="/artPan/">Cancelar</a>
		   </h2>		
		   <div align="center">
			<c:if test="${padaria != null}">
				<form action="editarPadaria" method="post">
	        </c:if>
	        <c:if test="${padaria == null}">
				<form action="novaPadaria" method="post">
	        </c:if>
		    <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${padaria != null}">
            			Altere as informações da filial
            		</c:if>
            		<c:if test="${padaria == null}">
            			Adicione as informações da filial
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${padaria != null}">
        			<input type="hidden" name="id" value="<c:out value='${padaria.id}' />" />
        		</c:if>            
            <tr>
                <th>Nome: </th>
                <td>
                	<input type="text" name="nome"  value="<c:out value='${padaria.nome}'/>"/>
                </td>
            </tr>
            <tr>
                <th>Endereço: </th>
                <td>
                	<input type="text" name="endereco" value="<c:out value='${padaria.endereco}' />"/>
                </td>
            </tr>
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value=<c:if test="${padaria == null}">Salvar</c:if><c:if test="${padaria != null}">Editar</c:if>>
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