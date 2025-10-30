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

        String passphrase = req.getParameter("pwd");

        boolean result = postService.edit(postDTO, passphrase);
        if(result) {
            // 수정 성공 시 상세 조회 페이지로 리다이렉트
            resp.sendRedirect("/posts/view?id=" + postDTO.getPostId()); //
        } else {
            // *** 수정된 부분 ***
            // 실패 시 error.jsp로 포워딩
            req.setAttribute("errorMsg", "수정에 실패했습니다. 비밀번호를 확인하세요.");
            req.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(req, resp);
        }
    }
}
