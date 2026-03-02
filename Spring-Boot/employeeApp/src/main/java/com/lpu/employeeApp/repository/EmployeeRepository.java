package com.lpu.employeeApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lpu.employeeApp.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query("select e from Employee e where e.name = :name")
	List<Employee> getEmployeeByName(String name);
	@Query("select e from Employee e where e.department = :department")
	List<Employee> getEmployeeByDepartment(String department);
	@Query("select e from Employee e where e.phone = :phone")
	List<Employee> getEmployeeByPhone(String phone);
	@Query("select e from Employee e where e.email = :email")
	List<Employee> getEmployeeByEmail(String email);
    @Query(nativeQuery = true, value = "SELECT * FROM employee WHERE salary = (SELECT MAX(salary) FROM employee)")
    List<Employee> getEmployeeWithMaxSalary();
    @Query(nativeQuery = true, value = "SELECT * FROM employee WHERE salary = (SELECT MIN(salary) FROM employee)")
    List<Employee> getEmployeeWithMinSalary();
    @Query(nativeQuery = true,value = "SELECT * FROM employee WHERE salary > :salary")
    List<Employee> getEmployeesWithSalaryAbove(double salary);
    @Query(nativeQuery = true, value = "SELECT * FROM employee WHERE salary BETWEEN :min AND :max")
    List<Employee> getEmployeesWithinRange(double min,double max);
}
