<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />

<div class="container">

	<c:choose>
		<c:when test="${agendaform.isNew()}">
			<h1>Adicionar Agenda</h1>
		</c:when>
		<c:otherwise>
			<h1>Atualizar Agenda</h1>
		</c:otherwise>
	</c:choose>
	<br />

	<spring:url value="/agenda/add" var="agendaActionUrl" />

	<form:form class="form-horizontal" method="post"
		modelAttribute="agendaform" action="${agendaActionUrl}">


		<spring:bind path="contatoList">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Contato</label>
				<div class="col-sm-10">
					<select name="contatoList" id="contatoList" class="form-control">
						<c:forEach items="${contatoList}" var="user">
							<option value="NONE" label="Select..." />
							<options value="${user.id}">${user.nome}</option>
						</c:forEach>
					</select>
					<form:errors path="contatoList" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="funcionarioList">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Funcionário</label>
				<div class="col-sm-10">
					<select name="funcionarioList" id="funcionarioList"
						class="form-control">
						<c:forEach items="${funcionarioList}" var="user">
							<option value="NONE" label="Select..." />
							<options value="${user.id}">${user.nome}</option>
						</c:forEach>
					</select>
					<form:errors path="funcionarioList" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="servicoList">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Serviço</label>
				<div class="col-sm-10">
					<select name="servicoList" id="servicoList" class="form-control">
						<c:forEach items="${servicoList}" var="serv">
							<option value="NONE" label="Select..." />
							<options value="${serv.id}">${serv.nome}</option>
						</c:forEach>
					</select>
					<form:errors path="servicoList" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="dtAgenda">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Data</label>
				<div class="col-sm-10">
					<form:input path="dtAgenda" class="form-control" id="dtAgenda"
						placeholder="dtAgenda" />
					<form:errors path="dtAgenda" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="horaAgenda">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Hora</label>
				<div class="col-sm-10">
					<form:input path="horaAgenda" class="form-control" id="horaAgenda"
						placeholder="horaAgenda" />
					<form:errors path="horaAgenda" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="obs">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">obs</label>
				<div class="col-sm-10">
					<form:textarea path="obs" rows="5" class="form-control" id="obs"
						placeholder="obs" />
					<form:errors path="obs" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<c:choose>
					<c:when test="${agendaform['new']}">
						<button type="submit" class="btn-lg btn-primary pull-right">Adicionar</button>
					</c:when>
					<c:otherwise>
						<button type="submit" class="btn-lg btn-primary pull-right">Atualizar</button>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</form:form>

</div>

<jsp:include page="../fragments/footer.jsp" />

</body>
</html>