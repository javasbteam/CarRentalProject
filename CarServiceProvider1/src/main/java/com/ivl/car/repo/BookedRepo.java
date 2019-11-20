package com.ivl.car.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ivl.car.model.BookedCar;

@Repository("/bookedCar")
public interface BookedRepo extends MongoRepository<BookedCar, Integer> {

}
