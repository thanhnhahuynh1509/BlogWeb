<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 11/27/2021
  Time: 5:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MY BLOG</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/user-post.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" integrity="sha512-Fo3rlrZj/k7ujTnHg4CGR2D7kSs0v4LLanw2qksYuRlEzO+tcaEPQogQ0KaoGN26/zrn20ImR1DfuLWnOo7aBA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;1,300;1,400;1,500;1,600;1,700;1,800&display=swap" rel="stylesheet">
</head>
<body>

<div id="header">
    <div class="left-header">
        <h2>MY BLOG</h2>
        <ul>
            <li><a href="/">Bài Viết</a></li>
            <li><a href="">Thảo luận</a></li>
        </ul>
    </div>
    <div class="middle-header">
        <input type="text" name="search" autocomplete="off" placeholder="Tìm kiếm bài viết"/>
        <a href="" class="logo-search"><i class="fas fa-search"></i></a>
    </div>

    <div class="right-header">
        <c:if test="${username == null}">
            <a class="text-login" href="login/showForm">Đăng nhập / Đăng ký</a>
        </c:if>
        <c:if test="${username != null}">
            <a class="btn-user"> ${name} </a>
            <ul>
                <li><a href="/post/showForm">Viết bài</a></li>
                <li><a href="/user/myPost">Bài viết của bạn</a></li>
                <li><a href="/user/myInfo">Thông tin tài khoản</a></li>
                <li><a href="/login/logout">Đăng xuất</a></li>
            </ul>
        </c:if>
    </div>
</div>

<div id="body">

    <div class="title-body">Bài viết của bạn</div>


    <c:if test="${user.postList.size() == 0}">
        <div class="message">Bạn chưa có bài viết nào đã viết... bạn có thể <a class="click" href="/post/showForm">viết bài tại đây</a></div>
    </c:if>

    <c:forEach var="post" items="${user.postList}">


        <div class="tag">


            <div class="content-tag">
                <div class="left-tag">

                    <a href="">
                        <div class="avatar">
                            <img src="https://images.pexels.com/photos/10334932/pexels-photo-10334932.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940" alt="avatar">
                            <span>${post.user.fullName}</span>
                        </div>
                    </a>

                    <div class="content">
                        <a href="/post/showFormUpdate?id=${post.id}"><h2>${post.title}</h2></a>
                        <p>${post.desc}</p>
                    </div>

                    <div class="time">
                        <span>${post.date}</span>
                        .
                        <span>${post.readMinutes} phút đọc</span>
                    </div>
                </div>
                <div class="right-tag">
                    <img src="${post.image}" alt="">
                </div>
            </div>
            <p class="line"></p>

        </div>
    </c:forEach>

</div>

<div id="footer"></div>

</body>
</html>