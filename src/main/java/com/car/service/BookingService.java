package com.car.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.entity.Booking;
import com.car.entity.Car;
import com.car.entity.User;
import com.car.repository.BookingRepository;
import com.car.repository.CarRepository;
import com.car.repository.UserRepository;
@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private UserRepository userRepository;

    public String bookCar(Long userId, Long carId) {
        if (bookingRepository.existsByCarId(carId)) {
            return "Car already booked";
        }
        Optional<User> user = userRepository.findById(userId);
        Optional<Car> car = carRepository.findById(carId);
        if (user.isPresent() && car.isPresent()) {
            Booking booking = new Booking();
            booking.setUser(user.get());
            booking.setCar(car.get());
            booking.setBookingDate(java.time.LocalDateTime.now());
            bookingRepository.save(booking);
            return "Car booked successfully";
        }
        return "User or Car not found";
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public void deleteBooking(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}
