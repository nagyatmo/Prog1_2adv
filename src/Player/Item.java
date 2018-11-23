package Player;

public class Item {
	
	private int energy;
	private String name;
	private int count;
	
	public Item(int energy, String name, int count) {
		super();
		this.energy = energy;
		this.name = name;
		this.count = count;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	

}
