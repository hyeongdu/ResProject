<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="user"><sec:authentication property="principal"/></c:set>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
    <meta http-equiv="Content-Type" content="text/html; charset= UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <style>
    @import url('https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@800&display=swap');
    .hi{
		font-family: 'Nanum Gothic', sans-serif;
		font-size:30px;
		 }
	.foot{
    	 bottom:0;
    	} 
    	.body2{
    		height:80vh;
    	}
   	td .title {
		  color: inherit;
		  text-decoration: none;
		}
	</style>

    <!-- Bootstrap CSS -->
 	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"	crossorigin="anonymous"></script>
	<script src="http://code.jquery.com/jquery.js"></script>
    <title>Hello, world!</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg">
 		<a class="navbar-brand" href="list.do"></a>
  		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
   		 <span class="navbar-toggler-icon"></span>
  	</button>
  <div class="collapse navbar-collapse " id="navbarText">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link " href="/"><img src="/img/mainicon.png" style="width:90px"><span class="sr-only">(current)</span></a>
      </li>
       <li class="nav-item">
        <a class="nav-link text-secondary" href="/notice">&nbsp;&nbsp;????????????</a>
      </li>
       <li class="nav-item">
        <a class="nav-link text-secondary" href="/noticelist">&nbsp;&nbsp;????????????</a>
      </li>
      <li class="nav-item">
      <a class="nav-link text-secondary" href="/SendMessage">????????????</a>
	  </li>
    </ul>
      <span class="navbar-text">
    	<sec:authorize access="!isAuthenticated()">
    	<button type="button" class="btn btn-outline-warning" onclick="javascript:window.location='/loginForm'">?????????</button>&nbsp;
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
		 <span class="navbar-text">
   			<a class="text-secondary"  href="/mypage_main?member_id=<sec:authentication property="principal.Username"/>">???????????????</a>&nbsp;&nbsp;
   		 </span>
   	 		<button type="button" class="btn btn-outline-warning" onclick="javascript:window.location='/logout'">????????????</button>&nbsp;
		</sec:authorize>
    </span>
  </div>
</nav>
	<hr>

	<div class="container">
		<div class="page-header col font">
			<header>
				<p class="col-10 hi Secondary">????????????</p>
			</header>
		</div>
	
		<hr>
		<table class="table table-hover">
			<thead class="thead-light">
				<tr>
					<td>??????</td>
					<td>?????????</td>
					<td>??????</td>
					<td>??????</td>
					<td>?????????</td>
				</tr>
				<c:forEach var="noticeList" items="${noticeList}">
				<tbody>
				<tr>
					<td>${noticeList.noticeboard_number}</td>
					<td>${noticeList.noticeboard_nickname}</td>
					<td ><a href="/admin/content_view?noticeboard_number=${noticeList.noticeboard_number}" class="title">${noticeList.noticeboard_title}</a></td>
					<td>${fn:split(noticeList.noticeboard_date,' ')[0]}</td>
					<td>${noticeList.noticeboard_hit}</td>
				</tr>
				</tbody>
				</c:forEach>
				<tr>
					<td colspan="5">
					<c:set var="user"><sec:authentication property="principal.Username"/></c:set> 
					<button type="button" class="btn btn-outline-warning" onclick="javascript:window.location='/notice_write?user=${user}'">?????????</button>
					</td>
				</tr>
				<tr>
			  <c:forEach var="page" items="${page }">
			<td colspan="5">
			<ul class="pagination justify-content-center">
			    <!-- ?????? -->
			    <li class="page-item, page-link" href="/noticelist?page=1">
			    <c:choose>
			 
					<c:when test="${(page.curPage - 1) < 1}">
						First
					</c:when>
					<c:otherwise>
						<a href="/noticelist?page=1">First</a>
					</c:otherwise>
				</c:choose>
				</li>
				<!-- ?????? -->
			    <li class="page-item, page-link">
			    <c:choose>
					<c:when test="${(page.curPage - 1) < 1}">
						Prev
					</c:when>
					<c:otherwise>
						<a href="/noticelist?page=${page.curPage - 1}">Prev</a>
					</c:otherwise>
				</c:choose>
				</li>
			    <!-- ?????? ????????? -->
			    <li class="page-item, page-link" >
			    <c:forEach var="fEach" begin="${page.startPage}" end="${page.endPage}" step="1">
					<c:choose>
					<c:when test="${page.curPage == fEach}">
						 &nbsp; ${fEach}  &nbsp;
					</c:when>
					
					<c:otherwise>
						&nbsp;<a href="/noticelist?page=${fEach}"> ${fEach} </a> &nbsp;
					</c:otherwise>
					</c:choose>
				</c:forEach>
			    </li>
			    <!-- ?????? -->			   
			    <li class="page-item, page-link" >
			    <c:choose>
					<c:when test="${(page.curPage + 1) > page.totalPage}">
						Next
					</c:when>
					<c:otherwise>
						<a href="/noticelist?page=${page.curPage + 1}">Next</a>
					</c:otherwise>
				</c:choose>
			    </li>
			    <!-- ??? -->
			    <li class="page-item, page-link" >
			    <c:choose>
					<c:when test="${page.curPage == page.totalPage}">
						End
					</c:when>
					<c:otherwise>
						<a href="/noticelist?page=${page.totalPage}">End</a>
					</c:otherwise>
				</c:choose>
			    </li>
			  </ul>
			</td>
			</c:forEach>
		</tr>
			</thead>
		</table>
	</div>

	
	<div class="p-3 mb-2  text-black foot">
	<hr>
	<br>
		<div class="container">
			<footer>
			<div class="row">
			<div class="col-10">
				????????? : engudengud@gmail.com <br> ???????????? : 010-5918-3963 <br> ?????? : ????????? ????????? ????????? <br> ???????????? : 010-9273-9992 
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