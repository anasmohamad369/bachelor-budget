package com.example.demo.Controller;

import com.example.demo.Entity.ExpensiveEntity;
import com.example.demo.Service.ExpensiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/expensives")
public class ExpensiveController {
    @Autowired
    private ExpensiveService expensiveService;
    @GetMapping("/get")
    public List<ExpensiveEntity> getAll() {
        return expensiveService.getall();
    }
    @PostMapping("/save")
    public ResponseEntity<ExpensiveEntity> save(@RequestBody ExpensiveEntity expensiveEntity) {
        ExpensiveEntity saved = expensiveService.save(expensiveEntity);
        if (saved != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); 
        }
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<ExpensiveEntity> getById(@PathVariable int id) {
        ExpensiveEntity entity = expensiveService.getById(id);
        if (entity != null) {
            return ResponseEntity.ok(entity); 
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ExpensiveEntity> update(@PathVariable int id, @RequestBody ExpensiveEntity expensiveEntity) {
        ExpensiveEntity updated = expensiveService.update(id, expensiveEntity);
        if (updated != null) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(updated);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        boolean deleted = expensiveService.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
