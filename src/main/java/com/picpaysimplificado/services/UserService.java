package com.picpaysimplificado.services;

import com.picpaysimplificado.dto.UserDto;
import com.picpaysimplificado.model.user.User;
import com.picpaysimplificado.model.user.UserType;
import com.picpaysimplificado.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public void ValidUserTransaction(User sender, BigDecimal amount) throws Exception{
        if (sender.getUserType().equals(UserType.SELLER)){
            throw new Exception("Shops are not authorized to send values!");
        }
    }

    public void ValidBalanceToDoTransaction(User sender, BigDecimal amount) throws Exception{
        if (sender.getBalance().compareTo(amount) > 0){
            throw new Exception("insufficient funds.");
        }
    }

    public User findUserById(Long id) throws Exception {
        return this.repository.findUserById(id).orElseThrow(()->
                new Exception("User not found!"));
    }

    public void saveUser(User user){
        this.repository.save(user);
    }

    public User createUser(UserDto userDto){
        User newUser = new User(userDto);
        this.saveUser(newUser);
        return newUser;
    }

    public List getUsers(){
        return this.repository.findAll();
    }
}
