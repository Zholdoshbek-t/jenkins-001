package com.epam.jenkins.repo;

import com.epam.jenkins.entity.ThemeParkRide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThemeParkRideRepo extends JpaRepository<ThemeParkRide, Long> {
    List<ThemeParkRide> findByName(String name);
}
