<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp" %>
  
  
    <table>
    <thead>
    <tr>
    	<th>Filtry</th>
    </tr>
    
    </thead>
    <tbody>
    	<c:forEach items="${users}" var="user">
    		<tr>
    			<td>
    			<a href="<spring:url value='users/${user.id}.html'/>">
    				${user.name}</a>
    				
    				<td>
    			
    				
    		</tr>
    				
    		</c:forEach>
    		
    		
    	
    
    </table>
    </thead>
    <tbody>
    	<c:forEach items="${users}" var="user">
    		<tr>
    			<td>
    			<a href="<spring:url value='test/${user.id}.html'/>">
    				${user.name}</a>
    				
    				<td>
    			
    				
    		</tr>
    				
    		</c:forEach>
    		
    		<br/><br/>
    		<a href="<spring:url value='adm.html'/>">Panel administracyjny</a>
    	
    
    </table>