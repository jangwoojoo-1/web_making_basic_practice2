package com.ssg.board.controller;

import com.ssg.board.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="postDeleteServlet", urlPatterns = "/posts/delete")
public class PostDeleteServlet extends HttpServlet {

    private PostService postService = PostService.INSTANCE;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        long postId = Long.parseLong(req.getParameter("id"));
        String passphrase = req.getParameter("pwd");

        boolean result = postService.remove(postId, passphrase);
        if(result) {
            resp.sendRedirect("/posts"); // 목록 페이지로 리다이렉트
        } else {
            // *** 수정된 부분 ***
            // 실패 시 error.jsp로 포워딩 (또는 리다이렉트)
            req.setAttribute("errorMsg", "삭제에 실패했습니다. 비밀번호를 확인하세요.");
            req.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(req, resp);
        }
        // *** 삭제된 부분 ***
        // resp.sendRedirect("/WEB-INF/views/error.jsp"); // 이중 리다이렉트 오류
    }
}
