package com.sml.user.controller;

import com.sml.user.model.Employee;
import com.sml.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }


    @PostMapping(value= "/create")
    public String create(@RequestBody Employee emp) {
        logger.debug("Saving employees.");
        userService.createEmployee(emp);
        return "Employee records created.";
    }

    @GetMapping(value= "/getall")
    public Collection<Employee> getAll() {
        logger.debug("Getting all employees.");
        return userService.getAllEmployees();
    }

    @GetMapping(value= "/getbyid/{employee-id}")
    public Optional<Employee> getById(@PathVariable(value= "employee-id") int id) {
        logger.debug("Getting employee with employee-id= {}.", id);
        return userService.findEmployeeById(id);
    }

    @PutMapping(value= "/update/{employee-id}")
    public String update(@PathVariable(value= "employee-id") int id, @RequestBody Employee e) {
        logger.debug("Updating employee with employee-id= {}.", id);
        e.setId(id);
        userService.updateEmployee(e);
        return "Employee record for employee-id= " + id + " updated.";
    }

    @DeleteMapping(value= "/delete/{employee-id}")
    public String delete(@PathVariable(value= "employee-id") int id) {
        logger.debug("Deleting employee with employee-id= {}.", id);
        userService.deleteEmployeeById(id);
        return "Employee record for employee-id= " + id + " deleted.";
    }

    @DeleteMapping(value= "/deleteall")
    public String deleteAll() {
        logger.debug("Deleting all employees.");
        userService.deleteAllEmployees();
        return "All employee records deleted.";
    }
}
