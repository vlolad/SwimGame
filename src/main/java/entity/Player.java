package entity;

import lombok.Getter;
import lombok.Setter;
import util.Coordinates;
import util.Difficulty;

@Getter
@Setter
public class Player implements Entity {
    private String model = "\uD83C\uDFCA";
    private int lives;
    private int stamina;
    private Coordinates cord;

    public Player(Difficulty diff, Coordinates cord) {
        this.cord = cord;
        switch (diff){
            case EASY:
                this.lives = 5;
                this.stamina = 20;
                break;
            case MEDIUM:
                this.lives = 3;
                this.stamina = 15;
                break;
            case HARD:
                this.lives = 1;
                this.stamina = 10;
                break;
            case DEBUG:
                this.model = "\uD83E\uDDB8";
                this.lives = 99;
                this.stamina = 100;
                break;
        }
    }

    public int decreaseStamina() {
        stamina--;
        return stamina;
    }

    @Override
    public EntityType getType() {
        return EntityType.PLAYER;
    }

    @Override
    public String toString() {
        return model;
    }
}
