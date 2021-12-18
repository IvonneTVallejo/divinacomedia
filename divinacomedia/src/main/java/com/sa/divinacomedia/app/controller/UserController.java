package com.sa.divinacomedia.app.controller;

import com.sa.divinacomedia.app.entities.User;
import com.sa.divinacomedia.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author Tatiana
 */
@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*") //habilita acceso desde cualquier origen
public class UserController {


    @Autowired
    private UserService service;

    @GetMapping("/all")
    public List<User> getUsers() {
        return service.getAll();
    }

    @GetMapping("/emailexist/{email}")
    public boolean existEmail(@PathVariable("email") String email){
        return service.getUserByEmail(email);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user){return service.save(user);}

    @GetMapping("/{email}/{password}")
    public User authUser(@PathVariable("email") String email, @PathVariable("password") String password){
        return service.getUserByEmailAndPassword(email, password);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user){return service.update(user);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable("id") Integer id){
        service.delete(id);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return service.getUserById(id);
    }

    @GetMapping("/birthday/{birthday}")
    public List<User> userByBirthday(@PathVariable("birthday") String month) {
        return service.getUserMonthBirthday(month);

    }
}
