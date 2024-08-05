package br.ufscar.dc.dsw.bikerental.usecase.authentication;

import br.ufscar.dc.dsw.bikerental.entity.authentication.gateway.UserGateway;
import br.ufscar.dc.dsw.bikerental.entity.authentication.model.User;
import br.ufscar.dc.dsw.bikerental.usecase.authentication.dto.LoginUserDto;
import br.ufscar.dc.dsw.bikerental.usecase.authentication.dto.RegisterUserDto;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthenticationUseCase {
    private final UserGateway userGateway;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationUseCase(
        UserGateway userGateway,
        AuthenticationManager authenticationManager,
        PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userGateway = userGateway;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(RegisterUserDto input) {
        var user = new User()
            .setFullName(input.getFullName())
            .setEmail(input.getEmail())
            .setPassword(passwordEncoder.encode(input.getPassword()));

        return userGateway.save(user);
    }

    public User authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                input.getEmail(),
                input.getPassword()
            )
        );

        return userGateway.findByEmail(input.getEmail()).orElseThrow();
    }

    public List<User> allUsers() {
        List<User> users = new ArrayList<>();

        userGateway.findAll().forEach(users::add);

        return users;
    }
}