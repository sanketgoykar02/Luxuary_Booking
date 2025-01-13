package com.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.car.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{

	boolean existsByCarId(Long carId);
}
