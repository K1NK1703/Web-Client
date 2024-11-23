package ru.mpei.romanov.databases.web_client_app.rest.out;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mpei.romanov.databases.web_client_app.dto.response.UserResponseDto;
import ru.mpei.romanov.databases.web_client_app.entity.Editor;
import ru.mpei.romanov.databases.web_client_app.service.dto.UserDtoService;
import ru.mpei.romanov.databases.web_client_app.service.entity.EditorService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminRestController {

    private final EditorService editorService;
    private final UserDtoService userDtoService;

    @GetMapping("/users")
    public List<UserResponseDto> getAllUsers() {
        return userDtoService.getAllUsersDto();
    }

    @GetMapping("/editors")
    public List<Editor> getAllEditors() {
        return editorService.findAllEditors();
    }
}
