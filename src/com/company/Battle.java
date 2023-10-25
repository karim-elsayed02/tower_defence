
import java.util.Arrays;

public class Battle {
    private StudentTeam thestudents;
    private MonsterTeam themonsters;
    public  Battle(StudentTeam thestudents,MonsterTeam themonsters){
        this.themonsters = themonsters;
        this.thestudents = thestudents;
    }
    public void fight(){
        Character[] students = thestudents.alivemembers();
        Character [] monsters = themonsters.alivemembers();
        Character[] fighters = new Character[students.length+ monsters.length];
        int c =0;
        for (int i=0;i<students.length;i++){
            fighters[i] = students[i];
            c++;
        }
        for (int j =0;j< monsters.length;j++){
            fighters[c++] = monsters[j];
        }
        Arrays.sort(fighters);
        int a = 0;
        while(a<30 || thestudents.alivemembers().length !=0 ||themonsters.alivemembers().length!=0){
            for (Character x:fighters) {
                if (x instanceof Student){
                    thestudents.move(x,themonsters);
                }
                else{
                    themonsters.move(x,thestudents);
                }
            }
            a++;
            if(thestudents.alivemembers().length == 0){
                System.out.println("monsters won the battle");
            }
            else if (themonsters.alivemembers().length==0){
                System.out.println("students won the battle");
            }
        }
        }

}
