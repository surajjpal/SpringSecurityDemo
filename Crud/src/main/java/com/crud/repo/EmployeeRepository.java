package com.crud.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crud.dto.EmployeeEntity;

@Repository
public interface EmployeeRepository 
        extends CrudRepository<EmployeeEntity, Long> {
 
}
