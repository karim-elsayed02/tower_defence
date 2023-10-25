

import java.util.Random;

public class Boss extends Character implements Monster {
    public Boss(String name){
        super(name,8,7,8,7);
    }

    public void SyntaxError(Character enemy){
        enemy.decreaseHP(100 * getAttack() / (100 + enemy.getDefence()));

    }

    public void NullPointerException(){
        increaseHP(getDefence());


    }

    public void ArrayIndexOutOfBoundException(Character enemy){
        enemy.decreaseHP(2*(100 * getAttack() / (100 + enemy.getDefence())));
    }

    public void strike(Character enemy){
        increaseEP(3);
        Team enemyteam = enemy.getTeam();
        Random rnd = new Random();
        int n1 = rnd.nextInt(20);
        if(0 <= n1 && n1<=2){
            this.ConcurrentModificationException(enemyteam);
        }
        else if (1<n1 && n1<4){
            this.NoneTermination();
        }
        else if (3<n1 && n1<7){
            this.SyntaxError(enemy);
        }
        else if (6<n1 && n1<10){
            this.NullPointerException();
        }
        else{
            this.SyntaxError(enemy);
        }


    }

    public void  NoneTermination(){
        Team myteam = this.getTeam();
        for (Character x: myteam.getMembers()) {

            if (x.getHP() ==0){
                x.increaseHP(x.getMaxHP());
            }

        }
    }

    public void  ConcurrentModificationException(Team enemyteam){
        for (Character x:enemyteam.getMembers()) {
            if (x.getHP() >0){
                x.decreaseHP(100 * getAttack() / (100 + x.getDefence()));
                this.increaseEP(3);
                x.increaseEP(3);

                if (x instanceof Student){
                    ((Student) x).increaseKP(3);
                }

                if (x.getHP() == 0){
                    this.increaseEP(4);
                }
            }
        }
    }
    public void setlvl(String lvl){
        int n = Integer.parseInt(lvl);
        this.level = n;
    }

}
