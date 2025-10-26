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
    <title>BoardPost</title>
    <script>
        function modify(){
            const form = document.querySelector('form');
            form.method('get');
            form.action('/posts/edit');
            form.submit();
        }
        function deletePost(){
            const form = document.querySelector('form');
            form.method('post');
            form.action('/posts/delete');
            form.submit();
        }
    </script>
</head>
<body>
    <h1>게시판</h1>
    <hr>
    <table>
        <tr><th>제목</th><th>${post.getTitle()}</th></tr>
        <tr><th>작성자</th><td>${post.getWriter()}</td></tr>
        <tr><th>작성일</th><td>${post.getUpdatedAt()}</td></tr>\
        <tr><th>내용</th><td>${post.getContent()}</td></tr>
    </table>
    <form>
        <input type="hidden" name="id" value="${post.getPostId()}">
        <button onclick="modify()">수정</button>&nbsp;
        <button onclick="deletePost()">삭제</button>
    </form>

</body>
</html>
