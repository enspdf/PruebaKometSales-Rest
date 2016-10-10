package entities;

public class Editorial {
	private int id;
	private String editorial_name;

	public Editorial() {
		super();
	}

	public Editorial(int id, String editorial_name) {
		super();
		this.id = id;
		this.editorial_name = editorial_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEditorial_name() {
		return editorial_name;
	}

	public void setEditorial_name(String editorial_name) {
		this.editorial_name = editorial_name;
	}

	@Override
	public String toString() {
		return "Editorial [id=" + id + ", editorial_name=" + editorial_name + "]";
	}

}
