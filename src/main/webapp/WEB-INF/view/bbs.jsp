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

<title>掲示板</title>
</head>
<body>
<form action="/Ren02/bbs" method="post" name="form1" onSubmit="return check()">

<p>名前:<input type="text" name="name"></p>
<p>コメント:<br>
<textarea name="comment" rows="5" cols="40"></textarea>
</p>
<p><a href="http://localhost:8080/Ren02/EnjoyTravelling.html">ホームへ戻る<a/></p>

<p><input type="submit" value="送信"><input type="reset" value="リセット">
</p>
</form>

<c:forEach var="kakikomi" items="${kakikomiList}">
<p>ID:<c:out value="${kakikomi.id}"/>　名前:<c:out value="${kakikomi.name}"/>　日付:<c:out value="${kakikomi.date}"/><br>
<c:out value="${kakikomi.comment}"/></p>
</c:forEach>

</body>
</html>