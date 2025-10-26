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

@WebServlet(name = "postSaveServlet", urlPatterns = "/posts/save")
@Log4j2
public class PostSaveServlet extends HttpServlet {

    private PostService postService = PostService.INSTANCE;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("postSaveServlet doPost() 메서드 호출");

        req.setCharacterEncoding("UTF-8");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String writer = req.getParameter("writer");
        String password = req.getParameter("pwd");

        PostDTO postDTO = new PostDTO();
        postDTO.setTitle(title);
        postDTO.setContent(content);
        postDTO.setWriter(writer);
        postDTO.setPassphrase(password);

        long result = postService.write(postDTO);
        if (result > 0) {
            resp.sendRedirect("/posts");
        } else{
            req.setAttribute("result", false);
            req.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(req, resp);
        }
    }
}
