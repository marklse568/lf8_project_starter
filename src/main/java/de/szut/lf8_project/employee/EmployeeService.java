package de.szut.lf8_project.employee;

import de.szut.lf8_project.exceptionHandling.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<EmployeeEntity> readAll() {
        return this.repository.findAll();
    }

    public EmployeeEntity readById(long id) {
        return this.repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee with id " + id + " not found"));
    }
}
