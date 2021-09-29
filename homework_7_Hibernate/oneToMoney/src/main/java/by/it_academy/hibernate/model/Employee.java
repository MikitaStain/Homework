package by.it_academy.hibernate.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employees")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "employee_name")
    private String name;

    @Column(name = "employee_salary")
    private String salary;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;


    public Employee() {
    }

    public Employee(long id, String name, String salary,Department department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary='" + salary + '\'' +
                ", department=" + department +
                '}';
    }
}
