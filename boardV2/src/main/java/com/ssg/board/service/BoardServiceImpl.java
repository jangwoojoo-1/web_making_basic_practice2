package com.ssg.board.service;

import com.ssg.board.domain.BoardVO;
import com.ssg.board.dto.BoardDTO;
import com.ssg.board.repository.BoardDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class BoardServiceImpl implements BoardService {
    private final BoardDAO boardDAO;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public void save(BoardDTO boardDTO) {
        log.info(modelMapper);
        BoardVO boardVO = modelMapper.map(boardDTO, BoardVO.class);
        log.info(boardVO);
        boardDAO.insert(boardVO);
    }

    @Override
    @Transactional
    public List<BoardDTO> getList(){
        log.info(modelMapper);
        List<BoardVO> voList = boardDAO.selectAll();
        log.info(voList);
        List<BoardDTO> dtoList = voList.stream().map(boardVO -> {
            return modelMapper.map(boardVO, BoardDTO.class);
        }).collect(Collectors.toList());
        return dtoList;
    }

    @Override
    @Transactional
    public BoardDTO getDetail(Long postId) {
        BoardVO boardVO = boardDAO.selectOne(postId);
        BoardDTO boardDTO = modelMapper.map(boardVO, BoardDTO.class);
        return boardDTO;
    }

    @Override
    @Transactional
    public void removeOne(Long postId) {
        boardDAO.delete(postId);
    }

    @Override
    @Transactional
    public void modifyOne(BoardDTO boardDTO) {
        BoardVO boardVO = modelMapper.map(boardDTO, BoardVO.class);
        boardDAO.update(boardVO);
    }
}

