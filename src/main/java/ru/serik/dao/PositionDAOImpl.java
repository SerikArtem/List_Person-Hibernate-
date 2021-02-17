package ru.serik.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import ru.serik.models.Position;
import ru.serik.util.HibernateSessionFactoryUtil;

import java.sql.SQLException;
import java.util.List;

@Repository
public class PositionDAOImpl implements PositionDAO {

    // Метод, который возвращает все профессии из таблицы positions.
    @Override
    @SuppressWarnings("unchecked")
    public List<Position> getAllPosition() throws SQLException, Exception {
        List<Position> positions = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Position ").list();
        return positions;
    }

    // Метод, который возвращает конкретную профессию по ID из таблицы positions.
    @Override
    public Position getPositionById(int idPosition) throws SQLException, Exception {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Position.class, idPosition);
    }

    // Метод, который сохраняет профессию в таблице positions.
    @Override
    public void savePosition(Position positionSave) throws SQLException, Exception {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(positionSave);
        transaction.commit();
        session.close();
    }

    // Метод, который добавляет в таблицу positions уже отредактированую профессию.
    @Override
    public void updatePosition(Position positionUpdate) throws SQLException, Exception {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(positionUpdate);
        transaction.commit();
        session.close();
    }

    // Метод, который удаляет профессию из таблицы positions по её ID.
    @Override
    public void deletePosition(Position positionDelete) throws SQLException, Exception {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(positionDelete);
        transaction.commit();
        session.close();
    }
}
