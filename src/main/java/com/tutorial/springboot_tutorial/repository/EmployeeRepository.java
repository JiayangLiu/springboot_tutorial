package com.tutorial.springboot_tutorial.repository;

import com.tutorial.springboot_tutorial.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by JeremyLiu on 21/08/2017.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // extend interface: find by busNO
    public List<Employee> findByBusNO(String busNO);
}
