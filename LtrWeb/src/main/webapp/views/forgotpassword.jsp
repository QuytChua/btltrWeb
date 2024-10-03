<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quên mật khẩu</title>
</head>
<body>
<c:if test="${alert !=null}">
<h3 class="alert alertdanger">${alert}</h3>
</c:if>
<h2>Forgot Password</h2>
    <form action="forgotpassword" method="post">
        <label for="email">Enter your email:</label>
        <input type="email" id="email" name="email" required>
        
        <button type="submit">Submit</button>
        <br>
         <a href="login.jsp"><button type="button" class="cancelbtn">Cancel</button> </a>
    </form>

</body>
</html>