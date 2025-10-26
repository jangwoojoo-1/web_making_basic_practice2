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
    <style>
        body{
            display: flex;
            justify-content: center;
        }
        div{
            width: 90%;
        }
        h1{
            font-weight: bold;
            font-size: 3rem;
        }
        table{
            text-align: center;
        }
        th{
            width: 4rem;
        }
        form{
            display: flex;
            justify-content: center;
        }
    </style>
    <script>
        function insert(){
            const form = document.querySelector('form');
            form.method = 'post';
            form.action = '/posts/save';
            form.submit();
        }
        function modify(){
            const form = document.querySelector('form');
            form.method = 'post';
            form.action = '/posts/update';
            form.submit();
        }
    </script>
</head>
<body>
<div>
    <h1>게시판</h1>
    <hr>
    <form>
        <c:if test="${req} == null">
            <table>
                <tr><th>제목</th><td><input type="text" name="title" placeholder="제목 입력"></td></tr>
                <tr><th>작성자</th><td><input type="text" name="writer" placeholder="작성자 입력"></td></tr>
                <tr><th>내용</th><td><textarea name="content" row="10" placeholder="내용 입력"></textarea></td></tr>
                <tr><th>비밀번호</th><td><input type="password" name="pwd" placeholder="비밃번호 입력"></td></tr>
            </table>
            <button onclick="insert()">글 등록</button>
        </c:if>
        <c:if test="${req} != null">
            <table>
                <input type="hidden" name="id" value="${req.getPostId()}">
                <tr><th>제목</th><td><input type="text" name="title" value="${req.getTitle()}" placeholder="제목 입력"></td></tr>
                <tr><th>작성자</th><td><input type="text" name="writer" value="${req.getWriter()}" placeholder="작성자 입력" readonly></td></tr>
                <tr><th>내용</th><td><textarea name="content" row="10" value="${req.getContent()}" placeholder="내용 입력"></textarea></td></tr>
                <tr><th>비밀번호</th><td><input type="password" name="pwd" placeholder="비밀번호 입력"></td></tr>
            </table>
            <button onclick="modify()">글 수정</button>
        </c:if>
    </form>
</div>
</body>
</html>