<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">



    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

	<title>resAll.jsp</title>
    <!-- Css Styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Res/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Res/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Res/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Res/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Res/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Res/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Res/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Res/css/style.css" type="text/css">
</head>
<body>

<form method="post" name="frm" id="frm"
	  action="${pageContext.request.contextPath}/resSelect.do">
	<div class="col-lg-8 col-md-6s">
			<c:forEach items="${list}" var="res">
                <div class="row">
         
                        <div class="col-lg-6 col-md-6 col-sm-6">
                        <c:if test="${res.no%2==1}">
                            <div class="blog__item">
                                <div class="blog__item__pic">
                                    <img src="${pageContext.request.contextPath}/images/${res.filename}" alt="">
                                </div>
                                <div class="blog__item__text">
                                    <!-- <ul>
                                        <li><i class="fa fa-calendar-o"></i> May 4,2019</li>
                                        <li><i class="fa fa-comment-o"></i> 5</li>
                                    </ul> -->
                                    <h5><a href="resSelect.do?no=${res.getNo()}">${res.name}</a></h5>
                                    <p>${res.content} </p>
                                    <a href="resSelect.do?no=${res.getNo()}" class="blog__btn">READ MORE<span class="arrow_right"></span></a>
                                </div>
                            </div>
                           </c:if> 
                        </div>
                        <c:if test="${res.no%2==0}">      	
                        <div class="col-lg-6 col-md-6 col-sm-6">
                        
                            <div class="blog__item">
                                <div class="blog__item__pic">
                                    <img src="${pageContext.request.contextPath}/images/${res.filename}" alt="">
                                </div>
                                <div class="blog__item__text">
                                    <!-- <ul>
                                        <li><i class="fa fa-calendar-o"></i> May 4,2019</li>
                                        <li><i class="fa fa-comment-o"></i> 5</li>
                                    </ul> -->
                                    <h5><a href="resSelect.do?no=${res.getNo()}">${res.name}</a></h5>
                                    <p>${res.content} </p>
                                    <a href="resSelect.do?no=${res.getNo()}" class="blog__btn">READ MORE<span class="arrow_right"></span></a>
                                </div>
                            </div>
                            
                        </div>
              			</c:if>
                  </div>      
                        
    	 	</c:forEach>
    	 	
                        <div class="col-lg-12">
                            <div class="product__pagination blog__pagination">
                                <a href="#">1</a>
                                <a href="#">2</a>
                                <a href="#">3</a>
                                <a href="#"><i class="fa fa-long-arrow-right"></i></a>
                            </div>
                        </div>
                    </div>
             
          

	<table border="1" id="members">
		<thead>
			<tr>
				<th>번호</th>
				<th>식당이름</th>
				<th>파일이름</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list}" var="res">
			<tr>
				<td><a href="resSelect.do?no=${res.getNo()}">${res.no}. ${res.name}</a></td>
				<td>${res.content}</td>
				<td>${res.filename}</td>
		</c:forEach>
		</tbody>
	</table>
</form>
</body>
</html>