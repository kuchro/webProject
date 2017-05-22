<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp"%>



<form:form commandName="userRegister" cssClass="form-horizotnal">

	<c:if test="${param.succes eq true }">
		<div class="alert alert-success">Rejestracja przebiegla pomyslnie</div>
	</c:if>

	<div class="form-group" >
		<label for="inputName" class="col-sm-2 control-label" placeholder="Name">Name:</label>
		<div class="col-sm-10">
			<form:input path="name" cssClass="form-control"  />
			<form:errors path="name" />
		</div>
	</div>
	
	<div class="form-group">
		<label for="inputEmail" class="col-sm-2 control-label">Email:</label>
		<div class="col-sm-10">
			<form:input path="email" cssClass="form-control" />
			<form:errors path="email" />
		</div>
	</div>
	
	
	<div class="form-group">
		<label for="inputPassword" class="col-sm-2 control-label">Password:</label>
		<div class="col-sm-10">
			<form:password path="password" cssClass="form-control" />
			<form:errors path="password" />
		</div>
	</div>
	
	
	<div class="form-group">
		
		<div class="col-sm-2">
			<input type="submit" value="Zapisz" class="btn btn-lg btn-primary"/>
		</div>
	</div>

</form:form>
