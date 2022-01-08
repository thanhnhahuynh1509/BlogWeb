<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 12/1/2021
  Time: 10:42 AM
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" integrity="sha512-Fo3rlrZj/k7ujTnHg4CGR2D7kSs0v4LLanw2qksYuRlEzO+tcaEPQogQ0KaoGN26/zrn20ImR1DfuLWnOo7aBA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;1,300;1,400;1,500;1,600;1,700;1,800&display=swap" rel="stylesheet">
</head>
<body>

<div class="content">
    <div class="container-form-login">
        <div class="logo">MY BLOG</div>
        <div class="name">Đăng nhập vào MY BLOG</div>
        <div class="form">
            <div style="color: red">${msg}</div>
            <form action="/login/handleLogin" method="post" autocomplete="off">
                <c:if test="${postId != null}">
                    <input type="text" value="${postId}" name="postId" style="display: none">
                </c:if>

                <div class="contain-input">
                    <input type="text" class="input" placeholder="Tên đăng nhập" name="username">
                    <span class="icon-form">
                            <i class="fas fa-user"></i>
                    </span>
                </div>

                <br>

                <div class="contain-input">

                    <input type="password" class="input" placeholder="Mật khẩu" name="password">
                    <span class="icon-form">
                            <i class="fas fa-lock"></i>
                    </span>
                </div>
                <br>
                <input type="submit" value="Đăng nhập" class="btn-login">
            </form>
        </div>
        <div class="btn-register-redirect">
            <a>Tạo tài khoản</a>
        </div>
    </div>

    <div class="container-form-register">
        <div class="logo">MY BLOG</div>
        <div class="name">Đăng ký tài khoản MY BLOG</div>
        <div class="form">
            <div style="color: red">${msgRegis}</div>
            <form action="/login/register" method="post"  autocomplete="off">

                <div class="contain-input">
                    <c:if test="${postId != null}">
                        <input type="text" value="${postId}" name="postId" style="display: none">
                    </c:if>
                    <input type="text" class="input" name="username" placeholder="Tên đăng nhập"/>
                    <span class="icon-form">
                            <i class="fas fa-user"></i>
                    </span>

                </div>

                <br>

                <div class="contain-input">

                    <input type="password" class="input" name="password" placeholder="Mật khẩu"/>
                    <span class="icon-form">
                            <i class="fas fa-lock"></i>
                    </span>

                </div>

                <br>


                <div class="contain-input">

                    <input type="password" class="input" name="passwordAgain" placeholder="Nhập lại mật khẩu"/>
                    <span class="icon-form">
                            <i class="fas fa-lock"></i>
                        </span>

                </div>

                <br>

                <div class="contain-input">

                    <input type="text" class="input" name="fullName" placeholder="Họ tên"/>
                    <span class="icon-form">
                            <i class="fas fa-signature"></i>
                    </span>
                </div>

                <br>

                <input type="submit" value="Đăng ký" class="btn-login">

            </form>
        </div>
        <div class="btn-login-redirect">
            <a>Đăng nhập</a>
        </div>
    </div>
</div>



<script>

    var btnRedirectRegis = document.querySelector(".btn-register-redirect");
    var btnRedirectLogin = document.querySelector(".btn-login-redirect");
    var loginForm = document.querySelector(".container-form-login");
    var registerForm = document.querySelector(".container-form-register");
    btnRedirectRegis.addEventListener('click', () => {
        loginForm.classList.add('display-none-form')
        registerForm.classList.add('show-form')
    })

    btnRedirectLogin.addEventListener('click', () => {
        loginForm.classList.remove('display-none-form')
        registerForm.classList.remove('show-form')
    })

</script>

</body>
</html>