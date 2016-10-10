package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.EditorialDao;
import entities.Editorial;

public class EditorialDaoJdbc implements EditorialDao {
	
	protected PreparedStatement preparedStatement;
	protected ResultSet resultSet;

	@Override
	public List<Editorial> getEditorials(Connection connection) throws SQLException {
		List<Editorial> editorialsList = new ArrayList<Editorial>();
		preparedStatement = connection.prepareStatement("SELECT id, editorial_name FROM editorial");
		try {
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Editorial editorialRes = new Editorial();
				editorialRes.setId(resultSet.getInt("id"));
				editorialRes.setEditorial_name(resultSet.getString("editorial_name"));
				editorialsList.add(editorialRes);
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return editorialsList;
	}

	@Override
	public Editorial getEditorialbyId(Connection connection, Editorial editorial) throws SQLException {
		Editorial editorialRes = null;
		int index = 1;
		preparedStatement = connection.prepareStatement("SELECT id, editorial_name FROM editorial WHERE id = ?");
		preparedStatement.setInt(index++, editorial.getId());
		try {
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				editorialRes = new Editorial();
				editorialRes.setId(resultSet.getInt("id"));
				editorialRes.setEditorial_name(resultSet.getString("editorial_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return editorialRes;
	}

	@Override
	public void saveEditorial(Connection connection, Editorial editorial) throws SQLException {
		int index = 1;
		preparedStatement = connection.prepareStatement("INSERT INTO editorial (editorial_name) VALUES (?)");
		preparedStatement.setString(index++, editorial.getEditorial_name());
		try {
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	@Override
	public void updateEditorial(Connection connection, Editorial editorial) throws SQLException {
		int index =1 ;
		preparedStatement = connection.prepareStatement("UPDATE editorial SET editorial_name = ? WHERE id = ?");
		preparedStatement.setString(index++, editorial.getEditorial_name());
		preparedStatement.setInt(index++, editorial.getId());
		try {
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	@Override
	public void deleteEditorial(Connection connection, Editorial editorial) throws SQLException {
		int index = 1;
		preparedStatement = connection.prepareStatement("DELETE FROM editorial WHERE id = ?");
		preparedStatement.setInt(index++, editorial.getId());
		try {
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

}
