package com.example.demo.Service;

import com.example.demo.Entity.ExpensiveEntity;
import com.example.demo.Repolayer.ExpensiveRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpensiveService {
    @Autowired
    private ExpensiveRepostory expensiveRepostory;
    //Getting all entities
    public List <ExpensiveEntity> getall() {

        return expensiveRepostory.findAll();
    }
    //Adding a new entity
    public ExpensiveEntity addEntity(ExpensiveEntity expensiveEntity) {
        return expensiveRepostory.save(expensiveEntity);
    }
    //Getting an entity by ID
    public ExpensiveEntity getById(int id) {
        return expensiveRepostory.findById(id).orElse(null);
    }
    //Updating an entity
    public ExpensiveEntity update(int id, ExpensiveEntity expensiveEntity) {
        return expensiveRepostory.save(expensiveEntity);
    }
    //Deleting an entity
    public void deleteEntity(int id) {
        expensiveRepostory.deleteById(id);
    }
    public ExpensiveEntity save(ExpensiveEntity expensiveEntity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
