package com.sa.divinacomedia.app.services;

import com.sa.divinacomedia.app.entities.User;
import com.sa.divinacomedia.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> getAll(){
        return repository.getAll();
    }

    public User save(User user) {
        if (user.getId() == null) {
            return repository.save(user);
        } else {
            Optional<User> existUser = repository.getUserById(user.getId());
            if (existUser.isPresent()) {
                return user;
            } else {
                return repository.save(user);
            }
        }
    }

    public boolean getUserByEmail(String email){
        return repository.getUserByEmail(email).isPresent();
    }

    public User getUserById (Integer id) {
        return repository.getUserById(id).orElse(new User());
    }

    public User getUserByEmailAndPassword(String email, String password){
        Optional<User> user = repository.getUserByEmailAndPassword(email,password);
        if(user.isPresent()){
            return user.get();
        }else{
            return new User();
        }
    }

    public User update(User user){
        if (user.getId()!= null) {
            Optional<User> existUser = repository.getUserById(user.getId());
            if (existUser.isPresent()) {
                if (user.getEmail()!= null) {
                    existUser.get().setEmail(user.getEmail());
                }
                if (user.getAddress()!= null) {
                    existUser.get().setAddress(user.getAddress());
                }
                if (user.getName()!= null) {
                    existUser.get().setName(user.getName());
                }
                if (user.getIdentification()!= null) {
                    existUser.get().setIdentification(user.getIdentification());
                }
                if (user.getCellPhone()!= null) {
                    existUser.get().setCellPhone(user.getCellPhone());
                }
                if (user.getPassword()!= null) {
                    existUser.get().setPassword(user.getPassword());
                }
                if (user.getZone()!= null) {
                    existUser.get().setZone(user.getZone());
                }
                if (user.getType()!= null) {
                    existUser.get().setType(user.getType());
                }
                return repository.save(existUser.get());
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public void delete(Integer id){
        repository.delete(id);
    }


    public List<User> getUserMonthBirthday(String month) {
           return repository.getUserMonthBirthday(month);
    }
}
