package com.ssg.board.controller;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="postNewFormServlet", urlPatterns = "/posts/new")
@Log4j2
public class PostNewFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("PostNewFormServlet doGet() 메서드 호출");

        req.setAttribute("req", null);
        req.getRequestDispatcher("/WEB-INF/views/form.jsp").forward(req, resp);
    }
}
