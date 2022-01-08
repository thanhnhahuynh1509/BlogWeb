<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 11/28/2021
  Time: 10:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MY BLOG</title>
    <script src="//cdn.ckeditor.com/4.17.1/full/ckeditor.js"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;1,300;1,400;1,500;1,600;1,700;1,800&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/form.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
</head>
<body>

    <form:form action="processForm" autocomplete="off" modelAttribute="post" method="post">

        <form:input path="title"  placeholder="Tiêu đề (*)" class="input"/>
        <form:errors path="title" cssClass="error"/>
        <br><br>
        <form:input path="desc" autocomplete="off" placeholder="Mô tả (*)" class="input"/>
        <form:errors path="desc" cssClass="error"/>
        <br><br>
        <form:textarea path="content" autocomplete="off" id="editor"/>
        <form:errors path="content" cssClass="error"/>
        <br><br>
        <form:input path="image" autocomplete="off" placeholder="Liên kết hình ảnh (*)" class="input"/>
        <form:errors path="image" cssClass="error"/>
        <br><br>
        <form:input path="readMinutes" autocomplete="off" placeholder="Số phút đọc (*)" class="input"/>
        <form:errors path="readMinutes" cssClass="error"/>
        <br><br>
        <a href="/user/myPost" class="btn-delete" style="background-color: #ced029">Hủy</a>
        <input type="submit" value="Đăng bài" class="btn-submit">
    </form:form>

    <script>
        CKEDITOR.replace( 'editor');
    </script>

</body>
</html>
