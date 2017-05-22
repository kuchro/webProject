

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp"%>

<h1 class="page-header">Napisz wiadomość</h1>
<form:form commandName="contactUs" cssClass="form-horizotnal">
<c:if test="${param.success eq true }">
		<div class="alert alert-success">Wiadomosc zostala wyslana. Dziekujemy!</div>
	</c:if>


	<c:if test="${param.succes eq true }">
		<div class="alert alert-success">Post zostal dodany</div>
	</c:if>

	<div class="form-group">
		<label for="inputTitle" class="col-sm-2 control-label"
			placeholder="email">Email:</label>
		<div class="col-sm-10">
			<form:input style="width:350px;" path="contactEmail"
				cssClass="form-control" />
			<form:errors path="contactEmail" />
		</div>
	</div>
	<div class="form-group">
		<label for="inputTitle" class="col-sm-2 control-label"
			placeholder="Subject">Temat:</label>
		<div class="col-sm-10">
			<form:input style="width:350px;" path="subject"
				cssClass="form-control" />
			<form:errors path="subject" />
		</div>
	</div>


	<div class="form-group">
		<label for="inputAuthor" class="col-sm-2 control-label">Telefon:</label>
		<div class="col-sm-10">
			<form:input style="width:150px;" path="phoneNumber"
				cssClass="form-control" />
			<form:errors path="phoneNumber" />
		</div>
	</div>


	<div class="form-group">
		<label for="inputBody" class="col-sm-2 control-label">Wiadomosc:</label>
		<div class="col-sm-10">
			<form:textarea style="width:450px;" rows="7" path="textBody"
				cssClass="form-control" />
			<form:errors path="textBody" />
		</div>
	</div>


	<div class="form-group">

		<div class="col-sm-2">
			<input type="submit" value="Wyślij" class="btn btn-lg btn-primary" />
		</div>
	</div>
	<br>
</form:form>
