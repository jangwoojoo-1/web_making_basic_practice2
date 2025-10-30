package com.ssg.board.service;

import com.ssg.board.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    void save(BoardDTO boardDTO);

    List<BoardDTO> getList();

    BoardDTO getDetail(Long postId);

    void removeOne(Long postId);

    void modifyOne(BoardDTO boardDTO);
}
