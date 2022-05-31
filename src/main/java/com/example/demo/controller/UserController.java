package com.example.demo.controller;


import com.example.demo.util.dao.common.GenericSpecificationsBuilder;
import com.example.demo.dao.UserRepository;
import com.example.demo.util.dao.UserSpecification;
import com.example.demo.dao.model.User;
import com.example.demo.web.CriteriaParser;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@Component
@RequestMapping("/api/users")

@Slf4j
@CrossOrigin
@NoArgsConstructor
@AllArgsConstructor

public class UserController {

    @Autowired
    private UserRepository userRepository;
    @GetMapping(value = "/search")

    public ResponseEntity<List<User>> search(@RequestParam(value = "search") String search) {
        Specification<User> spec = resolveSpecification(search);
        return ResponseEntity.ok(userRepository.findAll(spec));
    }
    @GetMapping("/spec")
    @ResponseBody
    public List<User> findAllByAdvPredicate(@RequestParam String search) {
        Specification<User> spec = resolveSpecification(search);
        return userRepository.findAll(spec);
    }
    private Specification<User> resolveSpecification(String searchParameters) {
        CriteriaParser parser = new CriteriaParser();
        GenericSpecificationsBuilder<User> specBuilder = new GenericSpecificationsBuilder<>();
        return specBuilder.build(parser.parse(searchParameters), UserSpecification::new);
    }

}