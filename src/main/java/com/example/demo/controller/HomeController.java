// package com.example.demo.controller;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// public class HomeController {

//     @GetMapping("/")
//     public String home() {
//         return "Welcome to Inventory Management System";
//     }
// }
package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @GetMapping("/")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void root() {
        // intentionally empty
    }
}
