package com.sa.divinacomedia.app.repositories;

import com.jayway.jsonpath.Criteria;
import com.sa.divinacomedia.app.entities.HairProduct;
import com.sa.divinacomedia.app.entities.Order;
import com.sa.divinacomedia.app.repositories.crud.HairProductCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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

    public List<HairProduct> getProductPrice(Double price){
        return repository.findByPrice(price);
    }

    public List<HairProduct> getByDescriptionContains(String description){
        return repository.findByDescriptionContains(description.toUpperCase());
    }

}
