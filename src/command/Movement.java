package command;

import World.Location;
import World.WorldMap;

import java.util.Scanner;

public class Movement {

  /*  private Scanner sc = new Scanner(System.in);
    private WorldMap world;

    public Movement(WorldMap world, String s){
        this.world = world;
    }

    public String execute() {
        Location currentLocation = world.getCurrentPosition();
        System.out.println("Current location: " + currentLocation.getName());
        System.out.println("Available directions: North (0), South (1), West (2), East (3)");
        System.out.println("Kam chceš jít? >>");

        String direction = sc.nextLine().trim().toLowerCase();
        int directionIndex = getDirectionIndex(direction);

        if (directionIndex == -1) {
            return "False direction. Use: 'north', 'south', 'west', or 'east'";
        }
        boolean moved = world.move(directionIndex);
        if (moved) {
            return "You were moved to: " + world.getCurrentPosition().getName();
        } else {
            return "You cannot go in this direction .";
        }
    }

    @Override
    public boolean exit() {
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
*/
        }



