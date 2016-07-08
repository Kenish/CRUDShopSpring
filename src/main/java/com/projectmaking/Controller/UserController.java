package com.projectmaking.Controller;

import com.projectmaking.Model.User;
import com.projectmaking.Repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class UserController {
    private UserRepository repository;
    @Autowired
    public UserController(UserRepository repository){
       this.repository = repository ;
    }


    @RequestMapping(value = "users", method = RequestMethod.GET)
    public List<User> list(){
      return repository.findAll();
    }

    @RequestMapping(value = "users/{id}", method = RequestMethod.GET)
    public User get(@PathVariable Long id){
       return repository.findOne(id);
    }

    @RequestMapping(value = "users", method = RequestMethod.POST)
    public ResponseEntity add(@RequestBody User user){
       repository.saveAndFlush(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }

/*    @RequestMapping(value = "users", method = RequestMethod.POST)
    public String success(){
        return "SUCCESS";
    }*/


    @RequestMapping(value = "users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Long id){
        repository.delete(id);
        return new ResponseEntity(HttpStatus.GONE);
    }

    @RequestMapping(value = "users/{id}", method = RequestMethod.PUT)
    public void update(@RequestBody User user, @PathVariable Long id){
        User oldUser = repository.findOne(id);
        user.setId(id);
        BeanUtils.copyProperties(user,oldUser);
        repository.saveAndFlush(oldUser);
    }

}
