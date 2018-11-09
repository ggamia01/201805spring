<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- <% UserVo userVo = (UserVo)session.getAttribute("userVo"); %> --%>
<!-- 	main.jsp -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">JSP/SPRING
<%-- 				<% if(userVo != null){ %> --%>
<%-- 				<%=userVo.getName()+"님 안녕하세요" %> --%>
<%-- 				<% }else{%> --%>
<%-- 					<%= "로그인해주세요"%> --%>
<%-- 				<%}%> --%>
				<c:choose>
					<c:when test="${S_user != null }">
						<fmt:bundle basename="kr.or.ddit.resource.msg.msg">
							<fmt:message key="visitor">
								<fmt:param value="${S_user.name }"></fmt:param>
							</fmt:message>
						</fmt:bundle>
					</c:when>
					<c:otherwise>
						로그인해주세요
					</c:otherwise>
				
				</c:choose>
				</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Dashboard</a></li>
					<li><a href="#">Settings</a></li>
					<li><a href="#">Profile</a></li>
					<li><a href="#">Help</a></li>
					<li><a href="/logout">Logout</a></li>
				</ul>
				<form class="navbar-form navbar-right">
					<input type="text" class="form-control" placeholder="Search...">
				</form>
			</div>
		</div>
	</nav>
</html>