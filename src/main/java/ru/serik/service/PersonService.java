package ru.serik.service;

import ru.serik.models.Person;

import java.sql.SQLException;
import java.util.List;

public interface PersonService {
    List<Person> getAllPerson() throws SQLException, Exception;                             // Все люди из таблицы people
    Person getPersonById(int idPerson) throws SQLException, Exception;                      // Конкретный человек по ID из таблицы people
    void savePerson(Person personSave) throws SQLException, Exception;                      // Сохранить человека в таблицу people
    void updatePerson(Person personUpdate) throws SQLException, Exception;                  // Обновляет человека в таблице people
    void deletePerson(Person personDelete) throws SQLException, Exception;                  // Удаление человека из таблицы people по ID
}
