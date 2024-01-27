package zombicide.map.cell;
import java.util.*;
import zombicide.map.util.*;
import zombicide.actor.survivors.*;
import zombicide.actor.zombies.*;

public abstract class Cell {
	
	//List to store survivors and zombies in the cell
	protected List<Survivor> survivors;
	protected List<Zombie> zombies;
	
	// The noise level and position of the cell
	protected int noiseLevel;
	protected Position position;
	
	// Constructor to initialize the cell with noise level and position
	public Cell(Position position) {
		
		this.noiseLevel=0;
		this.position=position;
		this.survivors=new ArrayList<Survivor>();
		this.zombies=new ArrayList<Zombie>();
	}
	
	// Method to add a zombie to the cell
	public void addZombies(Zombie z) {
		this.zombies.add(z);
	}
	
	// Method to add a survivor to the cell
	public void addSurvivors(Survivor s) {
		this.survivors.add(s);
	}
	
	// Method to remove a zombie from the cell
	public void removeZombie(Zombie z) {
		this.zombies.remove(z);
	}
	
	// Method to remove a survivor from the cell
	public void removeSurvivor(Survivor s) {
		this.survivors.remove(s);
	}
	
	// Method to get the count of survivors in the cell
	public int howManySurvivors() {
		return this.survivors.size();
	}
	
	// Method to get the count of zombies in the cell
	public int howManyZombies() {
		return this.zombies.size();
	}
	
	// Method to get the list of survivors in the cell
	public List<Survivor> getSurvivors(){
		return this.survivors;
	}
	
	// Method to get the list of zombies in the cell
	public List<Zombie> getZombies(){
		return this.zombies;
	}
	
	// Method to get the npise level in the cell
	public int getNoiseLevel() {
		return this.noiseLevel;
	}
	
	// Method to check if there are survivors in the cell who can fight
	public boolean canFight() {
		return !survivors.isEmpty();
	}
	
	// Method to get the position of the cell
	public Position getPosition() {
		return this.position;
	}
	
	
}
