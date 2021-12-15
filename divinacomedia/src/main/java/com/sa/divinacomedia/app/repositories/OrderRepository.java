package com.sa.divinacomedia.app.repositories;

import com.sa.divinacomedia.app.entities.Order;
import com.sa.divinacomedia.app.repositories.crud.OrderCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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


    public List<Order> getSalesManId(Integer id){
        return repository.findBySalesManId(id);
    }

    public List<Order> getBySalesManIdAndStatus(Integer id, String status){
        return repository.findBySalesManIdAndStatus(id, status);
    }

    public List<Order> getByRegisterDayAndSalesManId(String registerDay, Integer id){

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Query query = new Query();

        Criteria dataCriteria = Criteria.where("registerDay")
                .gte(LocalDate.parse(registerDay, dtf).minusDays(1).atStartOfDay())
                .lt(LocalDate.parse(registerDay,dtf).plusDays(1).atStartOfDay())
                .and("salesMan.id").is(id);

        query.addCriteria(dataCriteria);
        List<Order> orders = mongoTemplate.find(query,Order.class);
        return orders;
    }
}
