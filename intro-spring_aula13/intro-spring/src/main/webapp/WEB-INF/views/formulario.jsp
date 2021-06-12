<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exercício</title>
</head>
<body>
	
	<form:form method="POST" modelAttribute="morador" action="cadastro">
		<p>Nome: <form:input path="nome"/></p>
		<p>Local: <form:input path="local"/></p>
		<p><form:button>Enviar</form:button></p>
		<p>${mensagem}</p>
	</form:form>
	
	<p>
		<table>
		   <thead>
		    <tr>
		     <th>NOME</th>
		     <th>LOCAL</th>
		     <th>AÇÃO</th>
		    </tr>
		   </thead>
		   <tbody>
		     <c:forEach var="morador" items="${moradores}">
		      <tr>
		       <td>${morador.nome}</td>
		       <td>${morador.local}</td>
		       <td>
		        <a href="editar/${moradores.indexOf(morador)}">Editar</a>
		        <a href="excluir/${moradores.indexOf(morador)}">Excluir</a>
		       </td>
		      </tr>
		     </c:forEach>
		    </tbody>
		</table>
	<p>

</body>
</html>