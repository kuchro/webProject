<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp"%>

<br />
<h3>Wiadomosci</h3>
</head>
<body>
	<table class="table table-bordered table-hover table-striped">
		<c:forEach items="${message}" var="msg">

			<tr>
				<td>
					<p>Email: ${msg.contactEmail }</p>
			
					<p>Numer Tel:: ${msg.phoneNumber }</p>
				</td>
			</tr>


			<tr>
				<td>
					<p>Tresc: ${msg.textBody }</p>
				</td>
			</tr>

<tr>
<td></td>
</tr>





		</c:forEach>
</body>
</html>