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
		modelAttribute="agendaform" action="${agendaActionUrl}" onsubmit="return confirm('Tem certeza que deseija salvar?') ? true : false;">


		<spring:bind path="contato">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Contato</label>
				<div class="col-sm-10">
					<select name="contato" id="contato" class="form-control">
						<option value="-1" label="Select..." />
						<c:forEach items="${contatoList}" var="user">
							<option value="${user.id}">${user.nome}</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</spring:bind>

		<spring:bind path="funcionario">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Funcion�rio</label>
				<div class="col-sm-10">
					<select name="funcionario" id="funcionario"
						class="form-control">
						<option value="-1" label="Select..." />
						<c:forEach items="${funcionarioList}" var="user">
							<option value="${user.id}">${user.nome}</option>
						</c:forEach>
					</select>
					<form:errors path="funcionario" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="servico">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Servi�o</label>
				<div class="col-sm-10">
					<select name="servico" id="servico" 
						class="form-control">
						<option value="-1" label="Select..." />
						<c:forEach items="${servicoList}" var="serv">
							<option value="${serv.id}">${serv.nome}</option>
						</c:forEach>
					</select>
					<form:errors path="servico" class="control-label" />
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
					<form:input path="horaAgenda" class="form-control" 
						id="horaAgenda" placeholder="horaAgenda" />
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
						<button id="btn-adiciona" type="submit" class="btn-lg btn-primary pull-right">Adicionar</button>
					</c:when>
					<c:otherwise>
						<button id="btn-atualiza" type="submit" class="btn-lg btn-primary pull-right">Atualizar</button>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</form:form>

</div>

<jsp:include page="../fragments/footer.jsp" />

<script>
	jQuery(document).read(function($)){
	
		$("#btn-adiciona").submit(function(event)){
			
			// Disble the search button
			enableBtn(false);
			
			// Prevent the form from submitting via the browser.
			event.preventDefault();
			
			validaAgendaAjax();
		});
	});
	
	function enableBtn(flag){
		if(${agendaform['new']}){
			$("#btn-adiciona").prop("disabled",flag);
		}else{
			$("#btn-atualiza").prop("disabled",flag);
		}
	}
	
	function validaAgendaAjax(){
		
		var parametros = {}
		parametros["data"] = $("#dtAgenda").val();
		parametros["hora"] = $("#horaAgenda").val();
		parametros["funcionario"] = $("#funcionario").val();
		
		$.ajax({
		
			type : "POST",
			contentType : "application/json",
			url : "/agenda/validaAgenda",
			data : JSON.stringify(parametros),
			dataType : 'json',
			timeout : 100000,
			sucess : function(data){
				console.log("SUCESS: ", data);
				display(data);
			},
			error : function(e){
				console.log("ERROR: ", e);
			},
			done : function(e){
				console.log("ERROR: ", e)
				enableBtn(true);
			}
		});
	}
	
	function display(data) {
		var json = "<h4>Ajax Response</h4><pre>"
				+ JSON.stringify(data, null, 4) + "</pre>";
		$('#feedback').html(json);
	}
	
</script>

</body>
</html>