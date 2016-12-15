<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<spring:url value="/resources/core/js/jquery.1.10.2.min.js"	var="jqueryJs" />

<script src="${jqueryJs}"></script>

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

	<form:form class="form-horizontal" method="post" modelAttribute="agendaform" action="${agendaActionUrl}" >
		<%-- onsubmit="return confirm('Tem certeza que deseija salvar?') ? true : false;" --%>
		

		<c:choose>
			<c:when test="${agendaform.isNew()}">
				<spring:bind path="contato">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<label class="col-sm-2 control-label">Cliente</label>
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
			</c:when>
			<c:otherwise>
				<spring:bind path="nmContato">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<label class="col-sm-2 control-label">Cliente</label>
						<div class="col-sm-10">
							<form:input path="nmContato" type="text" class="form-control " id="nmContato" desabled="true"/>
							<form:errors path="nmContato" class="control-label" />
						</div>
					</div>
				</spring:bind>
			</c:otherwise>
		</c:choose>
		

		<c:choose>
			<c:when test="${agendaform.isNew()} }">
				<spring:bind path="funcionario">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<label class="col-sm-2 control-label">Funcionário</label>
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
			</c:when>
			<c:otherwise>
				<spring:bind path="nmFuncionario">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<label class="col-sm-2 control-label">Funcionário</label>
						<div class="col-sm-10">
							<form:input path="nmFuncionario" type="text" class="form-control" id="nmFuncionario" desabled="true"/>
							<form:errors path="nmFuncionario" class="control-label" />
						</div>
					</div>
				</spring:bind>
			</c:otherwise>
		</c:choose>
		

		<c:choose>
			<c:when test="${agendaform.isNew()}">
				<spring:bind path="servico">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Serviço</label>
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
			</c:when>
			<c:otherwise>
				<spring:bind path="nmServico">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<label class="col-sm-2 control-label">Serviço</label>
						<div class="col-sm-10">
							<form:input type="text" path="nmServico" id="nmServico" class="form-control" desabled="true"/>
							<form:errors path="nmServico" class="control-label" />
						</div>
					</div>
				</spring:bind>
			</c:otherwise>
		</c:choose>
		

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

		<div id="feedback"></div>

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
		
		//submit
		//$("#btn-adiciona").submit(function(event)){
		//change
		$("#obs").change(function()){
			alert('adiciona');
			enableBtn(false);
			//event.preventDefault();
			validaAgendaAjax();
		});
	});
	
/* 	$('#razao-social').change(function() {
	    $.get("action/fazalgumaCoisa", {parametro: $(this).val()}, 
	    	function(data) {
	        //Criar a montagem da tela com o jQuery
	    	}).fail(function() {
	        alert("Ocorreu um erro, tente novamente mais tarde.");
	    });
	}); */
	
	
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