package com.sa.divinacomedia.app.repositories.crud;


import com.sa.divinacomedia.app.entities.HairProduct;
import com.sa.divinacomedia.app.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * @author Tatiana
 */
public interface HairProductCrudRepository extends MongoRepository<HairProduct,String> {

    public Optional<HairProduct> findById(String id);

}
