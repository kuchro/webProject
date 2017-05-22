<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  
<%@ include file="../layouts/taglib.jsp" %>
<h1>${user.name}</h1>

	<c:forEach items="${user.blogs}" var="blog">
		<h1>${blog.name}</h1>
		<p>${blog.url}</p>
		<table>
			<thead>
			<tr>
			<c:forEach items="${user.posts}" var = "post">
			<p>${post.title}</p>
				<p>${post.body}</p>
			</c:forEach>
			</tr>
			
			</thead>
			<tbody>
			<c:forEach items="${blog.items}" var="item">
			<tr>
			<td><p>${item.title}</p></td>
			<td><p>${item.link}</p></td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
		
		
	
	
	</c:forEach>