package com.ssg.board.repository;

import com.ssg.board.domain.BoardVO;

import java.util.List;

public interface BoardDAO {
    void insert(BoardVO boardVO);

    List<BoardVO> selectAll();

    BoardVO selectOne(Long postId);

    void delete(Long postId);

    void update(BoardVO boardVO);
}
