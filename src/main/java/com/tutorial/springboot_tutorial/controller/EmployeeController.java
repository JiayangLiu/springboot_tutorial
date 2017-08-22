package com.tutorial.springboot_tutorial.controller;

import com.tutorial.springboot_tutorial.domain.Employee;
import com.tutorial.springboot_tutorial.domain.Result;
import com.tutorial.springboot_tutorial.repository.EmployeeRepository;
import com.tutorial.springboot_tutorial.service.EmployeeService;
import com.tutorial.springboot_tutorial.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by JeremyLiu on 21/08/2017.
 */
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/employees")
    public List<Employee> employeeList() {
        return employeeRepository.findAll();
    }
    @GetMapping(value = "/employees/busno/{busno}")
    public List<Employee> employeeListByBusNO(@PathVariable("busno") String busNO) {
        return employeeRepository.findByBusNO(busNO);
    }

//    @PostMapping(value = "/employees")
//    public Employee employeeAdd(@RequestParam("name") String name,
//                              @RequestParam("busNO") String busNO) {
//        Employee employee = new Employee();
//        employee.setName(name);
//        employee.setBusNO(busNO);
//
//        return employeeRepository.save(employee);
//    }
    @PostMapping(value = "/employees")
    public Result<Employee> employeeAdd(@Valid Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
//            Result result = new Result();
//            result.setCode(1);
//            result.setMsg(bindingResult.getFieldError().getDefaultMessage());
//            result.setData(null);
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        employee.setPwid(employee.getPwid());
        employee.setName(employee.getName());
        employee.setBusNO(employee.getBusNO());

//        Result result = new Result();
//        result.setCode(0);
//        result.setMsg("success");
//        result.setData(employeeRepository.save(employee));
        return ResultUtil.success(employeeRepository.save(employee));
    }
    @PostMapping(value = "/employees/two")
    public void employeeTwo() {
        employeeService.insertTwo();
    }


    @GetMapping(value = "/employees/{id}")
    public Employee employeeFindOne(@PathVariable("id") Integer id) {
        return employeeRepository.findOne(id);
    }

    @PutMapping(value = "/employees/{id}")
    public Employee employeeUpdate(@PathVariable("id") Integer id,
                                   @PathVariable("pwid") Integer pwid,
                                   @RequestParam("name") String name,
                                   @RequestParam("busNO") String busNO) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setPwid(pwid);
        employee.setName(name);
        employee.setBusNO(busNO);

        return employeeRepository.save(employee);
    }

    @DeleteMapping(value = "/employees/{id}")
    public void employeeDelete(@PathVariable("id") Integer id) {
        employeeRepository.delete(id);
    }

    @GetMapping(value = "/employees/getbusno/{id}")
    public void getBusNO(@PathVariable("id") Integer id) throws Exception {
        employeeService.getBusNO(id);
    }

}
