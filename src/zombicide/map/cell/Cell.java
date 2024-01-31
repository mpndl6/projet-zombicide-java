package zombicide.map.cell;

import java.util.ArrayList;
import java.util.List;


import zombicide.actor.survivors.Survivor;
import zombicide.actor.zombies.Zombie;

public abstract class Cell {
	
	//List to store survivors and zombies in the cell
	protected List<Survivor> survivors;
	protected List<Zombie> zombies;
	
	// The noise level and position of the cell
	protected int noiseLevel;
	protected Position position;
	
	// Constructor to initialize the cell with noise level and position
	public Cell(int noiseLevel,Position position) {
		
		this.noiseLevel=noiseLevel;
		this.position=position;
		this.survivors=new ArrayList<Survivor>();
		this.zombies=new ArrayList<Zombie>();
	}
	
	  /**
     * Adds a zombie to the cell
     *@param Zombie to be added to the cell
     */
	public void addZombies(Zombie z) {
		this.zombies.add(z);
	}
	
	  /**
     * Adds a survivor to the cell
     *@param Survivor to be added to the cell
     */
	public void addSurvivors(Survivor s) {
		this.survivors.add(s);
	}
	
	  /**
     *  Removes a zombie from the cell
     *@param Zombie to be removed from the cell
     */
	public void removeZombie(Zombie z) {
		this.zombies.remove(z);
	}
	
	  /**
     *  Removes a survivor from the cell
     *@param Survivor to be removed from the cell
     */
	public void removeSurvivor(Survivor s) {
		this.survivors.remove(s);
	}
	
	 /**
     *  Gets the count of survivors in the cell
     *@return The number of survivors in the cell
     */
	public int howManySurvivors() {
		return this.survivors.size();
	}
	
	 /**
     *  Gets the count of zombies in the cell
     *@return The number of zombies in the cell
     */
	public int howManyZombies() {
		return this.zombies.size();
	}
	
	 /**
     *  
     *  Gets the list of survivors in the cell
     *@return List of survivors in the cell
     */
	public List<Survivor> getSurvivors(){
		return this.survivors;
	}
	
	/**
     *  
     *  Gets the list of zombies in the cell     
     * @return List of zombies in the cell
     */
	public List<Zombie> getZombies(){
		return this.zombies;
	}
	
	/**
     *  
     *  Gets the noise level in the cell     
     * @return The noise level of the cell
     */
	public int getNoiseLevel() {
		return this.noiseLevel;
	}
	
	/**
     *  
     *  Checks if actors can fitgh in area
     * @return true if there are survivors who can fight, false otherwise
     */ 
	public abstract boolean canFight();
	
	/**
     *  
     *  Gets the position of the cell
     * @return The position of the cell
     */ 
	public Position getPosition() {
		return this.position;
	}
	
	
}
