<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, org.com.dao.*, org.com.model.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Lista Contatos Scriptlet</title>
	</head>

	<body>
		<table>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Email</th>
				<th>Endereço</th>
				<th>Data Nascimento</th>
			</tr>
			
			<% 
				ContatoDAO dao = new ContatoDAO();
				List<Contato> contatos = dao.getAll();
				
				for (Contato contato : contatos) {
			%>
			
			<tr>
				<td><%=contato.getId() %></td>
				<td><%=contato.getNome() %></td>
				<td><%=contato.getEmail() %></td>
				<td><%=contato.getEndereco() %></td>
				<td><%=contato.getDataNascimento().getTime() %></td>
			</tr>
			
			<%
				}
			%>
		</table>
	</body>
</html>