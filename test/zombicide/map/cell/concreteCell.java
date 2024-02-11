package zombicide.map.cell;

import zombicide.map.util.Position;

public class concreteCell extends Cell {
    public concreteCell(Position position) {
        super(position);
    }

    @Override
    public boolean canFight() {
        return false;
    }

    @Override
    public String display() {
        return null;
    }

    @Override
    public Object getTypeOfCell() {
        return null;
    }
}
