package com.moon.tenzak_backend;

import com.moon.tenzak_backend.model.entity.User;
import com.moon.tenzak_backend.model.enumeration.UserRole;
import com.moon.tenzak_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    // @Value("${data-loader.default-email-admin}")
    @Value("${DEFAULT_EMAIL_ADMIN}")
    private  String DEFAULT_EMAIL_ADMIN;
    // @Value("${data-loader.default-user-psw}")
    @Value("${DEFAULT_USER_PSW}")
    private  String DEFAULT_USER_PSW;

    @Override
    // @EventListener(ApplicationReadyEvent.class)
    public void run(String... args) {
/*System.out.println("DEFAULT_EMAIL_ADMIN "+DEFAULT_EMAIL_ADMIN);
System.out.println("DEFAULT_USER_PSW "+DEFAULT_USER_PSW);*/
        if (userRepository.findByEmail(DEFAULT_EMAIL_ADMIN).isEmpty()) {
            User user = new User();
            // user.setUsername("admin");
            user.setEmail(DEFAULT_EMAIL_ADMIN);
            user.setPassword(encoder.encode(DEFAULT_USER_PSW));
            user.setRole(UserRole.ADMIN);
            userRepository.save(user);
            System.out.println("ADMIN créé avec succès");
        }


    }
}
