package com.fooding.controller;

import com.fooding.model.User;
import com.fooding.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 전체 사용자 조회
    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    // 사용자 등록
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }

    // ID로 사용자 조회
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    // 사용자 삭제
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }
}
