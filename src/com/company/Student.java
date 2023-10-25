

public class Student extends Character {
    int maxKP ;
    public int currentKP = 0 ;
    public Student(String name, int baseHP, int baseAtk, int baseDef, int baseSpd, int maxKP){
        super(name, baseHP, baseAtk, baseDef, baseSpd);
        this.maxKP = maxKP;
    }
    public void increaseKP(int amount){
        if (this.getCurrentKP() + amount >= maxKP){
            this.currentKP = maxKP ;
        }
        else {
            this.currentKP = this.currentKP + amount ;
        }
    }
    public void javaProgramming(Character enemy){
        this.increaseEP(3);
        this.increaseKP(1);
        enemy.decreaseHP((100*this.getAttack())/(100+ enemy.getDefence()));
        enemy.increaseEP(2);
        if (enemy instanceof Student){
            ((Student) enemy).increaseKP(3);
        }
        if (enemy.getHP() == 0){
            this.increaseEP(4);
        }

    }
    public void selfStudy(){
        this.increaseHP(2);
        this.increaseEP(6);
        this.increaseKP(2);
    }

    public int getCurrentKP(){
        return this.currentKP;
    }

    public void generalmove(Team enemyteam){
        Character[] enemyarray = enemyteam.alivemembers();
        int rnd2 = (int) (Math.random()*(enemyarray.length));
        Character enemy = enemyarray[rnd2];
        int rnd1 = (int) (Math.random()*2);
        if (rnd1 ==0){
            this.javaProgramming(enemy);
        }
        else if (rnd1 == 1){
            this.selfStudy();
        }
    }

}
