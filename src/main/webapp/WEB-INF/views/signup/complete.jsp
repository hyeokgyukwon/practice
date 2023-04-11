<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../resources/signup/css/complete.css">
     <%@include file="/WEB-INF/views/common/favicon.jsp" %>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js"></script>
    <script src="../resources/signup/js/complete.js"></script>
    

    <title>Document</title>
</head>



<body class="body-wrapper">
   <%@include file= "../common/header.jsp" %>

    <section>
        <div class='wrapper'>
            <div class="탑로고">
                <img id="logo" src="../resources/imgs/logo.png">
            </div>

            <div class="가입단계">
                <div id="가입단계1">약관동의</div>
                <div class="triangle"></div>
                <div id="가입단계2">회원 정보 입력</div>
                <div class="triangle"></div>
                <div id="가입단계3">가입 완료</div>
            </div>



            <h1>Congratulations ! <br> <br>
                회원 가입이 완료되었습니다</h1>

              <div id="bottombtn">
                    <!-- <input type="button" class='메인으로' value="메인으로"> -->
                    <a id="가입하기" href="mymg/main"><span class="toMain">메인으로</span></a>
                </div>
        </div>
    </section>
    

	 <%@include file= "../common/footer.jsp" %>


</body>

</html>