package com.example.visitorlog;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class VisitorController {
    private List<Visitor> visitors = new ArrayList<>();
    private Long counter = 1L;

    //Return all visitors
    @GetMapping("/visitors")
    public ResponseEntity<List<Visitor>> getAllVisitors(){
        return ResponseEntity.ok(visitors);
    }

    //Add a visitor (JSON body)
    @PostMapping("/visitors")
    public ResponseEntity<Visitor> addVisitor(@RequestBody Visitor visitor){
        visitor.setId(counter);
        counter++;
        visitors.add(visitor);

        return ResponseEntity.status(201).body(visitor);
    }

    //Return one visitor
    @GetMapping("/visitors/{id}")
    public Visitor getVisitor(@PathVariable Long id) {
        return visitors.stream()
                .filter(visitor -> visitor.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    //Remove a visitor
    @DeleteMapping("/visitors/{id}")
    public void deleteVisitor(@PathVariable Long id) {
        boolean remove = visitors.removeIf(
                visitor -> visitor.getId().equals(id)
        );

        if (!remove) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
