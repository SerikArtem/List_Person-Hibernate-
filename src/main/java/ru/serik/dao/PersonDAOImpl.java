package ru.serik.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import ru.serik.models.Person;
import ru.serik.util.HibernateSessionFactoryUtil;

import java.sql.SQLException;
import java.util.List;

            // @Component - помечает класс в качестве кандидата для создания Spring бина.
@Repository // Производная от @Component, только применяется для пометки класса, работающего с БД.
public class PersonDAOImpl implements PersonDAO {

    // Метод, который будет возвращать всех людей из таблицы people.
    @Override
    @SuppressWarnings("unchecked") // Отключает некоторые предупреждения компилятора
    public List<Person> getAllPerson() throws SQLException, Exception {
        List<Person> people = (List<Person>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("from Person").list();
        return people;
    }

    // Метод, который будет возвращать конкретного человека по ID из таблицы people.
    @Override
    public Person getPersonById(int idPerson) throws SQLException, Exception {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Person.class, idPerson);
    }

    // Метод, который будет сохранять человека в таблице people.
    @Override
    public void savePerson(Person personSave) throws SQLException, Exception {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(personSave);
        transaction.commit();
        session.close();
    }

    // Метод, который будет добавлять в таблицу people уже отредактированного человека.
    @Override
    public void updatePerson(Person personUpdate) throws SQLException, Exception {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(personUpdate);
        transaction.commit();
        session.close();
    }

    // Метод, который будет удалять человека из таблицы people по его ID.
    @Override
    public void deletePerson(Person personDelete) throws SQLException, Exception {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(personDelete);
        transaction.commit();
        session.close();
    }


}
