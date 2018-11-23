package Player;

import java.util.ArrayList;
import java.util.List;

public class Pirate {
	
	public int x;
	public int y;
	public double energy;
	public int money;
	public List<Item> inventory;
	
	public Pirate(int x, int y, double energy, int money) {
		this.x = x;
		this.y = y;
		this.energy = energy;
		this.money = money;
		this.inventory = new ArrayList<>();
	}
	
	
}
