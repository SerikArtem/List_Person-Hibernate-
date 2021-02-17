package ru.serik.dao;

import ru.serik.models.Position;

import java.sql.SQLException;
import java.util.List;

public interface PositionDAO {
    List<Position> getAllPosition() throws SQLException, Exception;                         // Все люди из таблицы positions
    Position getPositionById(int idPosition) throws SQLException, Exception;                // Конкретный человек по ID из таблицы positions
    void savePosition(Position positionSave) throws SQLException, Exception;                // Сохранить человека в таблицу positions
    void updatePosition(Position positionUpdate) throws SQLException, Exception;            // Обновляет человека в таблице positions
    void deletePosition(Position positionDelete) throws SQLException, Exception;            // Удаление человека из таблицы positions по ID
}
