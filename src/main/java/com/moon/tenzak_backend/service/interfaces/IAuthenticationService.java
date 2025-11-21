package com.moon.tenzak_backend.service.interfaces;


import com.moon.tenzak_backend.model.dto.authDto.*;

public interface IAuthenticationService {

    String register(RegisterRequestDto req);
    AuthenticationResponseDto login(LoginRequestDto req);
    String updatePassword(UpdatePasswordRequestDto request);
    String updateEmail(Integer userId, UpdateEmailRequestDto request);
}
