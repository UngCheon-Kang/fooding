package com.fooding.service;

import com.fooding.model.User;
import com.fooding.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    // 사용자 등록
    public User save(User user) {
        return userRepo.save(user);
    }

    // 전체 사용자 목록 조회
    public List<User> findAll() {
        return userRepo.findAll();
    }

    // ID로 사용자 조회
    public Optional<User> findById(Long id) {
        return userRepo.findById(id);
    }

    // 사용자 삭제
    public void delete(Long id) {
        userRepo.deleteById(id);
    }
}
