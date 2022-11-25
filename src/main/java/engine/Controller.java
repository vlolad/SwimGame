package engine;

import entity.Boat;
import entity.Entity;
import entity.Player;
import lombok.Getter;
import lombok.Setter;
import util.Controls;
import util.Coordinates;
import util.Results;

import static util.Results.*;

@Getter
@Setter
public class Controller {
    private SeaMap map;
    private Player player;
    private Boat boat;
    private Results result = GAME;

    public Controller(SeaMap map) {
        this.map = map;
    }

    public void initialiseMap(Player player, Boat boat) {
        map.getSeaMap()[player.getCord().x()][player.getCord().y()] = player;
        map.getSeaMap()[boat.getCord().x()][boat.getCord().y()] = boat;
        this.player = player;
        this.boat = boat;
    }

    public void movePlayer(Controls move){
        if (move == null) return; // TODO адекватная реакция на отсутствие контроллобалса
        Coordinates cord = new Coordinates(player.getCord());
        switch (move) {
            case W:
                cord.set(cord.x(), cord.y() - 1);
                break;
            case S:
                cord.set(cord.x(), cord.y() + 1);
                break;
            case A:
                cord.set(cord.x() - 1, cord.y());
                break;
            case D:
                cord.set(cord.x() + 1, cord.y());
                break;
            default:
                System.out.println("Command not supported. Yet.");
        }
        if (cord.equals(boat.getCord())) {
            this.result = WIN;
            return;
        }
        player.decreaseStamina();
        if (player.getStamina() == 0) {
            this.result = DEAD;
        } else {
            updateMap(cord, player);
        }
    }

    private void updateMap(Coordinates cord, Entity entity) {
        map.getSeaMap()[entity.getCord().x()][entity.getCord().y()] = null;
        map.getSeaMap()[cord.x()][cord.y()] = entity;
        entity.getCord().set(cord);
    }
}
