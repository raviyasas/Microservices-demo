package com.sml.user.service;

import com.sml.user.model.Employee;
import com.sml.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public void createEmployee(Employee emp) {
        userRepository.save(emp);
    }

    public List<Employee> getAllEmployees() {
        return userRepository.findAll();
    }

    public Optional<Employee> findEmployeeById(int id) {
        return userRepository.findById(id);
    }

    public void deleteEmployeeById(int id) {
        userRepository.deleteById(id);
    }

    public void updateEmployee(Employee emp) {
        userRepository.save(emp);
    }

    public void deleteAllEmployees() {
        userRepository.deleteAll();
    }
}
