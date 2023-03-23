package lk.code.employeems.repo;

import lk.code.employeems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

}
