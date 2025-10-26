package com.ssg.board.controller;


import com.ssg.board.dto.PostDTO;
import com.ssg.board.service.PostService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="postDetailServlet", urlPatterns = "/posts/view")
@Log4j2
public class PostDetailServlet extends HttpServlet {

    private PostService postService = PostService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Detail doGet() 메서드 호출");

        req.setCharacterEncoding("UTF-8");

        long postId = Long.parseLong(req.getParameter("id"));

        PostDTO dto = postService.getDetail(postId);
        req.setAttribute("post", dto);
        req.getRequestDispatcher("WEB-INF/views/detail.jsp").forward(req, resp);
    }
}
