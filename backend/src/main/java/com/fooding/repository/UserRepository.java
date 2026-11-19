package com.fooding.repository;

import com.fooding.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// 사용자 정보를 조회/저장하는 인터페이스
public interface UserRepository extends JpaRepository<User, Long> {

}
