<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.service.UserService"%>
<%@page import="kr.or.ddit.user.service.UserServiceInf"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<!-- jquery ui css -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<title>Jsp</title>
<%@ include file="/WEB-INF/view/common/basicLib.jsp"%>
<!-- daum 주소 API -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<!-- jquery API -->
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(document).ready(function(){

		
		//생일 input datepicker적용
		$("#birth").datepicker({yearRange : "1950:2018",
			  changeMonth: true,
		      changeYear: true,
		      dateFormat: "yy-mm-dd"});
		//주소 검색버튼 이벤트 핸들러
		$("#addrSearchBtn").click(function(){
			//주소 검색 버튼 클릭이벤트가 발생했을 때 실행
		    new daum.Postcode({
		        oncomplete: function(data) {
		            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
		            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
		            console.log(data);
		            //주소 : roadAddress
		            //상세주소 :""
		            //우편번호:zonecode
		            
		            //주소 input value설정 : data.roadAddress
		            $("#addr1").val(data.roadAddress);
		            //우편번호 input value 설정 : data.zonecode
		            $("#zipcd").val(data.zonecode);
		        }
		    }).open();
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
				<form action ="/user/userUpdate" method="post" class="form-horizontal" role="form" enctype="multipart/form-data">
				
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
						<div class="col-sm-10">
<%-- 							<% String profilePath = userVo1.getProfile(); --%>
<!-- // 								profilePath = profilePath ==null ? "profile/noimage.png" : profilePath; -->
<%-- 							%> --%>
							<c:set var="profilePath" value="${userVo.profile }"/>
							<c:choose>
								<c:when test="${profilePath !=null }">
									<c:set var="profile" value="${profilePath }"/>
								</c:when>
								<c:otherwise>
									<c:set var="profile" value="profile/noimage.png" />
								</c:otherwise>
							</c:choose>
							<img src="${profile }"/>
							<input type="file" name="profilePic" value="${profile }"/>
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="userId" 
								name="userId" readonly value="${userVo.userId }">
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">비밀번호</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="pass" 
								name="pass" value="${userVo.pass }">
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">이름</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="name" 
								name="name" readonly value="${userVo.name }">
						</div>
					</div>


					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">주소</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="addr1" 
								name="addr1" readonly value="${userVo.addr1 }"><!-- 주소 검색 버튼 -->
							<button type="button" id="addrSearchBtn" class="btn btn-default">주소검색</button>
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">상세주소</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="addr2" 
								name="addr2"  value="${userVo.addr2 }">
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="zipcd" 
								name="zipcd" readonly value="${userVo.zipcd }">
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">생년월일</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="birth" 
								name="birth" value="<fmt:formatDate value = "${userVo.birth }" pattern="yyyy-MM-dd"></fmt:formatDate>"/>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">이메일</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="email" 
								name="email" value="${userVo.email }">
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">연락처</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="tel" 
								name="tel" value="${userVo.tel }">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">수정하기</button>
						</div>
					</div>
				</form>
				

			</div>
		</div>
	</div>
</body>
</html>
