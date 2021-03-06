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

		<h1>All Users</h1>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Codigo</th>
					<th>Nome</th>
					<th>Telefone</th>
					<%--<c:if test="${not null user.celular}"> --%>
					<th>celular</th>
					<%--</c:if> --%>
					<th>Email</th>
				</tr>
			</thead>

			<c:forEach var="user" items="${users}">
				<tr>
					<td>${user.id}</td>
					<td>${user.nome}</td>
					<td>${user.telefone }
					<td>${user.celular }
					<td>${user.email}</td>
					<%-- <td>
						<c:forEach var="framework" items="${user.framework}" varStatus="loop">
							${framework}<c:if test="${not loop.last}">,</c:if>
						</c:forEach></td>
					<td> --%>
					<td>
						<spring:url value="/users/${user.id}" var="userUrl" />
						<spring:url value="/users/${user.id}/delete" var="deleteUrl" /> 
						<spring:url value="/users/${user.id}/update" var="updateUrl" />

						<button class="btn btn-info" onclick="location.href='${userUrl}'">Detalhes</button>
						<button class="btn btn-primary" onclick="location.href='${updateUrl}'">Atualizar</button>
						<button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Deletar</button>
					</td>
				</tr>
			</c:forEach>
		</table>

	</div>

	<jsp:include page="../fragments/footer.jsp" />

</body>
</html>