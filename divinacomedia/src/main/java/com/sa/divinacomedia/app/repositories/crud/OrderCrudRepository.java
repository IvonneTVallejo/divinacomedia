package com.sa.divinacomedia.app.repositories.crud;

import com.sa.divinacomedia.app.entities.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Tatiana
 */

public interface OrderCrudRepository extends MongoRepository<Order,Integer>{

    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(final String country);

    @Query("{status: ?0}")
    List<Order> findByStatus(final String status);

    Optional<Order> findTopByOrderByIdDesc();


    List<Order> findBySalesManZone(String zone);

    List<Order> findBySalesManId(Integer id);

    List<Order> findBySalesManIdAndStatus(Integer id, String status);

    List<Order> findByRegisterDayAndSalesManId(Date registerDay,Integer id);

}
