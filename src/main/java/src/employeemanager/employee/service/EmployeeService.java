package src.employeemanager.employee.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import src.employeemanager.employee.model.Employee;
import src.employeemanager.employee.repository.EmployeeRepository;
import src.employeemanager.exception.UserNotFoundException;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        employee.setSecretCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with id=%d not found.", id)));
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteEmployeeById(id);
    }
}
