package com.tutorial.springboot_tutorial.domain;


import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

/**
 * Created by JeremyLiu on 21/08/2017.
 */
@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Integer id;

    @Min(value = 1000000, message = "\n************ Length of pwid is not enough ************\n")
    private Integer pwid;

    private String name;

    @NotBlank(message = "\n************ BusNO should not be blank ************\n")
    private String busNO;

    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPwid() {
        return pwid;
    }

    public void setPwid(Integer pwid) {
        this.pwid = pwid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusNO() {
        return busNO;
    }

    public void setBusNO(String busNO) {
        this.busNO = busNO;
    }
}
