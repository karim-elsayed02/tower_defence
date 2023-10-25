

import java.util.ArrayList;

public abstract class Team {
    ArrayList<Character> members;
    private String name ;
    public Team(String name) {
        this.name = name ;
        members  = new ArrayList<Character>();
    }

    public String getName() {
        return name ;
    }
    public Character[] getMembers() {
        Character[] charray = new Character[members.size()];
        return members.toArray(charray);




    }
    public int  addMember(Character member) {
        if (this.members.contains(member)) {
            return -1;
        }
        else if (members.size() >= 5) {
            return  -2;

        }
        else {
            members.add(member);
            return members.size();
        }

    }

    public abstract void move(Character member, Team enemyTeam);
    //method to get the alive members of a team and return in them in an array of characters

    public abstract Character[] alivemembers();

}
