package com.company;

import com.company.SEStudent;

public class Main {

    public static void main(String[] args) {
        MonsterTeam monsters = new MonsterTeam("monsters");
        String line = "Ardyn(Minion,1);Bahamut(Minion,1);Gilgamesh(Minion,1);Necron(Minion,1);Ultimecia(Minion,1)";
        monsters.createmonstersteam(line);
        Character[] array = monsters.getMembers();
        System.out.println(array[5].getName());











    }
}