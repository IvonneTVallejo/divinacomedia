package com.sa.divinacomedia.app.services;

import com.sa.divinacomedia.app.entities.Order;
import com.sa.divinacomedia.app.entities.User;
import com.sa.divinacomedia.app.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Tatiana
 */

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> getAll(){
        return repository.getAll();
    }

    public Order save(Order order) {
        if (order.getId() == null) {
            return repository.save(order);
        } else {
            Optional<Order> existOrder = repository.getOrder(order.getId());
            if (existOrder.isPresent()) {
                return order;
            } else {
                return repository.save(order);
            }
        }
    }

    public Order update(Order order){
        if (order.getId()!= null) {
            Optional<Order> existOrder = repository.getOrder(order.getId());
            if (existOrder.isPresent()) {
                if (order.getProducts()!= null) {
                    existOrder.get().setProducts(order.getProducts());
                }
                if (order.getRegisterDay()!= null) {
                    existOrder.get().setRegisterDay(order.getRegisterDay());
                }
                if (order.getStatus()!= null) {
                    existOrder.get().setStatus(order.getStatus());
                }
                if (order.getSalesMan()!= null) {
                    existOrder.get().setSalesMan(order.getSalesMan());
                }
                if (order.getQuantities()!= null) {
                    existOrder.get().setQuantities(order.getQuantities());
                }

                return repository.save(existOrder.get());
            } else {
                return order;
            }
        } else {
            return order;
        }
    }

    public void delete(Integer id){
        repository.delete(id);
    }

    public List<Order> findByZone(String zona){
        return repository.findByZone(zona);
    }

    public Order getOrderById (Integer id) {
        return repository.getOrder(id).orElse(new Order());
    }

    public List<Order> getBySalesManId(Integer id){
        return repository.getSalesManId(id);
    }

    public List<Order> getBySalesManIdAndStatus(Integer id, String status){
        return repository.getBySalesManIdAndStatus(id,status);
    }

    public List<Order> getByRegisterDayAndSalesManId(String registerDay,Integer id){
        return repository.getByRegisterDayAndSalesManId(registerDay, id);
    }


}
