

import java.util.ArrayList;

public class StudentTeam extends Team {
    //contructor to state name of the team
    public StudentTeam(String name){
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

    public void move(Character member, Team enemyTeam){
        Student temp = (Student) member;
        if (enemyTeam.alivemembers().length == 0 ){
            System.out.println("all enemies are dead ");

        }
        else{
            //move method for css student
            if (temp.getCurrentKP() ==temp.maxKP){
                if (temp instanceof CSStudent ){
                    ((CSStudent) temp).cssMove(enemyTeam);

                }
                //move method for sestudent
                else if (temp instanceof SEStudent){
                    ((SEStudent) temp).semove(enemyTeam);
                }
                else if (temp instanceof AIStudent){
                    ((AIStudent) temp).aimove(enemyTeam);
                }
                else if (temp instanceof CyberStudent){
                    ((CyberStudent) temp).cybermove(enemyTeam);
                }
            }
            else{
                temp.generalmove(enemyTeam);
            }
        }


    }

}
