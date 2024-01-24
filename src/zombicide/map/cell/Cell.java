package zombicide.map.cell;


public abstract class Cell {
	protected List<Survivor> survivors;
	protected List<Zombie> zombies;
	protected int noiseLevel;
	protected Position position;
	
	public Cell(int noiseLevel,Position position) {
		
		this.noiseLevel=noiseLevel;
		this.position=position;
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
		return this.survivors.size();
	}
	public int howManyZombies() {
		return this.zombies.size();
	}
	public List<Survivor> getSurvivors(){
		return this.survivors;
	}
	public List<Zombie> getZombies(){
		return this.zombies;
	}
	public int getNoiseLevel() {
		return this.noiseLevel;
	}
	public boolean canFight() {
		return !survivors.isEmpty();
	}
	public Position getPosition() {
		return this.position;
	}
	
	
}
