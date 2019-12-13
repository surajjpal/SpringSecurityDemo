package com.crud.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.dto.EmployeeEntity;
import com.crud.services.EmployeeService;

@RestController
@RequestMapping("/employees")
public class CrudController {
	
	org.slf4j.Logger logger = LoggerFactory.getLogger(CrudController.class);
	
	@Autowired
    EmployeeService service;
	
	
	@GetMapping
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
        List<EmployeeEntity> list = service.getAllEmployees();
        logger.info("CrudController.getAllEmployees()");
        return new ResponseEntity<List<EmployeeEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable("id") Long id) {
        EmployeeEntity entity = service.getEmployeeById(id);
        return new ResponseEntity<EmployeeEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<EmployeeEntity> createOrUpdateEmployee(EmployeeEntity employee) {
		System.out.println("testing"+employee.toString());
		EmployeeEntity updated = service.createOrUpdateEmployee(employee);
        return new ResponseEntity<EmployeeEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }
	
	@DeleteMapping("/{id}")
    public HttpStatus deleteEmployeeById(@PathVariable("id") Long id){
        service.deleteEmployeeById(id);
        return HttpStatus.FORBIDDEN;
    }

}
