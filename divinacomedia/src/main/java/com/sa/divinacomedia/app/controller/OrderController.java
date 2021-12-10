package com.sa.divinacomedia.app.controller;

import com.sa.divinacomedia.app.entities.Order;
import com.sa.divinacomedia.app.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author Tatiana
 */

@RestController
@RequestMapping("order")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping("/all")
    public List<Order> getOrder(){return service.getAll();}

   /** @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable("id") int id){
        return service.getOrder(id);
    }**/

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody Order order){return service.save(order);}

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order order){return service.update(order);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable("id") Integer id){
        service.delete(id);
    }

    @GetMapping("/zona/{zona}")
    public List<Order> findByZone(@PathVariable("zona") String zona){
        return service.findByZone(zona);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable("id") Integer id){
        return service.getOrderById(id);
    }

}
