package com.example.visitorlog;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
