package com.sa.divinacomedia.app.controller;

import com.sa.divinacomedia.app.entities.HairProduct;
import com.sa.divinacomedia.app.services.HairProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

/**
 * @author Tatiana
 */

@RestController
@RequestMapping("hairproducts")
@CrossOrigin(origins = "*") //habilita acceso desde cualquier origen
public class HairProductController {

    @Autowired
    private HairProductService service;

    @GetMapping("/all")
    public List<HairProduct> getHairProducts(){return service.getAll();}

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public HairProduct save(@RequestBody HairProduct product){return service.save(product);}

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public HairProduct update(@RequestBody HairProduct product){return service.update(product);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable("id") String id){
        service.delete(id);
    }

    @GetMapping("/{id}")
    public Optional<HairProduct> getProductById(@PathVariable("id") String id){
        return service.findById(id);
    }

    @GetMapping("/price/{price}")
    public List<HairProduct> getByPrice(@PathVariable("price") Double price){
        return service.findByPrice(price);
    }

    @GetMapping("/description/{description}")
    public List<HairProduct> getByDescriptionContains(@PathVariable("description") String description){
        return service.getByDescriptionContains(description);
    }

}
