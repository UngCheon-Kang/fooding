package com.fooding.service;

import com.fooding.model.Location;
import com.fooding.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationService {

    private final LocationRepository locationRepo;

    public LocationService(LocationRepository locationRepo) {
        this.locationRepo = locationRepo;
    }

    // 사용자 위치 저장 또는 업데이트
    public Location save(Location location) {
        return locationRepo.save(location);
    }

    // 사용자 ID로 위치 조회
    public Optional<Location> findByUserId(Long userId) {
        return locationRepo.findById(userId);
    }

    // 위치 삭제
    public void delete(Long userId) {
        locationRepo.deleteById(userId);
    }
}
