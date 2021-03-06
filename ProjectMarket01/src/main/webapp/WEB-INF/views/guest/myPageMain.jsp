
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
    <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
	 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
	
    <title>Hello, world!</title>
    <style>
		@import url('https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@800&display=swap');

    	.foot{
    	 bottom:0;
    	
    	} 
    	.body2{
    		height:70vh;
    	}
    	.hi{
		font-family: 'Nanum Gothic', sans-serif;
		font-size:30px;
		  /* 마우스 오버(마우스 올렸을때) */
		 }
		.mypage{
			height:300px;
		}

    </style>
 	<script>
 	function moveHome(){
 	     location.href = "/myPageMain?c_id=<sec:authentication property='principal.Username'/>";
 	}
 	</script>

  </head>
  <body>
    <nav class="navbar navbar-expand-lg">
 		<a class="navbar-brand" href="/"></a>
  		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
   		 <span class="navbar-toggler-icon"></span>
  	</button>
  <div class="collapse navbar-collapse " id="navbarText">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link " href="/"><img src="/img/mainicon.png" style="width:90px"><span class="sr-only">(current)</span></a>
      </li>
       <li class="nav-item">
        <a class="nav-link text-secondary" href="/notice">&nbsp;&nbsp;예약현황</a>
      </li>
       <li class="nav-item">
        <a class="nav-link text-secondary" href="/noticelist">&nbsp;&nbsp;공지사항</a>
      </li>
       <li class="nav-item">
      <a class="nav-link text-secondary" href="/SendMessage">푸시알림</a>
	  </li>
    </ul>
	<sec:authorize access="!isAuthenticated()">
    	<button type="button" class="btn btn-outline-warning" onclick="movehome()">로그인</button>&nbsp;
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
		 <span class="navbar-text">
   			<a class="text-secondary"  href="/mypage_main?member_id=<sec:authentication property="principal.Username"/>">마이페이지</a>&nbsp;&nbsp;
   		 </span>
   	 		<button type="button" class="btn btn-outline-warning" onclick="javascript:window.location='/logout'">로그아웃</button>&nbsp;
		</sec:authorize>
  </div>
</nav>

 
	<div class="container col-8 body2 " style="margin-top:20px">
		<div class="row">
					<p class="col-10 hi Secondary">마이페이지</p>
		</div>
		
			 <div class="row justify-content-around" style="margin-top:140px">
			  <c:forEach items="${myPageInfo}" var="myPageInfo">	
			    <div class="col-4 mypage border">
			    	<p class="hi" style="font-size:15px; margin-top:10px">내정보</p>
			    	
			    	<span style="font-size:15px;"> 닉네임&nbsp;&nbsp;${myPageInfo.member_nickname} </span><br/>
			    	<span style="font-size:15px;"> 연락처&nbsp;&nbsp;${myPageInfo.member_phone} </span><br/>
			    	<span style="font-size:15px;">메일&nbsp;&nbsp;${myPageInfo.member_email} </span><br/>
			    	<a class="text-warning btn btn-outline-warning"  href="/changeMyInfo?member_id=<sec:authentication property="principal.Username"/>" style="margin-top:120px">수정하기</a>&nbsp;&nbsp;   
			    	
			    </div>
			    <div class="col-4 mypage border" >
				     <p class="hi" style="font-size:17px;  margin-top:10px">비밀번호</p>
				     <p class="fw-lighter" style="font-size:12px; margin-top:5px">	주기적인 비밀번호 변경을 통해 개인정보를 안전하게 보호하세요.</p>
			     <input type="button" class="btn btn-outline-warning d-flex p-2" value="수정하기" onclick="javascript:window.location='/changePwd'" style="margin-top:150px">   
			    </div>
			    <div class="col-4 mypage border">
			     <p class="hi" style="font-size:17px;  margin-top:10px">회원문의</p>
				    <a class="btn btn-outline-warning" href="/admin/classchatlist?type='환불문의'">환불문의</a><br/>
				    <a class="btn btn-outline-warning" style= "margin-top:5px"  href="/admin/classchatlist?type='예약취소'">예약취소</a><br/>
				    <a class="btn btn-outline-warning" style= "margin-top:5px" href="/admin/classchatlist?type='불편신고'">불편신고</a><br/>
				    <a class="btn btn-outline-warning" style= "margin-top:5px" href="/admin/classchatlist?type='기타문의'">기타문의</a><br/>
			    </div>

			    </c:forEach>
  			</div>
		</div>

	

	<div class="p-3 mb-2  text-black foot">
	<hr>
	<br>
		<div class="container">
			<footer>
			<div class="row">
			<div class="col-10">
				이메일 : engudengud@gmail.com <br> 전화번호 : 010-5918-3963 <br> 주소 : 서울시 은평구 신사동 <br> 고객센터 : 010-9273-9992 
			</div>
			<div class="col-1">
				<img src="/img/mainicon.png" style="width:90px; margin:20px">
			</div>
			</div>
			</footer>
		</div>
	</div>
	  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
	
    
  </body>
</html>