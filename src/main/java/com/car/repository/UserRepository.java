package com.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.car.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
