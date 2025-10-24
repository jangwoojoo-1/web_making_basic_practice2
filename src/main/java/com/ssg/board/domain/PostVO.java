package com.ssg.board.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PostVO {
    private long post_id;
    private String title;
    private String content;
    private String writer;
    private String passphrase;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
