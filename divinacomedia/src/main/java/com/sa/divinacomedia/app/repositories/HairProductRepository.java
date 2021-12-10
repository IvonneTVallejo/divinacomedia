package com.sa.divinacomedia.app.repositories;

import com.sa.divinacomedia.app.entities.HairProduct;
import com.sa.divinacomedia.app.entities.Order;
import com.sa.divinacomedia.app.repositories.crud.HairProductCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * @author Tatiana
 */
@Repository
public class HairProductRepository {

    @Autowired
    private HairProductCrudRepository repository;

    public List<HairProduct> getAll(){
        return (List<HairProduct>) repository.findAll();
    }

    public HairProduct save(HairProduct product){
        return repository.save(product);
    }

    public void delete(String id){repository.deleteById(id);}

    public Optional<HairProduct> getById(String id){
        return repository.findById(id);
    }




}
