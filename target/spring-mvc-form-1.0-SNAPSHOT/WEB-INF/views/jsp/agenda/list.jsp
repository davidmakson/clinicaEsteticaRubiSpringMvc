<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />

<body>

	<div class="container">

		<c:if test="${not empty msg}">
			<div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<strong>${msg}</strong>
			</div>
		</c:if>

		<h1>Agenda</h1>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>#ID</th>
					<th>Cliente</th>
					<th>Funcionario</th>
					<th>Serviço</th>
					<th>Data</th>
					<th>Hora</th>
					<th>Obs</th>
				</tr>
			</thead>

			<c:forEach var="agenda" items="${agenda}">
				<tr>
					<td>${agenda.id}</td>
					<td>${agenda.contato}</td>
					<td>${agenda.funcionario}</td>
					<td>${agenda.servico}"</td>
					<td>${agenda.dtAgenda}"</td>
					<td>${agenda.horaAgenda}"</td>
					<td>${agenda.obs}"</td>
					<td>
						<spring:url value="/users/${agenda.id}" var="userUrl" />
						<spring:url value="/users/${agenda.id}/delete" var="deleteUrl" /> 
						<spring:url value="/users/${agenda.id}/update" var="updateUrl" />

						<button class="btn btn-info" onclick="location.href='${agendaUrl}'">Query</button>
						<button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
						<button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Delete</button></td>
				</tr>
			</c:forEach>
		</table>

	</div>

	<jsp:include page="../fragments/footer.jsp" />

</body>
</html>