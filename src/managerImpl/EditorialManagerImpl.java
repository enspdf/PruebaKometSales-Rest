package managerImpl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnection;
import entities.Editorial;
import manger.EditorialManager;

public class EditorialManagerImpl extends DatabaseConnection implements EditorialManager {

	@Override
	public List<Editorial> getAllEditorials() {
		List<Editorial> listEditorials = new ArrayList<Editorial>();
		Connection connection = this.getConnection();
		
		return listEditorials;
	}

	@Override
	public Editorial getEditorialById(Editorial editorial) {
		Editorial editorialInfo = new Editorial();
		Connection connection = this.getConnection();
		
		return editorialInfo;
	}

	@Override
	public void saveEditorial(Editorial editorial) {
		Connection connection = this.getConnection();
		
	}

	@Override
	public void updateEditorial(Editorial editorial) {
		Connection connection = this.getConnection();
		
	}

	@Override
	public void deleteEditorial(Editorial editorial) {
		Connection connection = this.getConnection();
		
	}

}
