package com.sa.divinacomedia.app.repositories;

import com.sa.divinacomedia.app.entities.Order;
import com.sa.divinacomedia.app.entities.User;
import com.sa.divinacomedia.app.repositories.crud.OrderCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * @author Tatiana
 */

@Repository
public class OrderRepository {

    @Autowired
    private OrderCrudRepository repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Order> getAll(){
        return (List<Order>) repository.findAll();
    }

    public Optional<Order> getOrder(int id){
        return repository.findById(id);
    }

    public Order save(Order order){
        return repository.save(order);
    }

    public void delete(Integer id){repository.deleteById(id);}


    public List<Order> findByZone(String zona){
        return repository.findByZone(zona);
    }


}
