package com.sena.authentication.DTO;

import com.sena.authentication.Model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecoveryRequestDTO {
    private User user;
    private String token;
}
