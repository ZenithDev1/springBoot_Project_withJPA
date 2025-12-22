package com.zenithdev.linkedin.hospitalManagement.dto;

import lombok.Data;

@Data
public class LoginResponseDto {

    String jwt;
    Long userId;
}
