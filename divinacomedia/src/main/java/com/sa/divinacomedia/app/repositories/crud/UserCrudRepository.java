package com.sa.divinacomedia.app.repositories.crud;


import com.sa.divinacomedia.app.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;

public interface UserCrudRepository extends MongoRepository<User, Integer> {

    public Optional<User> findByName(String name);

    public List<User> findByNameOrEmail(String name, String email);

    public Optional<User> findByEmail(String email);

    public Optional<User> findByEmailAndPassword(String email, String password);
}
