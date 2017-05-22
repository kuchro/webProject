<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp" %>
  
  <h1 class="page-header">Dodaj post</h1>
<form:form commandName="addPost" cssClass="form-horizotnal">


<c:if test="${param.succes eq true }">
		<div class="alert alert-success">Post zostal dodany</div>
	</c:if>

	<div class="form-group" >
		<label for="inputTitle" class="col-sm-2 control-label" placeholder="Name">Tytul:</label>
		<div class="col-sm-10">
			<form:input style="width:350px;" path="title" cssClass="form-control"  />
			<form:errors path="title"/>
		</div>
	</div>
	
	<div class="form-group">
		<label for="inputAuthor" class="col-sm-2 control-label">Autor:</label>
		<div class="col-sm-10">
			<form:input style="width:150px;" path="author" cssClass="form-control" />
			<form:errors path="author"/>
		</div>
	</div>
	
	
	<div class="form-group">
		<label for="inputBody" class="col-sm-2 control-label" >Tekst:</label>
		<div class="col-sm-10">
			<form:textarea style="width:450px;" rows="7" path="body" cssClass="form-control" />
		</div>
	</div>
	
	
	<div class="form-group">
		
		<div class="col-sm-2">
			<input type="submit" value="Zapisz" class="btn btn-lg btn-primary"/>
		</div>
	</div>
<br>
</form:form>
