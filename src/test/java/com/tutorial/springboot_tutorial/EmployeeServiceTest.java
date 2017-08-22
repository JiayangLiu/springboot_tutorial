package com.tutorial.springboot_tutorial;

import com.tutorial.springboot_tutorial.domain.Employee;
import com.tutorial.springboot_tutorial.service.EmployeeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by JeremyLiu on 21/08/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest // start the whole spring boot project
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void fineOneTest() {
        Employee employee = employeeService.findOne(1);
        Assert.assertEquals("LIUJiayang", employee.getName());
    }
}
