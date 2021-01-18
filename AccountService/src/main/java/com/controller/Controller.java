package com.controller;

import com.model.Account;
import com.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/accounts")
public class Controller {

    private final ServiceInterface service;

    @Autowired
    public Controller(ServiceInterface service){
        this.service = service;
    }

    @PostMapping(value = "")
    public Account add(@RequestBody Account account) {
        return service.create(account);
    }

    @GetMapping(value = "")
    public List<Account> getAll(@RequestParam(value= "startAt", defaultValue = "0") Integer startAt, @RequestParam(value= "maxResults", defaultValue = "50") Integer maxResults) {
        return service.getAll(startAt, maxResults);
    }

    @PutMapping(value = "")
    public Account update(@RequestBody Account account)  {
        return service.update(account);
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable Integer id){
        return service.delete(id);
    }

    @PostMapping(value = "/attributes")
    public List<Account> find(@RequestBody Account account, @RequestParam(value= "startAt", defaultValue = "0") Integer startAt, @RequestParam(value= "maxResults", defaultValue = "50") Integer maxResults) {
        return service.find(account, startAt, maxResults);
    }

}
