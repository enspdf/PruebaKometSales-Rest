package manger;

import java.util.List;

import entities.Editorial;

public interface EditorialManager {
	List<Editorial> getAllEditorials();
	Editorial getEditorialById(Editorial editorial);
	void saveEditorial(Editorial editorial);
	void updateEditorial(Editorial editorial);
	void deleteEditorial(Editorial editorial);
}
