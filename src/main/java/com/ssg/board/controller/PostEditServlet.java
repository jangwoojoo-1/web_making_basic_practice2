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

@WebServlet(name="postEditServlet", urlPatterns = "/posts/edit")
@Log4j2
public class PostEditServlet extends HttpServlet {

    private PostService postService = PostService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("PostEditServlet.doGet() 메서드 호출");

        long postId = Long.parseLong(req.getParameter("id"));

        PostDTO dto = postService.getDetail(postId);

        req.setAttribute("req", dto);
        req.getRequestDispatcher("/WEB-INF/views/form.jsp").forward(req, resp);
    }
}
