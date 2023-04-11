<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../resources/signup/css/main.css">
    <%@include file="/WEB-INF/views/common/favicon.jsp" %>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js"></script>
    <script src="../resources/signup/js/main.js"></script>


</head>

<body>
<%@include file= "../common/header.jsp" %>
 

  

        <div class='wrapper'>
            
                <h1 id="title">회원가입</h1>

                <div class="signupbutton">
                     <a class="일반회원가입" href="/signup/agreement"><span id="일반"> 일반 회원가입</span></a>
                    <button type="button" class='소셜회원가입'>
                        <img class='소셜아이콘' src="../resources/imgs/navericon.png"><span class="pp"> 네이버 회원가입 </span></button>

                    <button type="button" class='소셜회원가입'>
                        <img class='소셜아이콘' src='../resources/imgs/kakaoicon.png'><span class="pp"> 카카오 회원가입 </span></button>
                
            </div>

            <div class='로그인'><a href="#">이미 아이디가 있다면? 로그인 하기></a></div>
        </div>

  
<%@include file= "../common/footer.jsp" %>
 

</body>

</html>