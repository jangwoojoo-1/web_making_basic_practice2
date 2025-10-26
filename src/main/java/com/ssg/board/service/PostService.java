package com.ssg.board.service;

import com.ssg.board.dao.PostDAO;
import com.ssg.board.dao.PostDAOImpl;
import com.ssg.board.dto.PostDTO;
import com.ssg.board.util.MapperUtil;
import com.ssg.board.vo.PostVO;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public enum PostService {
    // 객체로 접근
    INSTANCE;

    private PostDAO dao;
    private ModelMapper modelMapper;

    // 생성자에서 객체 생성
    PostService() {
        this.dao = new PostDAOImpl();
        this.modelMapper = MapperUtil.INSTANCE.getModelMapper();
    }

    // 게시글 목록 불러오는 메서드
    public List<PostDTO> getList() {
        List<PostVO> voList = dao.findAll(); // dao에서 vo 리스트 가져오기

        // ModelMapper를 활용한 vo 리스트 dto 리스트로 변환
        List<PostDTO> dtoList = voList.stream().map(vo -> modelMapper.map(vo, PostDTO.class)).collect(Collectors.toList());

        // dto 리스트 반환
        return dtoList;
    }

    public PostDTO getDetail(long id) {
        PostVO vo = dao.findById(id).orElse(null);
        PostDTO dto = modelMapper.map(vo, PostDTO.class);
        return dto;
    }

    public long write(PostDTO post) {
        PostVO vo = modelMapper.map(post, PostVO.class);
        long result = dao.save(vo);
        return result;
    }
    // 검증 + 저장
    public boolean edit(PostDTO post, String passphrase) {
        PostVO vo = modelMapper.map(post, PostVO.class);
        if(dao.checkPassphrase(post.getPostId(), passphrase)) {
            boolean result = dao.update(vo);
            return result;
        } else{
            return false;
        }
    }  // 비번검증 + 수정
    public boolean remove(long id, String passphrase) {
        if(dao.checkPassphrase(id, passphrase)) {
            boolean result = dao.delete(id);
            return result;
        } else{
            return false;
        }
    }     // 비번검증 + 삭제
}
