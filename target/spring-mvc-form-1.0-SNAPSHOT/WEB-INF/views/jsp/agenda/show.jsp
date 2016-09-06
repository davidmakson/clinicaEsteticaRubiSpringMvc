<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />

<div class="container">

	<c:if test="${not empty msg}">
		<div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>${msg}</strong>
		</div>
	</c:if>

	<h1>Detalhes da Agenda</h1>
	<br />

	<div class="row">
		<label class="col-sm-2">Cliente</label>
		<div class="col-sm-10">${agenda.cliente}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Funcionario</label>
		<div class="col-sm-10">${agenda.funcionario}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Serviço</label>
		<div class="col-sm-10">${agenda.servico}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Data</label>
		<div class="col-sm-10">${agenda.dtAgenda}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Observação</label>
		<div class="col-sm-10">${agenda.obs}</div>
	</div>

</div>

<jsp:include page="../fragments/footer.jsp" />

</body>
</html>