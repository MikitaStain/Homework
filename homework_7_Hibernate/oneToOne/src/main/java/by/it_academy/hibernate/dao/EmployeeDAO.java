package by.it_academy.hibernate.dao;

import by.it_academy.hibernate.model.Employee;
import by.it_academy.hibernate.service.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;

public class EmployeeDAO implements IDAO<Employee, Long> {

    @Override
    public void create(Employee employee) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        }
    }

    @Override
    public Employee read(Long id) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Employee employee = session.get(Employee.class, id);

            if (employee != null) {
                Hibernate.initialize(employee.getDepartment());
            }
            return employee;
        }
    }

    @Override
    public void update(Employee employee) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            session.beginTransaction();
            session.update(employee);
            session.getTransaction().commit();
        }

    }

    @Override
    public void delete(Employee employee) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            session.beginTransaction();
            session.delete(employee);
            session.getTransaction().commit();
        }

    }
}
