package com.ssg.board.dao;

import com.ssg.board.dto.PostDTO;
import com.ssg.board.util.DBUtil;
import com.ssg.board.vo.PostVO;
import lombok.Cleanup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PostDAOImpl implements PostDAO {

    @Autowired
    private DataSource dataSource;

    // 데이터베이스에서 게시글 목록 가져오는 메서드
    @Override
    public List<PostVO> findAll() {
        // sql 문
        String sql = "select * from board_post";
        // try resource 구조로 연결 자동으로 닫기
        try(Connection conn= dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
        ) {
            List<PostVO> list = new ArrayList<>();
            while (rs.next()) {
                PostVO post = PostVO.builder()
                        .postId(rs.getLong("post_id"))
                        .title(rs.getString("title"))
                        .content(rs.getString("content"))
                        .writer(rs.getString("writer"))
                        .passphrase(rs.getString("passphrase"))
                        .createdAt(rs.getTimestamp("created_at").toLocalDateTime())
                        .updatedAt(rs.getTimestamp("updated_at").toLocalDateTime())
                        .build();

                list.add(post);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean countAll() {
        return false;
    }

    @Override
    public Optional<PostVO> findById(long id) {
        String sql = "select * from board_post where post_id=?";
        // try resource 구조로 연결 자동으로 닫기
        try(Connection conn= dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setLong(1, id);
            try(ResultSet rs = pstmt.executeQuery();) {
                if(rs.next()) {
                    PostVO post = PostVO.builder()
                            .postId(rs.getLong("post_id"))
                            .title(rs.getString("title"))
                            .content(rs.getString("content"))
                            .writer(rs.getString("writer"))
                            .passphrase(rs.getString("passphrase"))
                            .createdAt(rs.getTimestamp("created_at").toLocalDateTime())
                            .updatedAt(rs.getTimestamp("updated_at").toLocalDateTime())
                            .build();
                    return Optional.of(post);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    // 데이터베이스 게시글을 저장하는 메서드
    @Override
    public long save(PostVO post) {
        //sql문
        // post_id, created_at, updated_at은 자동
        String sql = "insert into board_post(title, content, writer,passphrase) values(?,?,?,?)";
        // try resource 구조로 연결 자동으로 닫기
        try(Connection conn= dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, post.getTitle());
            pstmt.setString(2, post.getContent());
            pstmt.setString(3, post.getWriter());
            pstmt.setString(4, post.getPassphrase());

            long result = pstmt.executeUpdate();
            return result;
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean update(PostVO post) {
        //sql문
        // post_id, created_at, updated_at은 자동
        String sql = "update board_post set title=?,content=? where post_id=?";
        // try resource 구조로 연결 자동으로 닫기
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, post.getTitle());
            pstmt.setString(2, post.getContent());
            pstmt.setLong(3, post.getPostId());

            long result = pstmt.executeUpdate();
            if(result > 0) {
                return true;
            } else {
                return false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        //sql문
        // post_id, created_at, updated_at은 자동
        String sql = "delete from board_post where post_id=?";
        // try resource 구조로 연결 자동으로 닫기
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setLong(1, id);

            int result = pstmt.executeUpdate();
            if(result > 0) {
                return true;
            } else {
                return false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkPassphrase(long id, String passphrase) {
        String sql = "select passphrase from board_post where post_id=?";

        // try resource 구조로 연결 자동으로 닫기
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setLong(1, id);
            try(ResultSet rs = pstmt.executeQuery();) {
                if(rs.next()) {
                    String password = rs.getString("passphrase");
                    if(password.equals(passphrase)) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;

    }
}
