package com.ssg.board.controller;

import com.ssg.board.dao.PostDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "boardReadController", urlPatterns = "/posts/view")
public class BoardReadController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        long id = Long.parseLong(req.getParameter("id"));

        //DAO 삽입 후 단건 가져오기
        // 가져와서 resp set해서 detail.jsp로 전송
    }
}
