




public class AIStudent extends Student {




    public AIStudent(String name){
        super(name, 6, 7, 7, 5, 3 );





    }

    public void machineLearning(Character enemy)throws Exception{


        if(getCurrentKP() < maxKP){
            throw new Exception("not enough KP go study");
        }
        this.increaseEP(4);
        currentKP = 0;
        enemy.decreaseHP((2 * (100 * this.getAttack())) / (100 + enemy.getDefence()));
        if (enemy.getHP() == 0) {
            this.increaseEP(4);
        }

    }
    public void naturalLanguageProcessing()throws Exception{
        if(getCurrentKP() < maxKP){
            throw new Exception("not enough Kp");
        }
        this.increaseEP(4);
        currentKP = 0;
        this.increaseHP(this.getDefence());

    }
    public void aimove(Team enemyteam){
        Character[] enemyarray = enemyteam.alivemembers();
        int rnd2 = (int) (Math.random()*(enemyarray.length));
        Character enemy = enemyarray[rnd2];
        if (this.getHP() >(getMaxHP()/2)){
            try {
                this.machineLearning(enemy);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        else {
            try {
                this.naturalLanguageProcessing();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
