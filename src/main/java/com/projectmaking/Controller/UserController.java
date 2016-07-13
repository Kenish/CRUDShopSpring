package com.projectmaking.Controller;

import com.projectmaking.Model.User;
import com.projectmaking.Repository.UserRepository;
import com.projectmaking.Service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserRepository repository;
    private UserService userService;

    @Autowired
    public UserController(UserRepository repository, UserService userService){
        this.repository = repository;
        this.userService = userService;
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<User> list(){
      return repository.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public User get(@PathVariable Long id){
       return repository.findOne(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> add(@RequestBody User user){
       repository.saveAndFlush(user);
        return new ResponseEntity<>(user.toString(),HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Long id){
        repository.delete(id);
        return new ResponseEntity(HttpStatus.GONE);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public void update(@RequestBody User user, @PathVariable Long id) {
        user.setId(id);
        userService.update(user);
    }

}
