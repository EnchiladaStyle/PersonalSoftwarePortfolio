package com.example.FruitStoreBackend.controller;

import com.example.FruitStoreBackend.model.User;
import com.example.FruitStoreBackend.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("http://127.0.0.1:5500")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

    @PutMapping("/user/shoppingCart")
    User updateShoppingCart(@RequestBody User userUpdateRequest){
        String name = userUpdateRequest.getUsername();
        String newShoppingCart = userUpdateRequest.getShoppingCart();
        User target = userRepository.findByUsername(name).orElseThrow(() -> new RuntimeException("not found"));
        target.setShoppingCart(newShoppingCart);
        return userRepository.save(target);

    }

    @PutMapping("/user/details")
    public User getShoppingCartByName(@RequestBody Map<String, String> requestBody) {
        // Extract the name from the request body
        String name = requestBody.get("username");

        // Find the user by name
        User user = userRepository.findByUsername(name)
                .orElseThrow(() -> new RuntimeException("User not found " + name));

        // Return the user's shopping cart and name
        return user;
    }



}
