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
    <style>
        body{
            display: flex;
            flex-direction: column;
            align-items: center;
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
            width: 95%; /* hr가 div 너비에 맞게 */
        }
        table{
            width: 95%;
            margin: 10px auto;
            border-collapse: collapse; /* 테이블 선을 깔끔하게 */
        }
        /* 테이블의 th(헤더)와 td(내용)에 스타일 적용 */
        table th, table td {
            padding: 12px;
            border: 1px solid #ddd;
        }
        /* th(제목 셀) 스타일 */
        table th {
            background-color: cadetblue;
            color: white;
            text-align: center;
            width: 20%; /* th 너비 고정 */
        }
        /* td(내용 셀) 스타일 */
        table td {
            background-color: whitesmoke;
        }
        /* 폼 스타일: 버튼들을 오른쪽 정렬 */
        form{
            width: 95%;
            margin: 20px auto;
            text-align: right;
        }
        /* 버튼 스타일 */
        form button{
            background-color: cadetblue;
            color: white;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            font-size: 1rem;
            margin-left: 5px;
        }
        form button:hover {
            background-color: #5F9EA0; /* 마우스 오버 시 색상 변경 */
        }
    </style>
    <script>
        function modify(){
            const form = document.querySelector('form');
            form.method = 'get';
            form.action = '/posts/edit';
            form.submit();
        }
        function deletePost(){
            const password = prompt("게시글 삭제를 위해 비밀번호를 입력하세요:");

            // 2. 사용자가 '취소'를 누른 경우 (password == null)
            if (password === null) {
                return; // 아무것도 하지 않고 함수 종료
            }

            // 3. 사용자가 '확인'을 눌렀으나 값을 입력하지 않은 경우
            if (password === '') {
                alert('비밀번호를 입력해야 합니다.');
                return; // 함수 종료
            }

            // 4. 폼(form)과 히든 필드(pwd) 찾기
            const form = document.querySelector('form');
            const pwdInput = document.getElementById('pwd');

            // 5. 히든 필드에 입력받은 비밀번호 값 설정
            pwdInput.value = password;

            // 6. 폼 속성 설정 및 전송
            form.method = 'post';
            form.action = '/posts/delete';
            form.submit();
        }
    </script>
</head>
<body>
    <h1>게시판</h1>
    <hr>
    <table>
        <colgroup>
            <col style="width: 15%">
            <col style="width: 90%">
        </colgroup>
        <tr><th>제목</th><td>${post.getTitle()}</td></tr>
        <tr><th>작성자</th><td>${post.getWriter()}</td></tr>
        <tr><th>작성일</th><td>${post.getUpdatedAt()}</td></tr>
        <tr><th>내용</th><td>${post.getContent()}</td></tr>
    </table>
    <form>
        <input type="hidden" name="id" value="${post.getPostId()}">
        <input type="hidden" name="pwd" id="pwd">
        <button onclick="modify()" style="width: 49%">수정</button>&nbsp;
        <button onclick="deletePost()" style="width: 49%">삭제</button>
    </form>
</body>
</html>
