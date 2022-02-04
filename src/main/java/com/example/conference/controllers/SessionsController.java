package com.example.conference.controllers;


import com.example.conference.models.Session;
import com.example.conference.repositories.SessionRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {

    @Autowired
    private SessionRepo sessionRepo;

    @GetMapping
    public List<Session> list(){
        return sessionRepo.findAll();
    }

    @GetMapping("{id}")
    public Session get(@PathVariable Long id){
        return sessionRepo.findById(id).orElse(null);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Session post(@RequestBody final Session session){
        return sessionRepo.saveAndFlush(session);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        // todo : delete the children from the database coz it can be referenced by foreign key
        // happening automatically don't know why??
        sessionRepo.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable Long id, @RequestBody Session session){

        // todo : check for speakers while calculating checkFlag

        boolean checkFlag =
                session.getSessionName().isEmpty() &&
                        session.getSessionDescription().isEmpty() &&
                        session.getSessionLength() == null;


        if(checkFlag) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

        Session retrievedSession = sessionRepo.findById(id).orElse(null);
        if(retrievedSession == null)  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

        // we got the retrieved session now update it

        BeanUtils.copyProperties(session, retrievedSession,"sessionId");
        Session updatedSession = sessionRepo.saveAndFlush(retrievedSession);

        return ResponseEntity.ok(updatedSession);
    }


}
