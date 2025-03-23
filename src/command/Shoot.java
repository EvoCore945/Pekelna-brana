package command;

import World.WorldMap;
import characters.Boss;
import characters.Monster;
import characters.Player;

import java.util.Random;
import java.util.Scanner;

public class Shoot extends Command {

    private Monster monster;
    private Boss boss;

    private boolean isDead = false;
    Random random = new Random();

    public String execute() {
        Scanner sc = new Scanner(System.in);
        int currentPosition = WorldMap.getCurrentPosition();

         Player player = Player.getInstance();
        Monster monster =  Monster.getMonsterAt(currentPosition);

        if (monster == null){
            return "There is no monster in this location.";
        }
        System.out.println(" You have found " + monster.getName() + "You can fight (shoot) or escape (escape)!");
        String choice = sc.nextLine().toLowerCase();

        if("escape".equals(choice)){
            return "You escaped!";
        }else if("shoot".equals(choice)){
            System.out.println("The fight begins with " + monster.getName() + "!");

            while (player.getHealth() > 0 && monster.getHealth() > 0){
                System.out.println(monster.getName() + ", Health: " + monster.getHealth() + ", AttackDamage: " + monster.getAttackDamage());
                System.out.println(player.getName() + ", Health: " + player.getHealth() + ", AttackDamage: " + player.getAttackDamage());

                monster.setHealth(monster.getHealth() - player.getAttackDamage());
                if(monster.getHealth() <= 0){
                    System.out.println("You have won!");
                    player.setHealth(player.getHealth() + 10);
                    player.setAttackDamage(player.getAttackDamage() + 3);
                    Monster.removeMonster(currentPosition);
                    return "Your health and damage are increased! (+10, +3)";
                }
                player.setHealth(player.getHealth() - monster.getAttackDamage());
                if(player.getHealth() <= 0){
                    System.out.println("You have died!");
                  isDead = true;
                }
            }
        }

        return " false response!";
    }

    @Override
    public boolean exit() {
        return isDead;
    }

    }







