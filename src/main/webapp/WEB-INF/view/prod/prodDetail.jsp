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
				<form id="frm" class="form-horizontal" role="form"  method="get">
				
				
					
					
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">제품아이디</label>
						<div class="col-sm-10">
							<input type="hidden" id="userId" name="userId"/>
							<label id="userid" class="control-label">${prodVo.prod_id}</label>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">제품명</label>
						<div class="col-sm-10">
							<label class="control-label">${prodVo.prod_name }</label>
						</div>
					</div>


					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">제품그룹명</label>
						<div class="col-sm-10">
							<label class="control-label">${prodVo.lprod_nm }</label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">바이어 이름</label>
						<div class="col-sm-10">
							<label class="control-label">${prodVo.buyer_name }</label>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">바이어 메일</label>
						<div class="col-sm-10">
							<label class="control-label">${prodVo.buyer_mail }</label>
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
