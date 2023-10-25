

import java.util.ArrayList;

public class Guild {
    ArrayList<Character> guildmembers;
    public Guild() {
        guildmembers = new ArrayList<Character>();
        this.addMember(new CSStudent("csstudent1"));
        this.addMember(new AIStudent("aistudent1"));
        this.addMember(new SEStudent("sestudent1"));
        this.addMember(new CyberStudent("cyberstudent1"));
        this.addMember(new CSStudent("csstudent2"));
        this.addMember(new AIStudent("aistudent2"));
        this.addMember(new SEStudent("sestudent2"));
        this.addMember(new CyberStudent("cyberstudent2"));
    }
    public void addMember(Character member){
        guildmembers.add(member);
    }
    public Character[] getMembers(){
        Character[] charray = new Character[guildmembers.size()];
        return guildmembers.toArray(charray);
    }
    // returns alive memebrs in the guild
    public Character[] guildealive(){
        ArrayList<Character> alive = new ArrayList<Character>();
        //for loop to add alive members into another arraylist
        for (Character x:guildmembers) {
            // if statment to check if members are alive
            if (x.getHP() > 0){
                alive.add(x);
            }

        }
        //turning alive arraylist into an array of characters
        Character[] array = new Character[alive.size()];
        return alive.toArray(array);

    }
    public StudentTeam getTeam(Team enemyteam){
        StudentTeam team1 = new StudentTeam("student team");
        Character[] enemy =  enemyteam.alivemembers();
        for (Character x:this.guildealive()) {
            //adding only alive members and making sure size of team not more than 5
            if (team1.getMembers().length<6){
                team1.addMember(x);
            }

        }
        return team1;
    }
}
