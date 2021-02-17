package ru.serik.service;

// Service предназначен для  хранения различная бизнес логика программы, но в нашем
// случае мы просто определим методы DAO и через service будем их запускать.

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.serik.dao.PersonDAO;
import ru.serik.models.Person;

import java.sql.SQLException;
import java.util.List;

            // @Component - помечает класс в качестве кандидата для создания Spring бина.
@Service    // Производная от @Component, только применяется для пометки сервиса.
public class PersonServiceImpl implements PersonService {
    private final PersonDAO personDAO;

    @Autowired
    public PersonServiceImpl (PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public List<Person> getAllPerson() throws SQLException,  Exception {
        return personDAO.getAllPerson();
    }


    @Override
    public Person getPersonById(int idPerson) throws SQLException, Exception {
        return personDAO.getPersonById(idPerson);
    }

    @Override
    public void savePerson(Person personSave) throws SQLException, Exception {
        personDAO.savePerson(personSave);
    }

    @Override
    public void updatePerson(Person personUpdate) throws SQLException, Exception {
        personDAO.updatePerson(personUpdate);
    }

    @Override
    public void deletePerson(Person personDelete) throws SQLException, Exception {
        personDAO.deletePerson(personDelete);
    }
}
