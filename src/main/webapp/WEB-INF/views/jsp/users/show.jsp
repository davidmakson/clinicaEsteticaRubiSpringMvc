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

	<h1>Detalhes do Cliente</h1>
	<br />

	<div class="row">
		<label class="col-sm-2">ID</label>
		<div class="col-sm-10">${user.id}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Nome</label>
		<div class="col-sm-10">${user.nome}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Celular</label>
		<div class="col-sm-10">${user.celular}</div>
	</div>
	
		<div class="row">
		<label class="col-sm-2">Telefone</label>
		<div class="col-sm-10">${user.telefone}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Email</label>
		<div class="col-sm-10">${user.email}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Address</label>
		<div class="col-sm-10">${user.address}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Cidade</label>
		<div class="col-sm-10">${user.cidade}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Data de Nascimento</label>
		<div class="col-sm-10">${user.dtNasct}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Sexo</label>
		<div class="col-sm-10">${user.sex}</div>
	</div>

</div>

<jsp:include page="../fragments/footer.jsp" />

</body>
</html>