<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 12/4/2021
  Time: 5:37 PM
  To change this template use File | Settings | File Templates.
--%>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/user-info.css">
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
            <a class="text-login" href="/login/showForm">Đăng nhập / Đăng ký</a>
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

<div class="content-user">
    <form:form action="processUpdate" modelAttribute="userUpdate" method="post">
        <span></span><form:input path="id" class="input" readonly="true" cssStyle="display: none"/> <br><br>
        <span>Tên tài khoản:</span> <form:input path="username" class="input" readonly="true" />
        <div><span></span><form:errors path="username" cssStyle="color: red"/></div>
        <br><br>
        <span>Họ tên:</span> <form:input path="fullName" class="input"/>
        <div><span></span><form:errors path="fullName" cssStyle="color: red"/></div>
        <br><br>
        <input type="submit" class="btn-update" value="Cập nhật">
    </form:form>
</div>

</body>
</html>
