

public class SEStudent extends Student {


    Team myteam = this.getTeam();
    public SEStudent(String name){
        super(name,8,5,8,4,10);



    }
    public void groupWork(Character enemy)throws Exception {
        if (currentKP != maxKP) {
            throw new Exception("not enough KP go study");
        }
        increaseEP(4);
        currentKP = 0;
        Team myteam = this.getTeam();
        for (Character x : myteam.getMembers()) {
            if (x.getHP() > 0) {
                enemy.decreaseHP((100 * x.getAttack()) / (100 + enemy.getDefence()));
            }

            if (enemy.getHP() == 0){
                increaseEP(4);
            }
        }
    }

    /**
     *
     * @throws Exception
     */
    public void groupDiscussion()throws Exception {
        if (currentKP != maxKP) {
            throw new Exception("not enough KP go study");
        } else {
            this.increaseEP(4);
            currentKP = 0;
            for (Character x : this.getTeam().getMembers()) {
                if (x.getHP() > 0) {
                    x.increaseHP(this.getDefence() / 2);
                }
            }
        }
    }
    public void semove(Team enemyteam){
        Character[] enemyarray = enemyteam.alivemembers();
        int rnd1 = (int) (Math.random()*(enemyarray.length));
        Character enemy = enemyarray[rnd1];
        Character[] myteam = this.getTeam().alivemembers();
        int count = 0;
        for (Character x:myteam) {
            if (x.getHP() >(x.getMaxHP()/2)){
                count ++;
            }
        }
        if ((myteam.length)>3){
            try {
                this.groupWork(enemy);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if((myteam.length) > 1 && count>1){
            try {
                this.groupWork(enemy);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if ((myteam.length)==1 && count==1){
            try {
                this.groupWork(enemy);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            try {
                this.groupDiscussion();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
