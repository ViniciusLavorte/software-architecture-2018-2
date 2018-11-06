/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example8.exam8;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author vinicius
 */
//hhtp GET :8080/user
//http post :8080/user name="Barreto" idade=30
//http put :8080/user name="Barreto" idade=30
//http delete :8080/user
@RestController
public class UserDAO {
    
    @PostMapping("/user")
    public Funcionario create(@RequestBody Funcionario user){
        user.setId(UUID.randomUUID());
        return user;
    }

    @GetMapping("/user")
    public List <Funcionario> read(){
        return Stream.of(
                new Funcionario("Vinicius", 22),
                new Funcionario("Ricardo",27)
        
        ).collect(Collectors.toList());
    }
    
    @PutMapping("/user")
    public Funcionario update(@RequestBody Funcionario user){
        user.setName(user.getName()+"--- Update");
        return user;
    }
    
    @DeleteMapping("/user/{id}")
    public String delete(int id){
        return "Deleted ";
    }
}
