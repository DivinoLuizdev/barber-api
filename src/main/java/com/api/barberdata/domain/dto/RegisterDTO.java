package com.api.barberdata.domain.dto;

import com.api.barberdata.domain.enums.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
    
}

