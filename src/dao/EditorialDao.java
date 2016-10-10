package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import entities.Editorial;

public interface EditorialDao {
	List<Editorial> getEditorials(Connection connection) throws SQLException;
	Editorial getEditorialbyId(Connection connection, Editorial editorial) throws SQLException;
	void saveEditorial(Connection connection, Editorial editorial) throws SQLException;
	void updateEditorial(Connection connection, Editorial editorial) throws SQLException;
	void deleteEditorial(Connection connection, Editorial editorial) throws SQLException;
}
