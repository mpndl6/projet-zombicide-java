package zombicide.map.cell;


public abstract class Cell {
	protected List<Survivor> survivors;
	protected List<Zombie> zombies;
	protected int noiseLevel;
	protected position Position;
	
	public Cell(int noiseLevel,position Position) {
		
		this.noiseLevel=noiseLevel;
		this.Position=Position;
		this.survivors=new ArrayList<Survivor>();
		this.zombies=new ArrayList<Zombie>();
	}
	
	public void addZombies(Zombie z) {
		this.zombies.add(z);
	}
	
	public void addSurvivors(Survivor s) {
		this.survivors.add(s);
	}
	public void removeZombie(Zombie z) {
		this.zombies.remove(z);
	}
	public void removeSurvivor(Survivor s) {
		this.survivors.remove(s);
	}
	public int howManySurvivors() {
		this.survivors.size();
	}
	public int howManyZombies() {
		this.zombies.size();
	}
	public List<Survivor> getSurvivors(){
		this.survivors;
	}
	public List<Zombie> getZombies(){
		this.zombies;
	}
	public int getNoiseLevel() {
		this.noiseLevel;
	}
	
	
}
