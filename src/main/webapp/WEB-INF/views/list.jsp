<%--
  Created by IntelliJ IDEA.
  User: JangwooJoo
  Date: 2025-10-23
  Time: 오후 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>PostForm</title>
    <style>
        body{
            display: flex;
            justify-content: center;
        }
        div{
            width: 80%;
        }
        h1{
            font-weight: bold;
            font-size: 3rem;
        }
        h1, hr{
            margin: auto;
        }
        table{
            width: 95%;
            margin: 10px auto;
            background-color: whitesmoke;
        }
        table th{
            text-align: center;
        }
        table td:first-child{
            color: white;
        }
        form{
            display: flex;
            justify-content: center;
        }
        form button{
            width: 95%;
            background-color: whitesmoke;
        }
    </style>
</head>
<body>
    <div>
        <h1>게시판</h1>
        <hr>
        <table>
            <colgroup>
                <col style="width: 5%; background-color: cadetblue">
                <col style="width: 65%">
                <col style="width: 10%">
                <col style="width: 15%">
            </colgroup>
            <tr style="color: white; background-color: cadetblue;"><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th></tr>
            <c:forEach var="dto" items="${dtoList}">
                <tr>
                    <td>${dto.getPostId()}</td>
                    <td><a href="/posts/view?id=${dto.getPostId()}">${dto.getTitle()}</a></td>
                    <td>${dto.getWriter()}</td>
                    <td>${dto.getUpdatedAt()}</td>
                </tr>
            </c:forEach>
        </table>
        <form action="/posts/new" method="get">
            <button type="submit">글쓰기</button>
        </form>
    </div>
</body>
</html>