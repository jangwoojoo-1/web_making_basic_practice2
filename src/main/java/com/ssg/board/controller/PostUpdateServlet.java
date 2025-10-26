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

@WebServlet(name="postUpdateServlet", urlPatterns = "/posts/update")
@Log4j2
public class PostUpdateServlet extends HttpServlet {

    private PostService postService = PostService.INSTANCE;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("postUpdateServlet doPost() 메서드 호출");

        req.setCharacterEncoding("UTF-8");

        PostDTO postDTO = new PostDTO();
        postDTO.setPostId(Long.parseLong(req.getParameter("id")));
        postDTO.setTitle(req.getParameter("title"));
        postDTO.setContent(req.getParameter("content"));

        String passphrase = req.getParameter("passphrase");

        boolean result = postService.edit(postDTO, passphrase);
        if(result) {
            resp.sendRedirect("/posts/edit?id=" + postDTO.getPostId());
        }
        resp.sendRedirect("/WEB-INF/views/error.jsp");
    }
}
