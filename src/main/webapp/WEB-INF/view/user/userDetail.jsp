<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.service.UserService"%>
<%@page import="kr.or.ddit.user.service.UserServiceInf"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>
<%@ include file="/WEB-INF/view/common/basicLib.jsp"%>
<script type="text/javascript">
	$(document).ready(function(){
		var click ="click";
		$("#upClick").on(click,function(){
			var userId = $("#userid").text();
			
			$("#userId").val(userId);
			// .submit();
			$("#frm").submit();
		});
	});
</script>
</head>

<body>

	<%--header --%>
	<%@ include file="/WEB-INF/view/common/header.jsp"%>
	<%UserVo userVo1 = (UserVo)request.getAttribute("userVo");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");%>
	<div class="container-fluid">
		<div class="row">

			<%--left --%>
			<%@ include file="/WEB-INF/view/common/left.jsp"%>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<form id="frm" class="form-horizontal" role="form" action="/user/userUpdate?userId=<%=userVo1.getUserId() %>" method="get">
				
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
						<div class="col-sm-10">
<%-- 							<% String profilePath = userVo1.getProfile(); --%>
<!-- // 								profilePCath = profilePath ==null ? "profile/noimage.png" : profilePath; -->
<%-- 							%> --%>
							<c:choose> 
								<c:when test="${userVo.profile == null }">
									<c:set var="profile" value="profile/noimage.png"/>
								</c:when>
								<c:otherwise>
									<c:set var="profile" value="${userVo.profile }"/>
<%-- 								<c:set var="profile" value="/fileDownload?userId=${userVo.userId }"/> --%>
								</c:otherwise>	
							</c:choose>
							<img src="${profile}"/>
<%-- 							<img src="/fileDownload?userId=${userVo.userId }"/> --%>
<%-- 							<img src="<%=profilePath %>"/> --%>
							
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
							<input type="hidden" id="userId" name="userId"/>
							<label id="userid" class="control-label">${userVo.userId }</label>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">이름</label>
						<div class="col-sm-10">
							<label class="control-label">${userVo.name }</label>
						</div>
					</div>


					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">주소</label>
						<div class="col-sm-10">
							<label class="control-label">${userVo.addr1 }</label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">상세주소</label>
						<div class="col-sm-10">
							<label class="control-label">${userVo.addr2 }</label>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
							<label class="control-label">${userVo.zipcd }</label>
						</div>
					</div>
					
<!-- 					<div class="form-group"> -->
<!-- 						<label for="userNm" class="col-sm-2 control-label">생년월일</label> -->
<!-- 						<div class="col-sm-10"> -->
<!-- 							<input type="text" class="form-control" id="userAlias" -->
<!-- 								name="userAlias" placeholder="별명"> -->
<!-- 						</div> -->
<!-- 					</div> -->
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">생년월일</label>
						<div class="col-sm-10">
							<label class="control-label">
								<fmt:formatDate value = "${userVo.birth }" pattern="yyyy년 MM월 dd일"></fmt:formatDate>
							</label>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">이메일</label>
						<div class="col-sm-10">
							<label class="control-label">${userVo.email }</label>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">연락처</label>
						<div class="col-sm-10">
							<label class="control-label">${userVo.tel }</label>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button id="upClick" type="button" class="btn btn-default">수정하기</button>
						</div>
					</div>
				</form>
				

			</div>
		</div>
	</div>
</body>
</html>
