package com.doback.E_rank.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PendingRequestDTO {
    private int friendshipId;
    private int senderId;
    private String senderNickname;
    private String requestDate;
}