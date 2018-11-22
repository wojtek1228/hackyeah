package com.hackyeah.mainapp.controller;

import com.hackyeah.mainapp.dao.EntityService;
import com.hackyeah.mainapp.entities.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;

@Controller
@RequestMapping("/")
public class RestEndpoint {

    @Autowired
    private EntityService entityService;

    @PostMapping(value = "/entity", produces = "application/json")
    public ResponseEntity createEntity(@RequestBody Entity entity){

        System.out.print("JESTEM");
        entityService.save(entity);
        return ResponseEntity.accepted().build();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/entity/{id}", produces = "application/json")
    public ResponseEntity getEntity(@PathVariable("id") String id){

        System.out.print("JESTEM2");
        Entity entity = entityService.findById(id).get();

        return ResponseEntity.ok(entity);
    }
}
