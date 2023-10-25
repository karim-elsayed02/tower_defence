

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TowerOfMonsters {
    public static void main(String[] args) {
        BufferedReader br = null;
        String line;
        Guild fairytail = new Guild();
        MonsterTeam monsters = new MonsterTeam("monstersTeam");
        int i = 1;
        try {
            br = new BufferedReader(new FileReader(args[0]));
            while ((line = br.readLine()) != null) {
                monsters.createmonstersteam(line);
                StudentTeam steam = fairytail.getTeam(monsters);
                Battle floor = new Battle(steam, monsters);
                floor.fight();
                while (monsters.alivemembers().length != 0) {
                    if (steam.alivemembers().length == 0) {
                        if (fairytail.guildealive().length == 0) {
                            System.out.println("all students in guild are dead");
                            break;
                        } else {
                            steam = fairytail.getTeam(monsters);
                        }

                    } else if (steam.alivemembers().length != 0) {
                        steam = fairytail.getTeam(monsters);
                    }
                    floor.fight();


                }
                if (fairytail.guildealive().length == 0) {
                    System.out.println("all students in guild are dead");
                    break;

                }
            }
        } catch (IOException e  ) {
            e.printStackTrace();
        }


    }
}