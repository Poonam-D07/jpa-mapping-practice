package com.poonam.one_to_one_mapping.mapping.Controller;

import com.poonam.one_to_one_mapping.mapping.Controller.ONE_TO_ONE.Entity.DTO.UserRequestDTO;
import com.poonam.one_to_one_mapping.mapping.Controller.ONE_TO_ONE.Entity.DTO.UserResponseDTO;
import com.poonam.one_to_one_mapping.mapping.Controller.ONE_TO_ONE.Entity.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO response = userService.createUser(userRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable Long id) {
        UserResponseDTO response = userService.getUserById(id);
        return ResponseEntity.ok().body(response);
    }

}
