package com.corpchat.CorpChat.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MessageDto {
    private Long senderId;
    private Long receiverId;
    private String content;
}