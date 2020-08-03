package com.steele.weatherapp.repository;

import com.steele.weatherapp.model.ZipCode;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZipRepository extends JpaRepository<ZipCode, Long>{
    
}