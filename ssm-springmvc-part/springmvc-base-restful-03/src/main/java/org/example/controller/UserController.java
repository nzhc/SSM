package org.example.controller;


import org.example.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("user")
public class UserController {
    @GetMapping
    public List<User> getAll(@RequestParam(required = false, defaultValue = "1") Integer page,
                             @RequestParam(required = false, defaultValue = "10") Integer size) {
        return new ArrayList<>();
    }
    @PostMapping
    public void add(@RequestBody User user) {
    }
    @GetMapping("{id}")
    public User searchById(@PathVariable Integer id) {
        return new User();
    }
    @PutMapping
    public void update(@RequestBody User user) {
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
    }
    @GetMapping("search")
    public List<User> search(@RequestParam(required = false, defaultValue = "1") Integer page,
                             @RequestParam(required = false, defaultValue = "10") Integer size,
                             String keyword) {
        return new ArrayList<>();
    }
}