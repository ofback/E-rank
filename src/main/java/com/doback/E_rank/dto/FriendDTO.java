package com.doback.E_rank.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FriendDTO {
    private int friendshipId;
    private int userId;
    private String nickname;
}