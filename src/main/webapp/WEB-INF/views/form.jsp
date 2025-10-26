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
            width: 80%; /* list.jsp, detail.jsp와 통일 */
        }
        h1{
            font-weight: bold;
            font-size: 3rem;
        }
        h1, hr{
            width: 95%; /* hr 너비 설정 */
            margin: auto;
        }
        table{
            width: 95%;
            margin: 10px auto;
            border-collapse: collapse;
        }
        table th, table td {
            padding: 12px;
            border: 1px solid #ddd;
        }
        table th {
            background-color: cadetblue;
            color: white;
            text-align: center; /* 폼에서는 중앙 정렬 */
            width: 15%; /* th 너비 고정 */
        }
        table td {
            background-color: whitesmoke;
        }

        /* 폼 입력 요소(input, textarea) 스타일 */
        table input[type="text"],
        table input[type="password"],
        table textarea {
            width: 95%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box; /* 패딩이 너비에 포함되도록 */
        }
        table textarea {
            resize: vertical;
            min-height: 120px;
        }

        /* 폼 버튼 정렬 (detail.jsp와 동일하게) */
        form{
            width: 95%;
            margin: 20px auto;
            text-align: right;
        }
        form button{
            background-color: cadetblue;
            color: white;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            font-size: 1rem;
        }
        form button:hover {
            background-color: #5F9EA0;
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
        <c:if test="${dto == null}">
            <table>
                <tr><th>제목</th><td><input type="text" name="title" placeholder="제목 입력"></td></tr>
                <tr><th>작성자</th><td><input type="text" name="writer" placeholder="작성자 입력"></td></tr>
                <tr><th>내용</th><td><textarea name="content" row="10" placeholder="내용 입력"></textarea></td></tr>
                <tr><th>비밀번호</th><td><input type="password" name="pwd" placeholder="비밃번호 입력"></td></tr>
            </table>
            <button onclick="insert()">글 등록</button>
        </c:if>
        <c:if test="${dto != null}">
            <table>
                <input type="hidden" name="id" value="${dto.getPostId()}">
                <tr><th>제목</th><td><input type="text" name="title" value="${dto.getTitle()}" placeholder="제목 입력"></td></tr>
                <tr><th>작성자</th><td><input type="text" name="writer" value="${dto.getWriter()}" placeholder="작성자 입력" readonly></td></tr>
                <tr><th>내용</th><td><textarea name="content" row="10" placeholder="내용 입력">${dto.getContent()}</textarea></td></tr>
                <tr><th>비밀번호</th><td><input type="password" name="pwd" placeholder="비밀번호 입력"></td></tr>
            </table>
            <button type="button" onclick="modify()">글 수정</button>
        </c:if>
    </form>
</div>
</body>
</html>