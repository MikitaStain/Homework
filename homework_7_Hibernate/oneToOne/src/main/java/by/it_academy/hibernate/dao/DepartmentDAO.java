package by.it_academy.hibernate.dao;

import by.it_academy.hibernate.model.Department;
import by.it_academy.hibernate.service.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import java.io.Serializable;

public class DepartmentDAO implements IDAO<Department, Long> {

    @Override
    public void create(Department department) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            session.beginTransaction();
            session.save(department);
            session.getTransaction().commit();
        }

    }

    @Override
    public Department read(Long id) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Department department = session.get(Department.class, id);

            if (department != null) {
                Hibernate.initialize(department.getId());
            }
            return department;
        }
    }

    @Override
    public void update(Department department) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            session.beginTransaction();
            session.update(department);
            session.getTransaction().commit();
        }

    }

    @Override
    public void delete(Department department) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            session.beginTransaction();
            session.delete(department);
            session.getTransaction().commit();
        }
    }


}

