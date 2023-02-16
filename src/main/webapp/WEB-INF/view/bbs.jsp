<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<script type="text/javascript">

function check(){
    var flag = 0;

    if(document.form1.name.value == ""){
        flag = 1;
    }
    else if(document.form1.comment.value == ""){
        flag = 1;
    }

    if(flag){
        window.alert('名前とコメントを入力してください'); 
        return false; 
    }
    else{
        return true; 
    }
}
</script>

<title>BBS</title>
</head>
<body>
<form action="/Ren02/bbs" method="post" name="form1" onSubmit="return check()">

<p>Name:<input type="text" name="name"></p>
<p>Comment:<br>
<textarea name="comment" rows="5" cols="40"></textarea>
</p>
<p><a href="http://localhost:8080/Ren02/EnjoyTravelling.html">Home<a/></p>

<p><input type="submit" value="Submit"><input type="reset" value="Reset">
</p>
</form>

<c:forEach var="kakikomi" items="${kakikomiList}">
<p>ID:<c:out value="${kakikomi.id}"/>　Name:<c:out value="${kakikomi.name}"/>　Date:<c:out value="${kakikomi.date}"/><br>
<c:out value="${kakikomi.comment}"/></p>
</c:forEach>

</body>
</html>