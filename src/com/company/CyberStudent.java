
public class CyberStudent extends Student {

    public CyberStudent(String name){
        super(name, 7, 7, 5,6,6);



    }
    public void cyberAttack(Team enemyTeam)throws Exception{
        if(currentKP < maxKP){
            throw new Exception("not enough KP go study ");
        }
        currentKP = 0;
        for (Character x: enemyTeam.getMembers()) {
            x.decreaseHP((100 * this.getAttack()) / (100 + x.getDefence()));
            if (x.getHP() == 0){
                increaseEP(4);
            }

        }
        increaseEP(4);
    }
    public void cybermove(Team enemyteam){
        try {
            this.cyberAttack(enemyteam);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
