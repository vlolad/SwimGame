package entity;

import util.Coordinates;

public class Boat implements Entity {
    private String model = "\uD83D\uDEA2";
    private Coordinates cord;

    public Boat(Coordinates cord) {
        this.cord = cord;
    }

    @Override
    public Coordinates getCord(){
        return cord;
    }

    @Override
    public String toString() {
        return model;
    }

    @Override
    public EntityType getType() {
        return EntityType.BOAT;
    }
}
