package com.test;

import java.util.Objects;

public class Employee {

    int id;
    String name;
    double salary;
    String address;
    String department;
    public Employee(int id, String name, double salary, String address,  String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.address = address;
        this.department = department;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;

    }

    public double getSalary() {
        return salary;
    }

    public String getAddress() {
        return address;
    }

    public String getDepartment() {
        return department;
    }



    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", address='" + address + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Double.compare(salary, employee.salary) == 0 && Objects.equals(name, employee.name) && Objects.equals(address, employee.address)  && Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary, address,  department);
    }
}
