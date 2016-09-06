<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<title>Spring MVC Form Handling Example</title>

<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>

<spring:url value="/" var="urlHome" />
<spring:url value="/users/add" var="urlAddUser" />
<spring:url value="/agenda/add" var="urlAddAgenda" />
<spring:url value="/users" var="urlUser" />
<spring:url value="/agenda" var="urlAgenda" />

<nav class="navbar navbar-inverse ">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${urlHome}">Spring MVC Form</a>
		</div>
		<div id="navbar">
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="${urlUser}">Cliente</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="${urlAddUser}">Cadastrar Cliente</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="${urlAgenda}">Agenda</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="${urlAddAgenda}">Cadastrar Agenda</a></li>
			</ul>
		</div>
	</div>
</nav>