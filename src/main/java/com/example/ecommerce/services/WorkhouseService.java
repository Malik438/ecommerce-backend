package com.example.ecommerce.services;

import com.example.ecommerce.models.Supplier;
import com.example.ecommerce.models.Workhouse;
import com.example.ecommerce.repositories.WorkhouseRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkhouseService {
    @Autowired
    private final WorkhouseRepository workhouseRepository;

    public WorkhouseService(WorkhouseRepository workhouseRepository) {
        this.workhouseRepository = workhouseRepository;
    }

    /**
     *
     * @return
     */
    public List<Workhouse>getWorkhouses(){
        return workhouseRepository.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    public Workhouse getWorkhouse(Long id){
        return workhouseRepository.findById(id).orElseThrow(null);
    }

    /**
     *
     * @param id
     * @return
     */
    public List<Supplier>getWorkhouseSuppliers(Long id){
        Workhouse workhouse=getWorkhouse(id);
        return workhouse.getSuppliers();
    }

    /**
     *
     * @param id
     * @param workhouse
     * @return
     */
    public Workhouse updateWorkhouse(Long id ,Workhouse workhouse){
        Workhouse existingWorkhouse=getWorkhouse(id);
        existingWorkhouse.setName(workhouse.getName());
        existingWorkhouse.setLocation(workhouse.getLocation());
        return workhouseRepository.save(existingWorkhouse);
    }

    /**
     *
     * @param workhouse
     * @return
     */
    public Workhouse addWorkhouse(Workhouse workhouse){
        return workhouseRepository.save(workhouse);
    }

    /**
     *
     * @param id
     */
    public void deleteWorkhouse(Long id){
        workhouseRepository.deleteById(id);
    }
}
