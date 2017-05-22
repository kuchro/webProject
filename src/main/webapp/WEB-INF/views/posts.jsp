<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ include file="../layouts/taglib.jsp"%>


<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Posts</th>
		</tr>

	</thead>
	<tbody>
		<c:forEach items="${posts }" var="post">
			<tr>
				<td><a href="<spring:url value="/posts/${post.id}.html" />">
						<h2>${post.title}</h2>
				</a></td>
			</tr>

			<tr>
				<td>

					<p>${post.body}</p>

				</td>
			</tr>
			<tr>
				<td>
					<p>Data publikacji: ${post.publishdate}</p>
					<p>Autor: ${post.author}</p>
				</td>
			</tr>
		</c:forEach>
	</tbody>


</table>