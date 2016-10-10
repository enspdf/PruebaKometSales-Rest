package entities;

public class Author {
	private int id;
	private String first_name;
	private String initials;
	private String last_name;

	public Author() {
		super();
	}

	public Author(int id, String first_name, String initials, String last_name) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.initials = initials;
		this.last_name = last_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", first_name=" + first_name + ", initials=" + initials + ", last_name=" + last_name
				+ "]";
	}

}
