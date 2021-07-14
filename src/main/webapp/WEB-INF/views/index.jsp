<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agenda Home</title>

<link href="/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

	<spring:url value="/agenda/edita" var="edita" />
	<spring:url value="/agenda/deleta" var="deleta" />

	<jsp:include page="comum/header.jsp"></jsp:include>

	<div class="container">
		<div class="container">
			<h1>Compromissos</h1>

			<c:if test="${not empty agendas}">
				<!-- vereificação se a lista tarefas é nula -->
				<table class="table">

					<tr>
						<th width="40%">Nome</th>
						<th width="20%">Data do Compromisso</th>
						<th width="20%">Data do Cadastro</th>
						<th width="5%" colspan="2">Ações</th>
					</tr>
					<c:forEach var="agenda" items="${agendas}">

						<tr>
							<td>${agenda.nome}</td>
							<td>${agenda.dataAgendamento}</td>
							<td>${agenda.dataCriacao}</td>
							<td><a href="${edita}/${agenda.id}" class="btn btn-warning">Editar</a></td>
							<td><a href="${deleta}/${agenda.id}" class="btn btn-danger">Deletar</td>
						</tr>

					</c:forEach>

				</table>
			</c:if>
		</div>
	</div>

	<script type="text/javascript" src="/js/jquery.js"></script>
	<script type="text/javascript" src="/js/bootstrap.min.js"></script>
</body>
</html>