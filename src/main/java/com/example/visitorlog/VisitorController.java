package com.example.visitorlog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class VisitorController {
    private List<Visitor> visitors = new ArrayList<>();
    private Long count = 1L;

    //Return all visitors
    @GetMapping("/visitors")
    public List<Visitor> getAllVisitors(){
        return visitors;
    }


}
