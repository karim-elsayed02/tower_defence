

public class CSStudent extends Student {


    public CSStudent(String name){
        super(name, 7,6,6,6,4);



    }
    public void pairWorking(Character friend, Character enemy)throws Exception{
        if(currentKP < maxKP){
            throw new Exception("not enough KP go study");
        }
        this.increaseEP(4);
        this.currentKP = 0;

        enemy.decreaseHP((100 * this.getAttack()) / (100 + enemy.getDefence()));
        enemy.decreaseHP((100 * friend.getAttack()) / (100 + enemy.getDefence()));
        if(enemy.getHP() == 0){
            this.increaseEP(4);
        }
    }
    public void support(Character friend)throws Exception{
        if(currentKP < maxKP){
            throw new Exception("not enough KP");
        }
        friend.increaseHP(this.getDefence());
        this.increaseEP(4);
        this.currentKP = 0;
    }
    //usage of special moves
    public void cssMove(Team enemyteam){
        Character[] enemyarray = enemyteam.alivemembers();
        Character[] friendsarray = this.getTeam().alivemembers();
        int rnd1 = (int) (Math.random()*(friendsarray.length));
        int rnd2 = (int) (Math.random()*(enemyarray.length));
        Character friend = friendsarray[rnd1];
        Character enemy = enemyarray[rnd2];
        //deciding to use pairworking or support depnding on friends health
        if (friend.getHP() < (friend.getMaxHP()/2)){
            try {
                this.support(friend);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        else {
            try {
                this.pairWorking(friend,enemy);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
