package repository;

import model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findEmployeeById(long id);

    List<Employee> findAllByOrderById();

    List<Employee> findAllByOrderByAgeAsc();

    List<Employee> findAllByOrderByAgeDesc();

    List<Employee> findAllByOrderByEarningsAsc();

    List<Employee> findAllByOrderByEarningsDesc();
}
