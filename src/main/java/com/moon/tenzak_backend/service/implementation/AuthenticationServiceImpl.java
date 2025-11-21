package com.moon.tenzak_backend.service.implementation;


import com.moon.tenzak_backend.config.security.jwt.JwtUtil;
import com.moon.tenzak_backend.model.dto.authDto.*;
import com.moon.tenzak_backend.model.entity.User;
import com.moon.tenzak_backend.model.enumeration.UserRole;
import com.moon.tenzak_backend.model.mapper.UserMapper;
import com.moon.tenzak_backend.repository.UserRepository;
import com.moon.tenzak_backend.service.interfaces.IAuthenticationService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements IAuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final UserMapper userMapper;
    @Override
   // public AuthenticationResponse register(RegisterRequest request) {
    public String register(RegisterRequestDto request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email attribué à un autre utilisateur");

        }
        var user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(UserRole.B2C)
                .build();
        userRepository.save(user);

        return "Utilisateur enregistré avec succès";
    }

    @Override
    public AuthenticationResponseDto login(LoginRequestDto request) {
        try {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        } catch (org.springframework.security.authentication.BadCredentialsException e) {
            throw new RuntimeException("Identifiant ou mot de passe incorrect.");
        }

        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Email incorrect"));
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Mot de passe incorrect");
        }
        //user.get
        var jwtToken = jwtUtil.generateToken(user);
        user.setToken(jwtToken);
        System.out.println("user "+ user.toString());
        System.out.println("user dto "+ userMapper.toUserDto(user).toString());
       return userMapper.toUserDto(user);
    }

    public String updatePassword(UpdatePasswordRequestDto request) {
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(()->  new RuntimeException("Utilisateur introuvable"));

        if (!passwordEncoder.matches(request.getOldPassword(), user.getPassword())) {
            // return "Ancien mot de passe incorrect";
            throw new RuntimeException( "Ancien mot de passe incorrect");
        }
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        userRepository.save(user);
        return "Mot de passe mis à jour";
    }
    public String updateEmail(Integer userId, UpdateEmailRequestDto request) {
        User user = userRepository.findById(userId).orElseThrow(()->  new RuntimeException("Utilisateur introuvable"));
        if (userRepository.existsByEmail(request.getNewEmail()))  throw new RuntimeException("Email déjà attribué à un utilisateur");// return "Email déjà pris";


        user.setEmail(request.getNewEmail());
        userRepository.save(user);
        return "Email mis à jour";
    }
}
