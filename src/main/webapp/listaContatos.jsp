<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Lista Contatos JSTL</title>
	</head>
	
	<body>
		<c:import url="header.jsp" />
		
		<jsp:useBean id="dao" class="org.com.dao.ContatoDAO"/>
		
		<table>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Email</th>
				<th>Endere�o</th>
				<th>Data Nascimento</th>
			</tr>
			
			<c:forEach var="contato" items="${dao.all}" varStatus="id">
				<tr bgcolor="#${id.count % 2 == 0 ? 'aaaaaa' : 'ffffff'}">
					<td>${contato.id}</td>
					<td>${contato.nome}</td>
					<td>
						<c:if test="${not empty contato.email}">
							<a href="mailto:${contato.email}">${contato.email}</a>
						</c:if>
						
						<c:if test="${empty contato.email}">
							Email n�o informado
						</c:if>
					</td>
					<td>${contato.endereco}</td>
					<td>
						<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" />
					</td>
				</tr>
			</c:forEach>
		</table>
		
		<c:import url="bottom.jsp" />
	</body>
</html>