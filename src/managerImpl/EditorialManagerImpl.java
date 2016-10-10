package managerImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import daoImpl.EditorialDaoJdbc;
import database.DatabaseConnection;
import entities.Editorial;
import manger.EditorialManager;

public class EditorialManagerImpl extends DatabaseConnection implements EditorialManager {
	
	EditorialDaoJdbc dao = new EditorialDaoJdbc();

	@Override
	public List<Editorial> getAllEditorials() {
		List<Editorial> listEditorials = new ArrayList<Editorial>();
		Connection connection = this.getConnection();
		try {
			listEditorials = dao.getEditorials(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listEditorials;
	}

	@Override
	public Editorial getEditorialById(Editorial editorial) {
		Editorial editorialInfo = new Editorial();
		Connection connection = this.getConnection();
		try {
			editorialInfo = dao.getEditorialbyId(connection, editorial);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return editorialInfo;
	}

	@Override
	public void saveEditorial(Editorial editorial) {
		Connection connection = this.getConnection();
		try {
			dao.saveEditorial(connection, editorial);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateEditorial(Editorial editorial) {
		Connection connection = this.getConnection();
		try {
			dao.updateEditorial(connection, editorial);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEditorial(Editorial editorial) {
		Connection connection = this.getConnection();
		try {
			dao.deleteEditorial(connection, editorial);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
