<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ include file="../layouts/taglib.jsp"%>


<table class="table table-bordered table-hover table-striped">

	<tbody>

		<tr>
			<td>
				<h3>${postid.title}</h3>
			</td>
		</tr>

		<tr>
			<td>

				<p>${postid.body}</p>
			</td>
		</tr>

		<tr>
			<td>
				<p>${postid.publishdate}</p>
				<p>${postid.author}</p>
			</td>
		</tr>



	</tbody>


</table>