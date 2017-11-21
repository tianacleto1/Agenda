<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<!-- link href="css/jquery-ui.css" rel="stylesheet" -->
		<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
		<!-- script src="js/jquery-ui.js"></script>
		<script src="js/jquery.js"></script -->
		
		<title>Adiciona Contatos</title>
	</head>
	
	<body>
		<c:import url="header.jsp" />
		
		<h1>Adiciona Contatos</h1>
		<hr />
		
		<form action="adicionaContato">
			<p>Nome: <input type="text" name="nome" /></p>
			<p>E-mail: <input type="text" name="email" /></p>
			<p>Endereço: <input type="text" name="endereco" /></p>
			<p>Data Nascimento: <caelum:campoData id="dataNascimento" /></p>
			
			<input type="submit" value="Gravar" />
		</form>
		
		<c:import url="bottom.jsp" />
	</body>
</html>