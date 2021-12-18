package com.sa.divinacomedia.app.repositories;


import com.sa.divinacomedia.app.entities.User;
import com.sa.divinacomedia.app.repositories.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository repository;

    public List<User> getAll(){
        return repository.findAll();
    }

    public Optional<User> getUserByEmail(String email){
        return  repository.findByEmail(email);
    }

    public Optional<User> getUserByEmailAndPassword(String email, String password){
        return  repository.findByEmailAndPassword(email, password);
    }

    public Optional<User> getUserById(Integer id){
        return repository.findById(id);
    }

    public User save(User user){
        return repository.save(user);
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }

    public List<User> getUserMonthBirthday(String month){
        return repository.findByMonthBirthtDay(month);
    }


}
