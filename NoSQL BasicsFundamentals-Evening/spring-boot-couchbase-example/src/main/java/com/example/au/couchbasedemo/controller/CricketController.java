package com.example.au.couchbasedemo.controller;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.au.couchbasedemo.model.Cricket;
import com.example.au.couchbasedemo.repository.CricketRepository;

@RestController
public class CricketController {
    
    @Autowired
    CricketRepository CricketRepository;
    List<Cricket>li;
    
    @PostMapping("/Cricket")
    public Cricket addPlayerPost(@RequestBody Cricket newCricket) {
        return CricketRepository.save(newCricket);
    }
    
    @GetMapping("/Cricket/{playerId}")
    public Optional<Cricket> getCricket(@PathVariable String playerId) {
        if (CricketRepository.existsById(playerId)) {
            return CricketRepository.findById(playerId);
        } else
            return Optional.empty();
    }
    
    @GetMapping("/Cricket/players{run}")
    public List<Cricket> getPlayersWhoseRunGreaterThan(@PathVariable Integer run) {
    	List<Cricket> cricket = new ArrayList<>();
	    CricketRepository.findAll().forEach(Cricket->{
	    	if(Cricket.getNoOfRun()>=run)
        	{
        		cricket.add(Cricket);
        	}
	    });
	    return cricket;
    }
    
  
    @DeleteMapping("/Cricket/{playerId}")
    public void deleteById(@PathVariable String playerId) {
        CricketRepository.deleteById(playerId);
    }
    
}