package com.example.demo.controller;


import com.example.demo.dao.ProjectRepository;
import com.example.demo.dao.model.Project;
import com.example.demo.dao.model.User;
import com.example.demo.util.dao.ProjectSpecification;
import com.example.demo.util.dao.common.GenericSpecificationsBuilder;
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
@RequestMapping("/api/projects")

@Slf4j
@CrossOrigin
@NoArgsConstructor
@AllArgsConstructor

public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping(value = "/")
    public ResponseEntity<List<Project>> getAll() {
        return ResponseEntity.ok(projectRepository.findAll());
    }
    @GetMapping(value = "/search")
    public ResponseEntity<List<Project>> search(@RequestParam(value = "search") String search) {
        Specification<Project> spec = resolveSpecification(search);
        return ResponseEntity.ok(projectRepository.findAll(spec));
    }
    @GetMapping("/spec")
    @ResponseBody
    public List<Project> findAllByAdvPredicate(@RequestParam String search) {
        Specification<Project> spec = resolveSpecification(search);
        return projectRepository.findAll(spec);
    }
    private Specification<Project> resolveSpecification(String searchParameters) {
        CriteriaParser parser = new CriteriaParser();
        GenericSpecificationsBuilder<Project> specBuilder = new GenericSpecificationsBuilder<>();
        return specBuilder.build(parser.parse(searchParameters), ProjectSpecification::new);
    }

}