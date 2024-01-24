package zombicide.map.cell;


public abstract class Cell {
	protected List<Survivor> survivors;
	protected List<Zombie> zombies;
	protected int NoiseLevel;
	protected position Position;
	
	public Cell(int NoiseLevel,position Position) {
		
		this.NoiseLevel=NoiseLevel;
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
		return survivors.size();
	}
	public int howManyZombies() {
		return zombies.size();
	}
	public List<Survivor> getSurvivors(){
		return survivors;
	}
	public List<Zombie> getZombies(){
		return zombies;
	}
	
	
}
