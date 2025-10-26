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
        String passphrase = req.getParameter("passphrase");

        boolean result = postService.remove(postId, passphrase);
        if(result) {
            resp.sendRedirect("/posts/list");
        }
        resp.sendRedirect("/WEB-INF/views/error.jsp");
    }
}
