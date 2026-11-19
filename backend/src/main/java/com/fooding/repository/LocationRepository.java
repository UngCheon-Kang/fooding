package com.fooding.repository;

import com.fooding.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

// 사용자 위치 정보 저장/조회용 인터페이스
public interface LocationRepository extends JpaRepository<Location, Long> {

}
