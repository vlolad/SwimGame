import engine.Controller;
import engine.SeaMap;
import entity.Boat;
import entity.Player;
import util.Controls;
import util.Coordinates;
import util.Results;

import java.util.Random;
import java.util.Scanner;

import static util.Difficulty.*;

/*
Original idea by my friend Andrey. Thx.
 */

public class Main {

    public static void main(String[] args) {
        SeaMap map = new SeaMap();
        Random rd = new Random();
        Player player = new Player(EASY, new Coordinates(rd.nextInt(10), rd.nextInt(10)));
        Boat boat = new Boat(new Coordinates(rd.nextInt(10), rd.nextInt(10)));
        Controller control = new Controller(map);
        Scanner input = new Scanner(System.in);
        control.initialiseMap(player, boat);
        showScreen(map);
        while (true) {
            System.out.println("Move: ");
            String move = input.nextLine();
            control.movePlayer(Controls.parseMove(move));
            if (control.getResult().equals(Results.WIN)) {
                System.out.println("Ура, ты на корабле. Нажми ENTER и плыви отсюда.");
                input.nextLine();
                break;
            } else if (control.getResult().equals(Results.DEAD)) {
                System.out.println("Ты умер. Нажми ENTER и всё.");
                input.nextLine();
                break;
            }
            showScreen(map);
        }
    }

    private static void showScreen(SeaMap map) {
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                if (map.getSeaMap()[j][i] == null) {
                    System.out.print(map.getWave());
                } else {
                    System.out.print(map.getSeaMap()[j][i]);
                }
            }
            System.out.println();
        }
    }
}
