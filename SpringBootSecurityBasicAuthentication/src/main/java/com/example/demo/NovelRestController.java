package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NovelRestController {
	
    List<Novel> novels = new ArrayList<>();
        
    public NovelRestController() {
    	novels.add(new Novel("The Fountainhead", "Ayn Rand"));
    	novels.add(new Novel("Murder on the Orient Express", "Agatha Christie"));
    }

    @GetMapping("/novels") 
    public List<Novel> getNovels() {
        return novels;
    }
}
   