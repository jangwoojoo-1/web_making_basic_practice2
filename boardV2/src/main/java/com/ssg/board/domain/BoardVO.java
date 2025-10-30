package com.ssg.board.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardVO {
    private Long postId;
    private String title;
    private String content;
    private String writer;
    private String passphrase;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
