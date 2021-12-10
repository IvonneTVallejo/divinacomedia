package com.sa.divinacomedia.app.repositories.crud;


import com.sa.divinacomedia.app.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

/**
 * @author Tatiana
 */
public interface UserCrudRepository extends MongoRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String password);

    //Seleccionar el usuario con el ultimo id
    Optional<User> findTopByOrderByIdDesc();


}
