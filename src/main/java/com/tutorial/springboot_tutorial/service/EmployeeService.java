package com.tutorial.springboot_tutorial.service;

import com.tutorial.springboot_tutorial.domain.Employee;
import com.tutorial.springboot_tutorial.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by JeremyLiu on 21/08/2017.
 */
@Service
public class EmployeeService {

    private final static Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public void insertTwo() {
        Employee employeeA = new Employee();
        employeeA.setPwid(8972384);
        employeeA.setName("HANFuqiang");
        employeeA.setBusNO("GBS1");
        employeeRepository.save(employeeA);

        Employee employeeB = new Employee();
        employeeB.setPwid(9237438);
        employeeB.setName("JIANGChang");
        employeeB.setBusNO("GBS1");
        employeeRepository.save(employeeB);
    }

    public void getBusNO(Integer id) throws Exception {
        Employee employee = employeeRepository.findOne(id);
        String busNO = employee.getBusNO();
        if (busNO.equals("GBS1")) {
            // logger.info("The shuttle bus: HeDong -> Company");
            throw new Exception("GBS2 will arrive on time");
        } else if (busNO.equals("GBS2")) {
            // logger.info("The shuttle bus: HeXi -> Company");
            throw new Exception("GBS2 will be late for 5 minutes");
        } else if (busNO.equals("GBS3")) {
            // logger.info("The shuttle bus: HePing -> Company");
            throw new Exception("GBS2 will be late for 10 minutes");
        }
    }

    public Employee findOne(Integer id) {
        return employeeRepository.findOne(id);
    }

}
