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
import java.util.List;

@WebServlet(name="postListServlet", urlPatterns = "/posts")
@Log4j2
public class PostListServlet extends HttpServlet {
    // PostService 객체 생성
    private PostService postService = PostService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("/posts doGet() 메서드 호출");

        List<PostDTO> dtoList = postService.getList();
        req.setAttribute("dtoList", dtoList);
        req.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(req, resp);
    }

}
