package command;

import World.Location;
import World.WorldMap;

import java.util.Scanner;

public class Movement  implements Command{

    private Scanner sc = new Scanner(System.in);
    private WorldMap world;

    public Movement(WorldMap world){
        this.world = world;
    }

    public String execute() {
        Location currentLocation = world.getCurrentPosition();
        System.out.println("Aktuální lokace: " + currentLocation.getName());
        System.out.println("Dostupné směry: North (0), South (1), West (2), East (3)");
        System.out.println("Kam chceš jít? >>");

        String direction = sc.nextLine().trim().toLowerCase();
        int directionIndex = getDirectionIndex(direction);

        if (directionIndex == -1) {
            return "Neplatný směr. Použij: 'north', 'south', 'west', nebo 'east'";
        }
        boolean moved = world.move(directionIndex);
        if (moved) {
            return "Byl jsi přesunut na " + world.getCurrentPosition().getName();
        } else {
            return "Nelze se přesunout na toto místo.";
        }
    }

    @Override
    public boolean exist() {
        return false;
    }


    private int getDirectionIndex(String direction){
            switch (direction) {
                case "north":
                    return 0;
                case "south":
                    return 1;
                case "west":
                    return 2;
                case "east":
                    return 3;
                default:
                    return -1;
            }
        }

        }



