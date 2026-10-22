package sk_ukf.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sk_ukf.demo.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByFirstNameAndLastName(String firstName, String lastName);
    List<Student> findAllByOrderByLastNameAsc();
    boolean existsByEmail(String email);
    Optional<Student> findByEmail(String email);
}