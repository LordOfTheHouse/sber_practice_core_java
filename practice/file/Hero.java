package practice.file;

import java.io.Serializable;

public class Hero implements Serializable{

    private static final long serialVersionUID = 1L;
    private String name;
    private int hp;
    private int attack;
    private int defense;
    private int exp;

    public Hero(String name) {
        this.name = name;
        hp = 100;
        attack = 10;
        defense = 5;
    }

    public void receivedDamage(int damage){
        if(damage > defense){
            hp -= damage + defense;
        }
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getExp() {
        return exp;
    }   

}
