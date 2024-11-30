package ru.mpei.romanov.databases.web_client_app.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import ru.mpei.romanov.databases.web_client_app.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mpei.romanov.databases.web_client_app.service.dto.UserDtoService;
import ru.mpei.romanov.databases.web_client_app.service.entity.UserService;
import ru.mpei.romanov.databases.web_client_app.dto.request.UserRequestDto;
import ru.mpei.romanov.databases.web_client_app.dto.response.UserResponseDto;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserRestController {

    private final UserService userService;
    private final UserDtoService userDtoService;

    @GetMapping("/info")
    public User getUser(Principal principal) {
        return userService.findUserByUsername(principal.getName())
                .orElseThrow(() -> new UsernameNotFoundException("User " + principal.getName() + " not found!"));
    }

    @GetMapping
    public ResponseEntity<User> getUserById(@RequestParam("id") Long id) {
        User user = userService.findUserById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User " + id + " not found!"));
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/roles")
    public ResponseEntity<List<String>> getUserRoles(Authentication authentication) {
        return ResponseEntity.ok(authentication
                                        .getAuthorities()
                                        .stream()
                                        .map(GrantedAuthority::getAuthority)
                                        .toList());
    }

    @GetMapping("/users")
    public List<UserResponseDto> getAllUsers() {
        return userDtoService.getAllUsersDto();
    }

    @PostMapping
    public ResponseEntity<UserRequestDto> createUser(@RequestBody UserRequestDto userRequestDto) {
        userService.saveUser(userRequestDto);
        return ResponseEntity.ok(userRequestDto);
    }

    @PutMapping
    public ResponseEntity<UserRequestDto> updateUser(@RequestParam("id") Long id, @RequestBody UserRequestDto userRequestDto) {
        userService.updateUser(id, userRequestDto);
        return ResponseEntity.ok(userRequestDto);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUser(@RequestParam("id") Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}
