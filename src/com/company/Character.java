

import java.lang.Math ;

public class Character implements Comparable<Character>  {

    public int level = 1 ;
    public String name ;
    public int baseHP ;
    public int baseAtk;
    public int baseDef;
    public int baseSpd;
    Team team ;
    public Character(String name,  int baseHP, int baseAtk, int baseDef, int baseSpd) {


        this.name = name ;
        this.baseHP = baseHP ;
        this.baseAtk = baseAtk;
        this.baseDef = baseDef ;
        this.baseSpd = baseSpd ;
        currentHP = this.getMaxHP();



    }



    public String getName() {
        return name ;
    }
    public int getMaxHP() {
        return (int) Math.round(baseHP * Math.pow(level, 1.2));


    }
    public int getAttack() {
        return (int) Math.round(this.baseAtk * Math.pow(level,1.2));
    }
    public int getDefence() {
        int maxdef = (int)  Math.round(this.baseDef * Math.pow(this.level,1.2));
        return maxdef ;
    }
    public int getSpeed() {
        int maxspd = (int) Math.round(baseSpd * Math.pow(level,1.2));
        return maxspd ;
    }
    public int getTargetEP() {
        int targetep = (int) Math.round(10 * Math.pow(level, 1.5));
        return targetep;
    }
    int currentHP ;



    private int currentEP ;
    public int getHP() {
        return currentHP;
    }
    public int getEP() {
        return currentEP;
    }
    public void increaseHP(int amount) {
        if (currentHP >= 0 && currentHP <= this.getMaxHP() ) {
            if (currentHP + amount <= this.getMaxHP()) {
                currentHP = currentHP+ amount;

            }
            else {
                currentHP = this.getMaxHP();
            }

        }

    }
    public void decreaseHP(int amount) {
        if (currentHP >= amount) {
            currentHP = currentHP - amount ;
        }
        else if(currentHP < amount) {
            currentHP = 0 ;
        }
    }
    public void increaseEP(int amount) {

        if (currentEP + amount >= this.getTargetEP()) {
            level ++;
            currentEP = 0;

            if (this.getHP() != 0){
                currentHP = this.getMaxHP() ;
            }

            else{
               currentHP = this.getHP();
            }

        }
        else {
            currentEP = currentEP + amount ;
        }

    }
    public void setTeam(Team team) {
        this.team = team ;
    }
    public Team getTeam() {
        return team ;
    }
    public static void main(String[] args){
        Character m = new Character("apinfus", 7, 10, 13, 15);

        System.out.println(m.currentHP);
    }


    @Override
    public int compareTo(Character o) {
        return o.getSpeed() - this.getSpeed();

    }
}





