package entity;

import util.Coordinates;

public interface Entity {
    EntityType getType();
    Coordinates getCord();
}
