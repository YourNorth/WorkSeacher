package com.tenere_bufo.itis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PasswordDto {
    private String oldPassword;
    private String newPassword;
    private String newRePassword;
}