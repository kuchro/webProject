<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp" %>
  
  
    <table>
    <thead>
    <tr>
    	
    </tr>
    
    </thead>
    <tbody>
    	<c:forEach items="${test.posts}" var="post">
    		
    				<p>${post.title}</p>
    				<p>${post.body}</p>
    				<p>${test.name}</p>
    				
    				<td>
    			
    				
    		</tr>
    				
    		</c:forEach>
    	
    
    </table>