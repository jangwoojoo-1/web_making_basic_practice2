<%--
  Created by IntelliJ IDEA.
  User: JangwooJoo
  Date: 2025-10-23
  Time: 오후 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PostForm</title>
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
        form{
            display: flex;
            justify-content: center;
        }
    </style>
</head>
<body>
<div>
    <h1>게시판</h1>
    <hr>
    <table>
        <colgroup>
            <col style="width: 3rem; background-color: cadetblue">
        </colgroup>
        <tr style="color: white; background-color: cadetblue;"><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th></tr>
        <c:forEach var="dto" items="list">
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