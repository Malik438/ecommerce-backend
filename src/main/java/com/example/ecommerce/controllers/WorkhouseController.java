package com.example.ecommerce.controllers;

import com.example.ecommerce.models.Supplier;
import com.example.ecommerce.models.Workhouse;
import com.example.ecommerce.services.WorkhouseService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workhouses")
public class WorkhouseController {
    private final WorkhouseService workhouseService;

    public WorkhouseController(WorkhouseService workhouseService) {
        this.workhouseService = workhouseService;
    }
    @GetMapping
    public List<Workhouse>getWorkhouses(){
        return workhouseService.getWorkhouses();
    }
    @GetMapping("/{id}")
    public Workhouse getWorkhouse(@PathVariable Long id){
        return workhouseService.getWorkhouse(id);
    }
    @GetMapping("/supplier/{id}")
    public List<Supplier>getWorkhouseSuppliers(@PathVariable Long id){
        return workhouseService.getWorkhouseSuppliers(id);
    }
    @PutMapping("/{id}")
    public Workhouse updateWorkhouse(@PathVariable Long id,@RequestBody Workhouse workhouse){
        return workhouseService.updateWorkhouse(id, workhouse);
    }
    @PostMapping("")
    public Workhouse addWorkhouse (@RequestBody Workhouse workhouse){
        return workhouseService.addWorkhouse(workhouse);
    }
    @DeleteMapping("/{id}")
    public void deleteWorkhouse(@PathVariable Long id){
        workhouseService.deleteWorkhouse(id);
    }
}
