package sk_ukf.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk_ukf.demo.dao.EmployeeRepository;
import sk_ukf.demo.entity.Employee;
import sk_ukf.demo.exception.ObjectNotFoundException;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Zamestnanec", id));
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Transactional
    @Override
    public void deleteById(Integer id) {
        if (!employeeRepository.existsById(id)) {
            throw new ObjectNotFoundException("Zamestnanec", id);
        }
        employeeRepository.deleteById(id);
    }
}