<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<spring:url value="/resources/core/js/jquery.1.10.2.min.js"
	var="jqueryJs" />
<spring:url value="/resources/core/js/jquery.mask.min.js"
	var="jqueyMask" />

<script src="${jqueryJs}" type="text/javascript">
	
</script>

<script src="${jqueyMask}" type="text/javascript">
	$(document).ready(function (){
		$("#telefone").mask("(99) 999-9999");
		$("#celular").mask("(99) 999-9999");
		$("#dtNasct").mask("99/99/9999", {
			placeholder : "mm/dd/yyyy"
		});
		
		$('[data-toggle="tooltip"]').tooltip();
	});
</script>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="../fragments/header.jsp" />

<div class="container">

	<c:choose>
		<c:when test="${userForm['new']}">
			<h1>Adicionar Cliente</h1>
		</c:when>
		<c:otherwise>
			<h1>Atualizar Cliente</h1>
		</c:otherwise>
	</c:choose>
	<br />

	<spring:url value="/users" var="userActionUrl" />

	<form:form class="form-horizontal" method="post" name="userForm"
		modelAttribute="userForm" action="${userActionUrl}">
		<form:hidden path="id" />
		
		<c:choose>
			<c:when test='${not empty "${userForm.isFunc()}"}'>
				<spring:bind path="isFunc">
					<div class="form-group ${status.error ? 'has-error' : ''} }">
						<label class="col-sm-2 control-label">Funcionário</label>
						<div class="col-sm-10">
							<form:checkbox checked="true" path="isFunc" class="checkbox-inline " id="isFunc" />
							<form:errors path="isFunc" class="control-label" />
						</div>
					</div>
				</spring:bind>
			</c:when>
			<c:otherwise>
				<spring:bind path="isFunc">
					<div class="form-group ${status.error ? 'has-error' : ''} }">
						<label class="col-sm-2 control-label">Funcionário</label>
						<div class="col-sm-10">
							<form:checkbox checked="false" path="isFunc" class="checkbox-inline " id="isFunc" />
							<form:errors path="isFunc" class="control-label" />
						</div>
					</div>
				</spring:bind>			
			</c:otherwise>
		</c:choose>
		
		<spring:bind path="nome">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Nome</label>
				<div class="col-sm-10">
					<form:input maxlength="50" path="nome" type="text"
						class="form-control " id="nome" placeholder="Nome" />
					<form:errors path="nome" class="control-label" />
					<ajax:formPartialRefresh validateUrl="/userAjax.json" 
						formName="userForm"/>
				</div>
			</div>
		</spring:bind>

		<spring:bind path="telefone">
			<div class="form-group ${status.error ? 'has-error' : ''} }">
				<label class="col-sm-2 control-label">Telefone</label>
				<div class="col-sm-10">
					<form:input type="tel" path="telefone" class="form-control"
						id="telefone" placeholder="Telefone" />
					<form:errors path="telefone" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="celular">
			<div class="form-group ${status.error ? 'has-error' : ''} }">
				<label class="col-sm-2 control-label">Celular</label>
				<div class="col-sm-10">
					<form:input type="tel" path="celular" class="form-control"
						id="celular" placeholder="Celular" />
					<form:errors path="celular" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="email">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Email</label>
				<div class="col-sm-10">
					<form:input type="email" path="email" class="form-control"
						id="email" placeholder="Email" />
					<form:errors path="email" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<c:if test='${not empty "${userForm.isFunc()}"}'>
			<spring:bind path="password">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Password</label>
					<div class="col-sm-10">
						<form:password path="password" class="form-control" id="password" placeholder="Password" />
						<form:errors path="password" class="control-label" />
					</div>
				</div>
			</spring:bind>
		</c:if>
		
		<c:if test='${not empty "${userForm.password()}"}'>
			<spring:bind path="confirmPassword">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Confirm Password</label>
					<div class="col-sm-10">
						<form:password path="confirmPassword" class="form-control"
							id="password" placeholder="Confirme o Password" />
						<form:errors path="confirmPassword" class="control-label" />
					</div>
				</div>
			</spring:bind>
		</c:if>
		
		<spring:bind path="address">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Endereço</label>
				<div class="col-sm-10">
					<form:textarea path="address" rows="5" class="form-control"
						id="address" placeholder="Endereço" />
					<form:errors path="address" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="cidade">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Cidade</label>
				<div class="col-sm-10">
					<form:select path="cidade" class="form-control">
						<form:option value="NONE" label="--- Select ---" />
						<form:options items="${countryList}" />
					</form:select>
					<form:errors path="cidade" class="control-label" />
				</div>
			</div>
		</spring:bind>


		<spring:bind path="dtNasct">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Data de Nascimento</label>
				<div class="col-sm-10">
					<form:input type="date" path="dtNasct" class="form-control"
						id="dtNasct" maxlength="10" />
					<form:errors path="dtNasct" class="control-label" />
				</div>
			</div>
		</spring:bind>


		<spring:bind path="sex">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Sexo</label>
				<div class="col-sm-10">
					<label class="radio-inline"> <form:radiobutton path="sex"
							value="M" />Homem
					</label> <label class="radio-inline"> <form:radiobutton path="sex"
							value="F" /> Mulher
					</label> <br />
					<form:errors path="sex" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="obs">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Observação</label>
				<div class="col-sm-10">
					<form:textarea data-toggle="tooltip" title="Hooray!"
						maxlength="100" path="obs" rows="5" class="form-control" id="obs"
						placeholder="Observação" />
					<form:errors path="obs" class="control-label" />
				</div>
			</div>
		</spring:bind>


		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<c:choose>
					<c:when test="${userForm['new']}">
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