package com.fooding.controller;

import com.fooding.model.Location;
import com.fooding.service.LocationService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/locations")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    // 사용자 위치 저장 또는 수정
    @PostMapping
    public Location saveLocation(@RequestBody Location location) {
        return locationService.save(location);
    }

    // 사용자 ID로 위치 조회
    @GetMapping("/{userId}")
    public Optional<Location> getLocationByUser(@PathVariable Long userId) {
        return locationService.findByUserId(userId);
    }}