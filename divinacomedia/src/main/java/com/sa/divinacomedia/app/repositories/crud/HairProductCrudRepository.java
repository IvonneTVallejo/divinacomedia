package com.sa.divinacomedia.app.repositories.crud;


import com.sa.divinacomedia.app.entities.HairProduct;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;

/**
 * @author Tatiana
 */
public interface HairProductCrudRepository extends MongoRepository<HairProduct,String> {

    Optional<HairProduct> findById(String id);

    List<HairProduct> findByPrice(Double price);

    List<HairProduct> findByDescriptionContains(String description);
}
