package ru.mpei.romanov.databases.web_client_app.rest.out;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mpei.romanov.databases.web_client_app.entity.User;
import ru.mpei.romanov.databases.web_client_app.service.entity.UserService;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserRestController {

    private final UserService userService;

    @GetMapping
    public User getUser(Principal principal) {
        return userService.findUserByUsername(principal.getName())
                .orElseThrow(() -> new UsernameNotFoundException("User " + principal.getName() + " not found!"));
    }

    @GetMapping("/roles")
    public ResponseEntity<List<String>> getUserRoles(Authentication authentication) {
        return ResponseEntity.ok(authentication
                                        .getAuthorities()
                                        .stream()
                                        .map(GrantedAuthority::getAuthority)
                                        .toList());
    }
}
