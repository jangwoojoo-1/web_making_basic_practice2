package com.ssg.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    private Long postId;
    private String title;
    private String content;
    private String writer;
    private String passphrase;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
