package com.ssg.board.mapper;

import com.ssg.board.domain.BoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    void insert(BoardVO boardVO);

    List<BoardVO> selectAll();

    BoardVO selectOne(Long postId);

    void delete(Long postId);

    void update(BoardVO todoVO);
}
