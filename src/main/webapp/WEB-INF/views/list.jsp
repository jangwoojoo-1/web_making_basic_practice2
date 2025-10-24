<%--
  Created by IntelliJ IDEA.
  User: JangwooJoo
  Date: 2025-10-23
  Time: 오후 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>BoardMain</title>
</head>
<body>
    <h1>게시판</h1>
    <hr>
    <table>
        <tr><th>번호</th><th>제목</th><th>작성자</th></tr>
        <c:forEach var="dto" items="list">
            <tr>
                <td>${dto.getPostId()}</td>
                <td><a href="/post/view?id=${dto.getPostId()}">${dto.getTitle()}</a></td>
                <td>${dto.getWriter()}</td>
            </tr>
        </c:forEach>
    </table>
    <form action="/posts/new" method="get">
        <button type="submit">글쓰기</button>
    </form>
</body>
</html>
