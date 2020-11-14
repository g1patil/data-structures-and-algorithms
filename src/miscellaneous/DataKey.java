package miscellaneous;

public class DataKey {
    private String name;
	private int id;

    

	@Override
	public String toString() {
		return "DataKey [name=" + name + ", id=" + id + "]";
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}