

import java.util.ArrayList;

public class MonsterTeam extends Team{
    public MonsterTeam(String name){
        super(name);
    }
    public Character[] alivemembers(){

        ArrayList<Character> alive = new ArrayList<Character>();
        //for loop to add alive members into another arraylist
        for (Character x:members) {
            // if statment to check if members are alive
            if (x.getHP() > 0){
                alive.add(x);
            }

        }
        //turning alive arraylist into an array of characters
        Character[] array = new Character[alive.size()];
        return alive.toArray(array);

    }

    @Override
    public void move(Character member, Team enemyTeam) {
        Character[] enemyarray = enemyTeam.alivemembers();
        int rnd2 = (int) (Math.random()*(enemyarray.length));
        Character enemy = enemyarray[rnd2];
        if (member instanceof Boss){
            ((Boss) member).strike(enemy);
        }
        else if (member instanceof Minion){
            ((Minion) member).strike(enemy);
        }
    }
    //creating a monster team from text file
    public void createmonstersteam(String line) {

        String[] parts = line.split(";");

        for (String monster : parts) {
            String name = monster.split("\\(")[0];
            String classtype = monster.split("\\(")[1].split(",")[0];
            String level = monster.split("\\(")[1].split(",")[1].split("\\)")[0];
            this.addmonster(name, classtype, level);


        }

    }
        public void addmonster (String name, String classtype, String level){
            if (classtype.equals("Minion")) {
                Minion minion1 = new Minion(name);
                minion1.setlvl(level);
                this.addMember(minion1);
            } else if (classtype.equals("Boss")) {
                Boss boss1 = new Boss(name);
                boss1.setlvl(level);
                this.addMember(boss1);
            }
        }


}

