<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 11/28/2021
  Time: 1:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/post.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common2.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" integrity="sha512-Fo3rlrZj/k7ujTnHg4CGR2D7kSs0v4LLanw2qksYuRlEzO+tcaEPQogQ0KaoGN26/zrn20ImR1DfuLWnOo7aBA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<script src="//cdn.ckeditor.com/4.17.1/basic/ckeditor.js"></script>
<link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;1,300;1,400;1,500;1,600;1,700;1,800&display=swap" rel="stylesheet">
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

<div id="post">
    <div class="post-right">
        <h1>${post.title}</h1>
        <div class="avatar">
            <img src="https://images.pexels.com/photos/10334932/pexels-photo-10334932.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940" alt="avatar">
            <div class="info">
                <p>${post.user.fullName}</p>
                <p class="time"><span>${post.date}</span>.<span>${post.readMinutes} phút đọc</span></p>
            </div>
        </div>

        <div class="content-post">
            ${post.content}
        </div>

    </div>
</div>

<div class="footer">

    <div class="content-comment">
        <hr>
        <h3 class="header-comment">Bình luận:</h3>
        <form action="/comments/handleComment" method="post">

            <input style="display: none" type="text" value="${post.id}" name="postId">

            <input style="display: none" type="text" value="${username}" name="username">

            <textarea name="content"></textarea>

            <c:if test="${username != null}">
                <input type="submit" value="Bình luận" class="btn-input">
            </c:if>

            <c:if test="${username == null}">
                <div class="text-message">Vui lòng <a href="/login/showForm/${post.id}">đăng nhập</a> để viết bình luận</div>
            </c:if>

            <span style="color: red">${msg}</span>

        </form>

        <div class="content-user-comment">

            <div class="msg-comment"> <h3>Số người bình luận ${post.commentList.size()}:</h3> </div>

            <c:if test="${post.commentList.size() == 0}">
                <div>Bài viết chưa có bình luận. Hãy là người bình luận đầu tiên...</div>
            </c:if>
            <c:forEach items="${post.commentList}" var="comment">
                <div class="user-comment">
                    <div class="avatar avatar-flex">
                        <div class="sub-avatar">
                            <img src="https://images.pexels.com/photos/10334932/pexels-photo-10334932.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940" alt="avatar">
                            <div class="info">
                                <p>${comment.user.fullName}</p>
                                <p class="time"><span>${comment.date}</span></p>
                            </div>
                        </div>
                        <c:if test="${username != null}">
                            <c:if test="${username.equals(comment.user.username) || username.equals(post.user.username)}">
                                <a class="btn-delete-comment" href="/comments/delete?cmtId=${comment.id}&postId=${post.id}">Xóa</a>
                            </c:if>
                        </c:if>
                    </div>
                    <div class="content">
                        ${comment.content}
                    </div>


                </div>
            </c:forEach>

        </div>

    </div>
</div>


<script>
    CKEDITOR.replace( 'content' );
</script>

</body>
</html>
