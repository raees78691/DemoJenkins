package com.test;

package com.test;

import java.util.Objects;

public class Address {
    private String city;
    private String state;
    private String country;
    private String pinCode;

    public Address(String city, String state, String country, String pinCode) {
        this.city = city;
        this.state = state;
        this.country = country;
        this.pinCode = pinCode;
    }

    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
    public String getCountry() {
        return country;
    }
    public String getPinCode() {
        return pinCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", pinCode='" + pinCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(city, address.city) &&
                Objects.equals(state, address.state) &&
                Objects.equals(country, address.country) &&
                Objects.equals(pinCode, address.pinCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, state, country, pinCode);
    }
}

package com.test;

import java.util.Objects;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private Address address;       // 👈 Composition
    private String department;

    public Employee(int id, String name, double salary, Address address, String department) {
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
    public Address getAddress() {
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
                ", address=" + address +
                ", department='" + department + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                Double.compare(salary, employee.salary) == 0 &&
                Objects.equals(name, employee.name) &&
                Objects.equals(address, employee.address) &&
                Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary, address, department);
    }
}

package com.test;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Address addr1 = new Address("Kurla", "Maharashtra", "India", "400070");
        Address addr2 = new Address("Sion", "Maharashtra", "India", "400022");

        Employee e1 = new Employee(1, "Raees", 50000, addr1, "IT");
        Employee e2 = new Employee(2, "R1", 60000, addr2, "Sales");

        List<Employee> lemp = Arrays.asList(e1, e2);

        lemp.forEach(System.out::println);
    }
}


//give programme java stream api 8 to give employee name whose salary greater than 50000 and live in city Kurla

package com.test;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Address addr1 = new Address("Kurla", "Maharashtra", "India", "400070");
        Address addr2 = new Address("Sion", "Maharashtra", "India", "400022");
        Address addr3 = new Address("Kurla", "Maharashtra", "India", "400071");

        Employee e1 = new Employee(1, "Raees", 50000, addr1, "IT");
        Employee e2 = new Employee(2, "R1", 60000, addr2, "Sales");
        Employee e3 = new Employee(3, "R3", 70000, addr3, "Finance");

        List<Employee> lemp = Arrays.asList(e1, e2, e3);

        // 🔎 Filter by salary > 50000 and city = "Kurla"
        lemp.stream()
                .filter(emp -> emp.getSalary() > 50000)                         // salary condition
                .filter(emp -> emp.getAddress().getCity().equals("Kurla"))     // city condition
                .map(Employee::getName)                                        // get only names
                .forEach(System.out::println);                                 // print names
    }
}

//and group by department
package com.test;

import java.util.*;
        import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Address addr1 = new Address("Kurla", "Maharashtra", "India", "400070");
        Address addr2 = new Address("Sion", "Maharashtra", "India", "400022");
        Address addr3 = new Address("Kurla", "Maharashtra", "India", "400071");

        Employee e1 = new Employee(1, "Raees", 50000, addr1, "IT");
        Employee e2 = new Employee(2, "R1", 60000, addr2, "Sales");
        Employee e3 = new Employee(3, "R3", 70000, addr3, "Finance");
        Employee e4 = new Employee(4, "R4", 90000, addr3, "IT");

        List<Employee> lemp = Arrays.asList(e1, e2, e3, e4);

        // 🔎 Filter + Group by department
        Map<String, List<Employee>> grouped = lemp.stream()
                .filter(emp -> emp.getSalary() > 50000)                          // salary condition
                .filter(emp -> emp.getAddress().getCity().equals("Kurla"))      // city condition
                .collect(Collectors.groupingBy(Employee::getDepartment));       // group by dept

        // Print results
        grouped.forEach((dept, emps) -> {
            System.out.println(dept + " -> " +
                    emps.stream().map(Employee::getName).collect(Collectors.toList()));
        });
    }
}

----------------
        grouped.forEach((dept, emps) -> { System.out.println(dept + " -> " + emps.stream().map(Employee::getName).collect(Collectors.toList())); }); can we do grouped.entrySet().forEach(System.out::println)

    ----------
yes we can do
    grouped.entrySet().forEach(System.out::println);

