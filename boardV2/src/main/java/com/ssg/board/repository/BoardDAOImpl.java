package com.ssg.board.repository;

import com.ssg.board.domain.BoardVO;
import com.ssg.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardDAOImpl implements BoardDAO {
    private final BoardMapper boardMapper;

    @Override
    public void insert(BoardVO boardVO) {
        boardMapper.insert(boardVO);
    }

    @Override
    public List<BoardVO> selectAll() {
        return boardMapper.selectAll();
    }

    @Override
    public BoardVO selectOne(Long postId) {
        return boardMapper.selectOne(postId);
    }

    @Override
    public void delete(Long postId) {
        boardMapper.delete(postId);
    }

    @Override
    public void update(BoardVO boardVO) {
        boardMapper.update(boardVO);
    }
}
