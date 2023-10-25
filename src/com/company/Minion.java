


import com.company.Monster;

import java.util.Random;

public class Minion extends Character implements Monster {

    public Minion(String name){
        super(name,5,5,5,5);



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
        Random rnd = new Random();
        int n1 = rnd.nextInt(20);
        if(0 <= n1 && n1<=1){
            this.ArrayIndexOutOfBoundException(enemy);
        }
        else if (1<n1 && n1>5){
            this.NullPointerException();
        }
        else{
            this.SyntaxError(enemy);
        }
        increaseEP(3);

    }
    public void setlvl(String lvl){
        int n = Integer.parseInt(lvl);
        this.level = n;
    }


}
