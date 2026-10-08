package sk_ukf.demo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sk_ukf.demo.entity.Employee;

import java.util.List;

@Repository
public class EmployeeDAOJpalmpl implements EmployeeDAO {
    private final EntityManager em;
    @Autowired
    public EmployeeDAOJpalmpl(EntityManager em) {
        this.em = em;
    }

    public List<Employee> findAll() {
        TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e", Employee.class);
        List<Employee> employees =  query.getResultList();
        return employees;
    }
}
