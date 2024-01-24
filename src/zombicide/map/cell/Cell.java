package zombicide.map.cell;


public abstract class Cell {
	protected List<Survivors> survivors=new ArrayList<Survivors>();
	protected List<Zombies> zombies=new ArrayList<Zombies>();
	protected int NoiseLevel;
	protected position Position;
	
	public Cell(int NoiseLevel,position Position) {
		
		this.NoiseLevel=NoiseLevel;
		this.Position=Position;
	}
	
	
	
	
	

}
