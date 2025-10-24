package com.ssg.board.service;

import com.ssg.board.dao.PostDAO;
import com.ssg.board.dto.PostDTO;

import java.util.List;

public class PostService {
    private final PostDAO dao;

    public PostService(PostDAO dao) {
        this.dao = dao;
    }

    public List<PostDTO> getList(int page, int size) {
        return null;
    }
    public PostDTO getDetail(long id) {
        return null;
    }                  // 조회수 증가 포함
    public long write(PostDTO post) {
        return 0;
    }                    // 검증 + 저장
    public void edit(PostDTO post, String passphrase) {

    }  // 비번검증 + 수정
    public void remove(long id, String passphrase) {

    }     // 비번검증 + 삭제
}
